package com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.Security;

import java.io.Serial;
import java.io.Serializable;

public class AccountCredentialsVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public AccountCredentialsVO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
