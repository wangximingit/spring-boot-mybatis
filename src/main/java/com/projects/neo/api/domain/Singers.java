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
 * @date 2018/4/18 14:53
 */
public class Singers {

    private static Singers singers;

    private Singers(){

    }
    private static synchronized Singers getSingers(){
        if(singers==null){
            singers = new Singers();
        }
        return singers;
    }

}
