package com.example.mini.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class UserPwdDto {

    @NotEmpty(message = "기존 비밀번호 값을 입력해주세요.")
    @Size(max = 20, message = "비밀번호는 20자를 넘을 수 없습니다.")
    private String oldPwd;

    @NotEmpty(message = "새 비밀번호 값을 입력해주세요.")
    @Size(max = 20, message = "비밀번호는 20자를 넘을 수 없습니다.")
    private String newPwd;

    @NotEmpty(message = "새 비밀번호 확인 값을 입력해주세요.")
    @Size(max = 20, message = "비밀번호는 20자를 넘을 수 없습니다.")
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
