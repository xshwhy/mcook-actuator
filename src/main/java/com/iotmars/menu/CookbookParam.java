package com.iotmars.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author liubin
 * @create 2021-03-01
 */
@Data
@Accessors(chain = true)
public class CookbookParam implements Serializable {
    private static final long serialVersionUID = -195038910315801347L;

    @JsonProperty("Valid")
    private Integer valid;

    @JsonProperty("Paused")
    private Integer paused;

    @JsonProperty("RemindText")
    private String remindText;

    @JsonProperty("Mode")
    private Integer mode;

    @JsonProperty("Temp")
    private Integer temp;

    @JsonProperty("Timer")
    private Integer timer;

    @JsonProperty("SteamTime")
    private Integer steamTime;

    @JsonProperty("FanTime")
    private Integer fanTime;

    @JsonProperty("WaterTime")
    private Integer waterTime;

}
