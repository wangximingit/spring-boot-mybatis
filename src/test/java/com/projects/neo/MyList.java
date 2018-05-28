package com.projects.neo;

import java.util.ArrayList;
import java.util.List;

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
 * @date 2018/5/7 13:56
 */
public class MyList {

    private static List list = new ArrayList();

    public static void add() {
        list.add("我是元素");
    }

    public static int size() {
        return list.size();
    }
}
