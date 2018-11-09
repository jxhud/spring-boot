//package com.niezhiliang.shiro.demo.annotation;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.niezhiliang.shiro.demo.domain.LogsWithBLOBs;
//import com.niezhiliang.shiro.demo.domain.User;
//import com.niezhiliang.shiro.demo.service.LoginService;
//import com.niezhiliang.shiro.demo.service.LogsService;
//import com.niezhiliang.shiro.demo.utils.HttpContextUtils;
//import com.niezhiliang.shiro.demo.utils.IpUtil;
//import org.apache.shiro.SecurityUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.Serializable;
//import java.lang.reflect.Method;
//import java.util.*;
//
///**
// * @Author NieZhiLiang
// * @Email nzlsgg@163.com
// */
//@Component
//@Aspect
//public class LogAspect {
//    private Logger logger = LoggerFactory.getLogger(LogAspect.class);
//    @Autowired
//    private LogsService logsService;
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    private LoginService loginService;
//
//    @Pointcut("@annotation(com.niezhiliang.shiro.demo.annotation.Log)")
//    public void pointcut() { }
//
//
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
//        Object result = null;
//        long beginTime = System.currentTimeMillis();
//        MethodSignature signature = (MethodSignature) point.getSignature();
//        Method method = signature.getMethod();
//        Log log = method.getAnnotation(Log.class);
//        try {
//            // 执行方法
//            result = point.proceed();
//        } catch (Throwable e) {
//            logger.error(e.getMessage());
//        }
//        // 获取request
//        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//        String ip = IpUtil.getIpAddress(request);
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//        // 执行时长(毫秒)
//        long time = System.currentTimeMillis() - beginTime;
//        // 请求的类名
//        //String className = point.getTarget().getClass().getName();
//        // 请求的方法名
//        //String methodName = signature.getName();
//        //log.setMethod(className + "." + methodName + "()");
//        // 请求的方法参数值
//        Object[] args = point.getArgs();
//        // 请求的方法参数名称
//        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
//        LogsWithBLOBs logsWithBLOBs = new LogsWithBLOBs();
//        String[] paramNames = u.getParameterNames(method);
//        if (args != null && paramNames != null) {
//            StringBuilder params = new StringBuilder();
//            params = handleParams(params, args, Arrays.asList(paramNames));
//            logsWithBLOBs.setParams(params.toString());
//        }
//        // 保存日志
//        logsWithBLOBs.setDescript(log.value());
//        logsWithBLOBs.setOperateTime(new Date());
//        logsWithBLOBs.setSpendTime(Long.valueOf(time).intValue());
//        logsWithBLOBs.setUserId(user.getUserId());
//        if (result != null) {
//            logsWithBLOBs.setReturnContent(result.toString());
//        }
//        logsWithBLOBs.setIp(ip);
//        logsWithBLOBs.setOperateAddress(IpUtil.ipBelongTo(ip));
//
//        logsService.addLog(logsWithBLOBs);
//
//        return result;
//    }
//
//    @SuppressWarnings("unchecked")
//    private StringBuilder handleParams(StringBuilder params, Object[] args, List paramNames) throws JsonProcessingException {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof Map) {
//                Set set = ((Map) args[i]).keySet();
//                List list = new ArrayList();
//                List paramList = new ArrayList<>();
//                for (Object key : set) {
//                    list.add(((Map) args[i]).get(key));
//                    paramList.add(key);
//                }
//                return handleParams(params, list.toArray(), paramList);
//            } else {
//                if (args[i] instanceof Serializable) {
//                    Class<?> aClass = args[i].getClass();
//                    try {
//                        aClass.getDeclaredMethod("toString", new Class[]{null});
//                        // 如果不抛出NoSuchMethodException 异常则存在 toString 方法 ，安全的writeValueAsString ，否则 走 Object的 toString方法
//                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
//                    } catch (NoSuchMethodException e) {
//                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
//                    }
//                } else if (args[i] instanceof MultipartFile) {
//                    MultipartFile file = (MultipartFile) args[i];
//                    params.append("  ").append(paramNames.get(i)).append(": ").append(file.getName());
//                } else {
//                    params.append("  ").append(paramNames.get(i)).append(": ").append(args[i]);
//                }
//            }
//        }
//        return params;
//    }
//}
