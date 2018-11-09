package com.niezhiliang.shiro.demo.exception;

import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.constant.ReturnMo;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午12:27
 */
@RestControllerAdvice
public class GlobalHandleException extends RuntimeException {

    private final static Logger logger = LoggerFactory.getLogger(GlobalHandleException.class);

    /**
     * 处理所有的系统异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object SystemErrorHandler(Exception e) throws Exception {
        String errorPosition = "";
        //如果错误堆栈信息存在
        if (e.getStackTrace().length > 0) {
            StackTraceElement element = e.getStackTrace()[0];
            String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
            int lineNumber = element.getLineNumber();
            errorPosition = fileName + ":" + lineNumber;
        }
        ReturnMo returnMo = new ReturnMo();
        returnMo.setCode(ErrorCode.E_400.getCode());
        returnMo.setMsg(ErrorCode.E_400.getMsg());
        returnMo.setData(e.toString() + "    错误位置:" + errorPosition);
        logger.error("异常", e);
        return returnMo;
    }

    /**
     * 处理所有的业务逻辑异常
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = CommonJsonException.class)
    @ResponseBody
    public String BusinessErrorHandler(CommonJsonException e) throws Exception {
        return e.getResultJson();
    }

    /**
     * 权限不足报错拦截
     *
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public String unauthorizedExceptionHandler() throws Exception {
        return CommonUtils.errorJson(ErrorCode.E_502);
    }

}
