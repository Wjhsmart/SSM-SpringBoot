package com.cykj.enums;

/**
 * Created by Wjhsmart on 2017/9/14.
 */
public enum UserStatusEnum {

    /**
     * 01-正常
     */
    NORMAL("01", "正常"),

    /**
     * 02-禁用
     */
    DISABLE("02", "禁用"),
    ;

    private final String code;

    private final String des;

    UserStatusEnum(String code, String des) {
        this.code = code;
        this.des = des;
    }

    public String getCode() {
        return this.code;
    }

    public String getdes() {
        return this.des;
    }

    public static UserStatusEnum getByCode(String code) {
        if (code == null || "".equals(code.trim())) {
            return null;
        }

        for (UserStatusEnum menum : values()) {
            if (code.equals(menum.getCode())) {
                return menum;
            }
        }
        return null;
    }

    public static UserStatusEnum getBydes(String des) {
        if (des == null || "".equals(des.trim())) {
            return null;
        }
        for (UserStatusEnum menum : values()) {
            if (des.equals(menum.getdes())) {
                return menum;
            }
        }
        return null;
    }
}
