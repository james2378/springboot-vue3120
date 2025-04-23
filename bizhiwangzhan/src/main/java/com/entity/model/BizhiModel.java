package com.entity.model;

import com.entity.BizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 壁纸信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 壁纸名称
     */
    private String bizhiName;


    /**
     * 壁纸类型
     */
    private Integer bizhiTypes;


    /**
     * 壁纸
     */
    private String bizhiPhoto;


    /**
     * 下载数量
     */
    private Integer bizhiDnumber;


    /**
     * 壁纸详情
     */
    private String bizhiContent;


    /**
     * 逻辑删除
     */
    private Integer bizhiDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：壁纸名称
	 */
    public String getBizhiName() {
        return bizhiName;
    }


    /**
	 * 设置：壁纸名称
	 */
    public void setBizhiName(String bizhiName) {
        this.bizhiName = bizhiName;
    }
    /**
	 * 获取：壁纸类型
	 */
    public Integer getBizhiTypes() {
        return bizhiTypes;
    }


    /**
	 * 设置：壁纸类型
	 */
    public void setBizhiTypes(Integer bizhiTypes) {
        this.bizhiTypes = bizhiTypes;
    }
    /**
	 * 获取：壁纸
	 */
    public String getBizhiPhoto() {
        return bizhiPhoto;
    }


    /**
	 * 设置：壁纸
	 */
    public void setBizhiPhoto(String bizhiPhoto) {
        this.bizhiPhoto = bizhiPhoto;
    }
    /**
	 * 获取：下载数量
	 */
    public Integer getBizhiDnumber() {
        return bizhiDnumber;
    }


    /**
	 * 设置：下载数量
	 */
    public void setBizhiDnumber(Integer bizhiDnumber) {
        this.bizhiDnumber = bizhiDnumber;
    }
    /**
	 * 获取：壁纸详情
	 */
    public String getBizhiContent() {
        return bizhiContent;
    }


    /**
	 * 设置：壁纸详情
	 */
    public void setBizhiContent(String bizhiContent) {
        this.bizhiContent = bizhiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getBizhiDelete() {
        return bizhiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setBizhiDelete(Integer bizhiDelete) {
        this.bizhiDelete = bizhiDelete;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
