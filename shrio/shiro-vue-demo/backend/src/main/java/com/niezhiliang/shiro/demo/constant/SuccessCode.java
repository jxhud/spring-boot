package com.niezhiliang.shiro.demo.constant;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:45
 */
public enum SuccessCode {

    SuccessCode(100,"请求成功");
    private int code;

    private String msg;

    SuccessCode() {
    }

    SuccessCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
