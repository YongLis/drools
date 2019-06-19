package com.sh.drools.common;

/**
 * @Auther: liyong
 * @Date:2019/6/18 16:43
 * @Desc: the description of class
 */
public class BaseResponse {
    private String responseCode;
    private String responseMsg;
    private String responseStatus;

    public BaseResponse() {
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String toString() {
        return "BaseResponse{responseCode='" + this.responseCode + '\'' + ", responseMsg='" + this.responseMsg + '\'' + ", responseStatus='" + this.responseStatus + '\'' + '}';
    }
}
