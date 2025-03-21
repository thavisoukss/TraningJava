package com.bee.moveData;

public class UserTrustOut {
    private String id;
    private String mobile;

    public UserTrustOut() {
    }

    public UserTrustOut(String id, String mobile) {
        this.id = id;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserTrustOut{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
