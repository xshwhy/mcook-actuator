package com.iotmars.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author liubin
 * @create 2021-03-01
 */
@Data
@Accessors(chain = true)
public class Cookbook implements Serializable {
    private static final long serialVersionUID = -1422608563982419864L;

    @JsonProperty("CookbookId")
    private Integer cookbookId;

    @JsonProperty("CookbookName")
    private String cookbookName;

    @JsonProperty("CookbookIntro")
    private CookbookIntro cookbookIntro;

    @JsonProperty("CookbookParam")
    private List<CookbookParam> cookbookParam;
}
