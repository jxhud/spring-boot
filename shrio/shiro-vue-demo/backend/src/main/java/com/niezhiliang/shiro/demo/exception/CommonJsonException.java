package com.niezhiliang.shiro.demo.exception;

import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.utils.CommonUtils;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午12:23
 */
public class CommonJsonException extends RuntimeException {
    private String resultJson;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     *
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public CommonJsonException(ErrorCode errorEnum) {
        this.resultJson = CommonUtils.errorJson(errorEnum);
    }

    public CommonJsonException(String resultJson) {
        this.resultJson = resultJson;
    }

    public String getResultJson() {
        return resultJson;
    }
}
