package com.projects.neo.api.web;

import com.projects.neo.api.dao.HanyunRoleDao;
import com.projects.neo.api.domain.HanyunRole;
import com.projects.neo.api.request.RequestLink;
import com.projects.neo.api.service.IndexService;
//import com.projects.neo.api.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping(value = "")
public class IndecController {
    private static final LinkedBlockingQueue<RequestLink> QUEUE = new LinkedBlockingQueue<>(10000);
    private static final Logger LOGGER = LoggerFactory.getLogger(IndecController.class);

    @Resource
    private IndexService indexService;
    @Resource
    private HanyunRoleDao hanyunRoleDao;
//    @Resource
//    private RedisService redisService;
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;


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

//    //并发访问重复判断
//    @RequestMapping("/sms")
//    public Object redisRequest(){
//        HashMap resultMap = new HashMap();
//        String redisKey = "SMS_LIMIT" ;
//        long count = redisTemplate.opsForValue().increment(redisKey, 1);
//        if (count == 1) {
//                //设置有效期一分钟
//            redisTemplate.expire(redisKey, 60, TimeUnit.SECONDS);
//        }
//
//        if (count > 1) {
//            resultMap.put("retCode", "-1");
//            resultMap.put("retMsg", "每分钟只能发送一次短信");
//            return resultMap;
//        }
//        resultMap.put("retCode", "0");
//        resultMap.put("retMsg", "成功");
//        return resultMap;
//    }

    @RequestMapping("/looks")
    public Object selectSms(){
        RequestLink requestLink;
        for (int i=1;i<10;i++) {
            requestLink = new RequestLink();
            requestLink.setTitle(String.valueOf(i));
            requestLink.setLinkName("队列消息"+String.valueOf(i));
            LinkSms(requestLink);
        }
        return null;
    }

    private static final String DEFAULT_TITLE= "默认标题";
    private static final String DEFAULT_NAME= "默认名称";
    private   void LinkSms(RequestLink requestLink){
        if (null != requestLink) {
            requestLink.setLinkName(DEFAULT_NAME);
            requestLink.setTitle(requestLink.getTitle()+DEFAULT_TITLE);
            QUEUE.offer(requestLink);
            System.out.println("插入短信队列, 收件人: {}, 短信标签: {}"+requestLink.getLinkName()+requestLink.getTitle());
            LOGGER.debug("插入短信队列, 收件人: {}, 短信标签: {}", requestLink.getLinkName(), requestLink.getTitle());
        }

    }

}
