package com.projects.neo.link;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Arrays;

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
 * @date 2018/5/17 9:31
 */
public class RequestLink implements Serializable {


    private static final String DEFAULT_FORMAT = "【%s】%s";

    private String[] to;

    private String title;
    @JsonProperty("link_name")
    private String linkName;

    @NotEmpty
    private String content;


    public String[] getTo() {
        return to;
    }

    public static String getDefaultFormat() {
        return DEFAULT_FORMAT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getContent() {
        return String.format(DEFAULT_FORMAT,this.title,this.linkName);
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RequestLink{" +
                "to=" + Arrays.toString(to) +
                ", title='" + title + '\'' +
                ", linkName='" + linkName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
