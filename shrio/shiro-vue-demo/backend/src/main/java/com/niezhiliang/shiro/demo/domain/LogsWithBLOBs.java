package com.niezhiliang.shiro.demo.domain;

public class LogsWithBLOBs extends Logs {
    private String params;

    private String returnContent;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getReturnContent() {
        return returnContent;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent == null ? null : returnContent.trim();
    }
}