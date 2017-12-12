package com.example.shop.common.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/10.
 */
@Setter
@Getter
public class JsonResult {
    private boolean success = true;
    private String msg;

    public void mark(String errorMsg) {
        this.success = false;
        this.msg = errorMsg;
    }


    public boolean isSuccess() {
        return this.success;
    }

    public String getMsg() {
        return this.msg;
    }
}