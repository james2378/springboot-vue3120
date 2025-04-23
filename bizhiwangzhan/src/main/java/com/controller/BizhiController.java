
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 壁纸信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bizhi")
public class BizhiController {
    private static final Logger logger = LoggerFactory.getLogger(BizhiController.class);

    @Autowired
    private BizhiService bizhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("bizhiDeleteStart",1);params.put("bizhiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bizhiService.queryPage(params);

        //字典表数据转换
        List<BizhiView> list =(List<BizhiView>)page.getList();
        for(BizhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BizhiEntity bizhi = bizhiService.selectById(id);
        if(bizhi !=null){
            //entity转view
            BizhiView view = new BizhiView();
            BeanUtils.copyProperties( bizhi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BizhiEntity bizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bizhi:{}",this.getClass().getName(),bizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BizhiEntity> queryWrapper = new EntityWrapper<BizhiEntity>()
            .eq("bizhi_name", bizhi.getBizhiName())
            .eq("bizhi_types", bizhi.getBizhiTypes())
            .eq("bizhi_dnumber", bizhi.getBizhiDnumber())
            .eq("bizhi_delete", bizhi.getBizhiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BizhiEntity bizhiEntity = bizhiService.selectOne(queryWrapper);
        if(bizhiEntity==null){
            bizhi.setBizhiDelete(1);
            bizhi.setCreateTime(new Date());
            bizhiService.insert(bizhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BizhiEntity bizhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bizhi:{}",this.getClass().getName(),bizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<BizhiEntity> queryWrapper = new EntityWrapper<BizhiEntity>()
            .notIn("id",bizhi.getId())
            .andNew()
            .eq("bizhi_name", bizhi.getBizhiName())
            .eq("bizhi_types", bizhi.getBizhiTypes())
            .eq("bizhi_dnumber", bizhi.getBizhiDnumber())
            .eq("bizhi_delete", bizhi.getBizhiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BizhiEntity bizhiEntity = bizhiService.selectOne(queryWrapper);
        if("".equals(bizhi.getBizhiPhoto()) || "null".equals(bizhi.getBizhiPhoto())){
                bizhi.setBizhiPhoto(null);
        }
        if(bizhiEntity==null){
            bizhiService.updateById(bizhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<BizhiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            BizhiEntity bizhiEntity = new BizhiEntity();
            bizhiEntity.setId(id);
            bizhiEntity.setBizhiDelete(2);
            list.add(bizhiEntity);
        }
        if(list != null && list.size() >0){
            bizhiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BizhiEntity> bizhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BizhiEntity bizhiEntity = new BizhiEntity();
//                            bizhiEntity.setBizhiName(data.get(0));                    //壁纸名称 要改的
//                            bizhiEntity.setBizhiTypes(Integer.valueOf(data.get(0)));   //壁纸类型 要改的
//                            bizhiEntity.setBizhiPhoto("");//详情和图片
//                            bizhiEntity.setBizhiDnumber(Integer.valueOf(data.get(0)));   //下载数量 要改的
//                            bizhiEntity.setBizhiContent("");//详情和图片
//                            bizhiEntity.setBizhiDelete(1);//逻辑删除字段
//                            bizhiEntity.setCreateTime(date);//时间
                            bizhiList.add(bizhiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        bizhiService.insertBatch(bizhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = bizhiService.queryPage(params);

        //字典表数据转换
        List<BizhiView> list =(List<BizhiView>)page.getList();
        for(BizhiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BizhiEntity bizhi = bizhiService.selectById(id);
            if(bizhi !=null){


                //entity转view
                BizhiView view = new BizhiView();
                BeanUtils.copyProperties( bizhi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BizhiEntity bizhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bizhi:{}",this.getClass().getName(),bizhi.toString());
        Wrapper<BizhiEntity> queryWrapper = new EntityWrapper<BizhiEntity>()
            .eq("bizhi_name", bizhi.getBizhiName())
            .eq("bizhi_types", bizhi.getBizhiTypes())
            .eq("bizhi_dnumber", bizhi.getBizhiDnumber())
            .eq("bizhi_delete", bizhi.getBizhiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BizhiEntity bizhiEntity = bizhiService.selectOne(queryWrapper);
        if(bizhiEntity==null){
            bizhi.setBizhiDelete(1);
            bizhi.setCreateTime(new Date());
        bizhiService.insert(bizhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
