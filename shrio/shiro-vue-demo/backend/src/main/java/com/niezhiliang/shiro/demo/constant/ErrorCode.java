package com.niezhiliang.shiro.demo.constant;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:36
 */
public enum ErrorCode {

    /***    /*
     * 错误信息
     * */
    E_101(101,"用户名或密码错误"),
    E_400(400, "请求处理异常，请稍后再试"),
    E_500(500, "请求方式有误,请检查 GET/POST"),
    E_501(501, "请求路径不存在"),
    E_502(403, "权限不足"),
    E_10008(10008, "角色删除失败,尚有用户属于此角色"),
    E_10009(10009, "账户已存在"),
    E_20011(20011, "登陆已过期,请重新登陆"),
    E_90003(90003, "缺少必填参数");

    private int code;

    private String msg;

    ErrorCode() {
    }

    ErrorCode(int code, String msg) {
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
