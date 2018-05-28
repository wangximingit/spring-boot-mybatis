package com.projects.neo;

import com.projects.neo.api.domain.SingerClass;

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
 * @date 2018/5/8 14:18
 */
public class TestSinger {


    public static void main(String[] args) {


        for (int i=0;i<10;i++){
            System.out.println(SingerClass.getInstance());
        }
    }
}
