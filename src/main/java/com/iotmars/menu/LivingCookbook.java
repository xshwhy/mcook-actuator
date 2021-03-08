package com.iotmars.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: xsh
 * @date: 2021/3/1 19:31
 */
@Data
@Accessors(chain = true)
public class LivingCookbook{

    @JsonProperty("CookbookId")
    private Integer cookbookId;

    @JsonProperty("CookbookName")
    private String cookbookName;

    @JsonProperty("CookbookIntro")
    private CookbookIntro cookbookIntro;

    @JsonProperty("CookbookParam")
    private List<CookbookParam> cookbookParam;

    @JsonProperty("MultiMode")
    Integer multiMode;

    @JsonProperty("StOvOperation")
    Integer stOvOperation;

}
