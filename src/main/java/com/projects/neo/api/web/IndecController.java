package com.projects.neo.api.web;

import com.projects.neo.api.dao.HanyunRoleDao;
import com.projects.neo.api.domain.HanyunRole;
import com.projects.neo.api.service.IndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "")
public class IndecController {

    @Resource
    private IndexService indexService;
    @Resource
    private HanyunRoleDao hanyunRoleDao;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    @RequestMapping("/select")
    public Object selectInfo(){
        return   indexService.selectInfo();
    }
    @RequestMapping("/look")
    public Object selectInfos(){
        return hanyunRoleDao.selectSelective(new HanyunRole());
    }
}
