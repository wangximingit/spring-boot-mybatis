package com.projects.neo.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.projects.neo.api.dao.HanyunRoleDao;
import com.projects.neo.api.domain.HanyunRole;
import com.projects.neo.api.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/3.
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Resource
    private HanyunRoleDao hanyunRoleDao;

    public Map selectInfo() {
        PageHelper.startPage(1, 5);
        List<HanyunRole> list =   hanyunRoleDao.selectSelective(new HanyunRole());
        PageInfo<HanyunRole> p=new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("p",p);
        return map;
    }
}
