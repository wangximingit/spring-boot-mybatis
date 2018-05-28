package com.projects.neo.api.domain;

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
 * @date 2018/4/18 14:47
 */
public class Singer {

    private static Singer singer;

    private  Singer(){

    }

    private static Singer getSinger(){
        if(singer == null){
            singer = new Singer();
        }
        return singer;
    }

}
