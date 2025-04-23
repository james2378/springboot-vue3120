package com.entity.view;

import com.entity.BizhiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 壁纸收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bizhi_collection")
public class BizhiCollectionView extends BizhiCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String bizhiCollectionValue;



		//级联表 bizhi
			/**
			* 壁纸名称
			*/
			private String bizhiName;
			/**
			* 壁纸类型
			*/
			private Integer bizhiTypes;
				/**
				* 壁纸类型的值
				*/
				private String bizhiValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public BizhiCollectionView() {

	}

	public BizhiCollectionView(BizhiCollectionEntity bizhiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, bizhiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getBizhiCollectionValue() {
				return bizhiCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setBizhiCollectionValue(String bizhiCollectionValue) {
				this.bizhiCollectionValue = bizhiCollectionValue;
			}




				//级联表的get和set bizhi

					/**
					* 获取： 壁纸名称
					*/
					public String getBizhiName() {
						return bizhiName;
					}
					/**
					* 设置： 壁纸名称
					*/
					public void setBizhiName(String bizhiName) {
						this.bizhiName = bizhiName;
					}

					/**
					* 获取： 壁纸类型
					*/
					public Integer getBizhiTypes() {
						return bizhiTypes;
					}
					/**
					* 设置： 壁纸类型
					*/
					public void setBizhiTypes(Integer bizhiTypes) {
						this.bizhiTypes = bizhiTypes;
					}


						/**
						* 获取： 壁纸类型的值
						*/
						public String getBizhiValue() {
							return bizhiValue;
						}
						/**
						* 设置： 壁纸类型的值
						*/
						public void setBizhiValue(String bizhiValue) {
							this.bizhiValue = bizhiValue;
						}

					/**
					* 获取： 壁纸
					*/
					public String getBizhiPhoto() {
						return bizhiPhoto;
					}
					/**
					* 设置： 壁纸
					*/
					public void setBizhiPhoto(String bizhiPhoto) {
						this.bizhiPhoto = bizhiPhoto;
					}

					/**
					* 获取： 下载数量
					*/
					public Integer getBizhiDnumber() {
						return bizhiDnumber;
					}
					/**
					* 设置： 下载数量
					*/
					public void setBizhiDnumber(Integer bizhiDnumber) {
						this.bizhiDnumber = bizhiDnumber;
					}

					/**
					* 获取： 壁纸详情
					*/
					public String getBizhiContent() {
						return bizhiContent;
					}
					/**
					* 设置： 壁纸详情
					*/
					public void setBizhiContent(String bizhiContent) {
						this.bizhiContent = bizhiContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getBizhiDelete() {
						return bizhiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setBizhiDelete(Integer bizhiDelete) {
						this.bizhiDelete = bizhiDelete;
					}



















				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
