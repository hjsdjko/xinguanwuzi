package com.dao;

import com.entity.WuziFafangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuziFafangView;

/**
 * 物资发放 Dao 接口
 *
 * @author 
 */
public interface WuziFafangDao extends BaseMapper<WuziFafangEntity> {

   List<WuziFafangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
