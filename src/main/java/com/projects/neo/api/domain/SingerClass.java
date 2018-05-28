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
 * @date 2018/5/8 14:06
 */
public class SingerClass {

//    private static class SingerClassH {
//        private static final SingerClass instance = new SingerClass();
//    }
//
//    private void SingerClass(){
//
//    }
//
//    public static SingerClass getInstance(){
//        return SingerClassH.instance;
//    }





































    private static  class SingerClassH{
        private static final SingerClass instance = new SingerClass();
    }
    public SingerClass (){

    }
    public static SingerClass getInstance (){
        return SingerClassH.instance;
    }
}
