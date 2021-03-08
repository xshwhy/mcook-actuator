package com.iotmars.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liubin
 * @create 2021-03-01
 */
@Data
public class CookbookIntro implements Serializable {
    private static final long serialVersionUID = -2577629283052972551L;

    @JsonProperty("Intro")
    private String intro;

    @JsonProperty("Materials")
    private String materials;

    @JsonProperty("Steps")
    private String steps;
}
