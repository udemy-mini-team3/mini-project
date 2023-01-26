package com.example.mini.dao;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;

@Component
public class UserPwdDto {

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",
            message = "영문 대/소문자,특수문자,숫자 포함(8~16자)")
    private String oldPwd;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",
            message = "영문 대/소문자,특수문자,숫자 포함(8~16자)")
    private String newPwd;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",
            message = "영문 대/소문자,특수문자,숫자 포함(8~16자)")
    private String newPwdConf;

    public UserPwdDto() {
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getNewPwdConf() {
        return newPwdConf;
    }

    public void setNewPwdConf(String newPwdConf) {
        this.newPwdConf = newPwdConf;
    }

    @Override
    public String toString() {
        return "UserPwdDto{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                ", newPwdConf='" + newPwdConf + '\'' +
                '}';
    }
}
