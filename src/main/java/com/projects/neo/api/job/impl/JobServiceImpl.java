package com.projects.neo.api.job.impl;

import com.projects.neo.api.job.JobService;
import com.projects.neo.api.request.RequestLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
 * @date 2018/5/18 14:55
 */
@Component
public class JobServiceImpl implements JobService{

    private static final LinkedBlockingQueue<RequestLink> QUEUE = new LinkedBlockingQueue<>(10000);
    private static final Logger LOGGER = LoggerFactory.getLogger(JobServiceImpl.class);
    private static  int COUNT = 0;


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
}
