package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 壁纸信息
 *
 * @author 
 * @email
 */
@TableName("bizhi")
public class BizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BizhiEntity() {

	}

	public BizhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bizhi{" +
            "id=" + id +
            ", bizhiName=" + bizhiName +
            ", bizhiTypes=" + bizhiTypes +
            ", bizhiPhoto=" + bizhiPhoto +
            ", bizhiDnumber=" + bizhiDnumber +
            ", bizhiContent=" + bizhiContent +
            ", bizhiDelete=" + bizhiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
