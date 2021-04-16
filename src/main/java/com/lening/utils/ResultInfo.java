package com.lening.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建时间: 2021-04-13 下午 01:56
 * 撩妹贼溜: 肖彬
 */

@Data
public class ResultInfo implements Serializable {
    private boolean flag;
    private String msg;

    public ResultInfo() {
    }
    public ResultInfo(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
