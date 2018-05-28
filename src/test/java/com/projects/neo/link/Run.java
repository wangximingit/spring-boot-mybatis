package com.projects.neo.link;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * __
 * ,-~¨^  ^¨-,           _,
 * /          / ;^-._...,¨/
 * /          / /         /
 * /          / /         /
 * /          / /         /
 * /,.-:''-,_ / /         /
 * _,.-:--._ ^ ^:-._ __../
 * /^         / /¨:.._¨__.;
 * /          / /      ^  /
 * /          / /         /
 * /          / /         /
 * /_,.--:^-._/ /         /
 * ^            ^¨¨-.___.:^
 *
 * @author WangXiMin
 * @date 2018/5/17 9:28
 */

public class Run {
    private static final LinkedBlockingQueue<RequestLink> QUEUE = new LinkedBlockingQueue<>(10000);
    private static final Logger LOGGER = LoggerFactory.getLogger(Run.class);

    private static final String DEFAULT_TITLE= "默认标题";
    private static final String DEFAULT_NAME= "默认名称";
    private static  int COUNT = 0;

    private static  void LinkSms(RequestLink requestLink){
        if (null != requestLink) {
            requestLink.setLinkName(DEFAULT_NAME);
            requestLink.setTitle(requestLink.getTitle()+DEFAULT_TITLE);
            QUEUE.offer(requestLink);
            LOGGER.debug("插入短信队列, 收件人: {}, 短信标签: {}", requestLink.getLinkName(), requestLink.getTitle());
        }

    }
    @Scheduled(cron = "0 1/1 * * * ?")
    public void exec() {
        RequestLink queue = QUEUE.poll();
        if (null != queue) {
            LOGGER.debug("获取发送消息任务, 持久化消息");
            sendSms(queue);
        }
    }

    private void sendSms(RequestLink request) {
        System.out.println(++COUNT);
        System.out.println(request.toString());
    }
    @Test
    public  void mains() {
        RequestLink requestLink;
        for (int i=1;i<10;i++) {
            requestLink = new RequestLink();
            requestLink.setTitle(String.valueOf(i));
            requestLink.setLinkName("队列消息"+String.valueOf(i));
            LinkSms(requestLink);
        }
        exec();
    }
}
