package com.dao;

import com.entity.BizhiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BizhiCollectionView;

/**
 * 壁纸收藏 Dao 接口
 *
 * @author 
 */
public interface BizhiCollectionDao extends BaseMapper<BizhiCollectionEntity> {

   List<BizhiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
