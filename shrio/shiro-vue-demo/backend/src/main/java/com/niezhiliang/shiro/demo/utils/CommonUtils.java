package com.niezhiliang.shiro.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.constant.ReturnMo;
import com.niezhiliang.shiro.demo.constant.SuccessCode;
import com.niezhiliang.shiro.demo.exception.CommonJsonException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:03
 */
public class CommonUtils {

    /**
     * 验证是否含有全部必填字段
     *
     * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
     * @param jsonObject
     * @return
     */
    public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
        if (!StringTools.isNullOrEmpty(requiredColumns)) {
            //验证字段非空
            String[] columns = requiredColumns.split(",");
            String missCol = "";
            for (String column : columns) {
                Object val = jsonObject.get(column.trim());
                if (StringTools.isNullOrEmpty(val)) {
                    missCol += column + "  ";
                }
            }
            if (!StringTools.isNullOrEmpty(missCol)) {
                ReturnMo returnMo = new ReturnMo();
                returnMo.setCode(ErrorCode.E_90003.getCode());
                returnMo.setMsg("缺少必填参数:" + missCol.trim());
                throw new CommonJsonException(JSONObject.toJSONString(returnMo));
            }
        }
    }

    /**
     * 返回错误信息
     * @param errorCode
     * @return
     */
    public static String errorJson(ErrorCode errorCode) {
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(errorCode.getCode());
        returnMo.setMsg(errorCode.getMsg());
        return JSON.toJSONString(returnMo);
    }

    /**
     * 返回成功信息
     * @param
     * @return
     */
    public static String successJson() {
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(SuccessCode.SuccessCode.getCode());
        return JSON.toJSONString(returnMo);
    }

    /**
     * 返回成功信息
     * @param msg
     * @return
     */
    public static String successJson(String msg) {
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(SuccessCode.SuccessCode.getCode());
        returnMo.setMsg(msg);
        return JSON.toJSONString(returnMo);
    }

    /**
     * 返回成功信息
     * @param msg
     * @param object
     * @return
     */
    public static String successJson(String msg,Object object) {
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(SuccessCode.SuccessCode.getCode());
        returnMo.setMsg(msg);
        returnMo.setData(object);
        return JSON.toJSONString(returnMo);
    }

    /**
     * 返回成功信息
     * @param object
     * @return
     */
    public static String successJson(Object object) {
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(SuccessCode.SuccessCode.getCode());
        returnMo.setData(object);
        return JSON.toJSONString(returnMo);
    }



}
