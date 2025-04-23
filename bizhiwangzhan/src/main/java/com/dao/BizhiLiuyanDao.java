package com.dao;

import com.entity.BizhiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BizhiLiuyanView;

/**
 * 壁纸留言 Dao 接口
 *
 * @author 
 */
public interface BizhiLiuyanDao extends BaseMapper<BizhiLiuyanEntity> {

   List<BizhiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
