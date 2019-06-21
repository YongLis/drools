package com.sh.drools.common;

/**
 * @Auther: liyong
 * @Date:2019/6/18 17:10
 * @Desc: the description of class
 */
public enum Gender {
    BOY("boy","男"),
    GIRL("girl","女");

    private String code;
    private String desc;

    Gender(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
