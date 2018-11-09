package com.niezhiliang.shiro.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.UrlConstant;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class IpUtil {
    /**
     * 获取真实的ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");

        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static String ipBelongTo(String ip) {
        String params = "key=8325164e247e15eea68b59e89200988b&ip="+ip;
        String returnData = null;
        try {
            returnData = HttpUtils.sendGet(UrlConstant.IP_BELONG_GAODE,params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(returnData);
        JSONObject jsonObject = JSON.parseObject(returnData);
        if (jsonObject.getString("status").equals("1")) {
            return jsonObject.getString("province")+"|"+jsonObject.getString("city");
        }
        return "ip归属地查询失败";
    }

}
