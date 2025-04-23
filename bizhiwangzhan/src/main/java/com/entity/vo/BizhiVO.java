package com.entity.vo;

import com.entity.BizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 壁纸信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bizhi")
public class BizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 壁纸名称
     */

    @TableField(value = "bizhi_name")
    private String bizhiName;


    /**
     * 壁纸类型
     */

    @TableField(value = "bizhi_types")
    private Integer bizhiTypes;


    /**
     * 壁纸
     */

    @TableField(value = "bizhi_photo")
    private String bizhiPhoto;


    /**
     * 下载数量
     */

    @TableField(value = "bizhi_dnumber")
    private Integer bizhiDnumber;


    /**
     * 壁纸详情
     */

    @TableField(value = "bizhi_content")
    private String bizhiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "bizhi_delete")
    private Integer bizhiDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：壁纸名称
	 */
    public String getBizhiName() {
        return bizhiName;
    }


    /**
	 * 获取：壁纸名称
	 */

    public void setBizhiName(String bizhiName) {
        this.bizhiName = bizhiName;
    }
    /**
	 * 设置：壁纸类型
	 */
    public Integer getBizhiTypes() {
        return bizhiTypes;
    }


    /**
	 * 获取：壁纸类型
	 */

    public void setBizhiTypes(Integer bizhiTypes) {
        this.bizhiTypes = bizhiTypes;
    }
    /**
	 * 设置：壁纸
	 */
    public String getBizhiPhoto() {
        return bizhiPhoto;
    }


    /**
	 * 获取：壁纸
	 */

    public void setBizhiPhoto(String bizhiPhoto) {
        this.bizhiPhoto = bizhiPhoto;
    }
    /**
	 * 设置：下载数量
	 */
    public Integer getBizhiDnumber() {
        return bizhiDnumber;
    }


    /**
	 * 获取：下载数量
	 */

    public void setBizhiDnumber(Integer bizhiDnumber) {
        this.bizhiDnumber = bizhiDnumber;
    }
    /**
	 * 设置：壁纸详情
	 */
    public String getBizhiContent() {
        return bizhiContent;
    }


    /**
	 * 获取：壁纸详情
	 */

    public void setBizhiContent(String bizhiContent) {
        this.bizhiContent = bizhiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getBizhiDelete() {
        return bizhiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setBizhiDelete(Integer bizhiDelete) {
        this.bizhiDelete = bizhiDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
