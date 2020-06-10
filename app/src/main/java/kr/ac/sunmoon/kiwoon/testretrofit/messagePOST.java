package kr.ac.sunmoon.kiwoon.testretrofit;

import com.google.gson.annotations.SerializedName;

public class messagePOST {
    private String username;
    private String password;
    private String nickname;
    @SerializedName("body")
    private String msg;

    public messagePOST(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }


    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMsg() {
        return msg;
    }
}
