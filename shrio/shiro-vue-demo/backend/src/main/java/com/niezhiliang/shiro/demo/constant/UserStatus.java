package com.niezhiliang.shiro.demo.constant;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午2:35
 */
public enum UserStatus {
    /**
     * 账号正常
     */
    USER_STATUS_ENABLE((byte)0),
    /**
     * 账号锁定
     */
    USER_STATUS_UNABLE((byte)1),
    ;

    UserStatus(Byte value) {
        this.value = value;
    }

    private Byte value;

    public Byte getValue() {
        return value;
    }
}
