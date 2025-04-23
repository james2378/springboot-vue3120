package com.entity.view;

import com.entity.BizhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 壁纸信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bizhi")
public class BizhiView extends BizhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 壁纸类型的值
		*/
		private String bizhiValue;



	public BizhiView() {

	}

	public BizhiView(BizhiEntity bizhiEntity) {
		try {
			BeanUtils.copyProperties(this, bizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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










}
