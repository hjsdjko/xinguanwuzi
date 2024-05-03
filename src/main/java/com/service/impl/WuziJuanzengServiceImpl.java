package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.WuziJuanzengDao;
import com.entity.WuziJuanzengEntity;
import com.service.WuziJuanzengService;
import com.entity.view.WuziJuanzengView;

/**
 * 物资捐赠 服务实现类
 */
@Service("wuziJuanzengService")
@Transactional
public class WuziJuanzengServiceImpl extends ServiceImpl<WuziJuanzengDao, WuziJuanzengEntity> implements WuziJuanzengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WuziJuanzengView> page =new Query<WuziJuanzengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
