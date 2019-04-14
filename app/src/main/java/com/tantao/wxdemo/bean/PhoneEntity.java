package com.tantao.wxdemo.bean;

/**
 * @author：tantao
 * @date：2019/4/11
 */
public class PhoneEntity {

    private String name;
    private String phone;

    public PhoneEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
