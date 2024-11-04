package com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.Security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class TokenVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("Authenticated")
    private boolean authenticated;
    @JsonProperty("Created")
    private Date created;
    @JsonProperty("Expiration")
    private Date expiration;
    @JsonProperty("AccessToken")
    private String accessToken;
    @JsonProperty("RefreshToken")
    private String refreshToken;

    public TokenVO() { }

    public TokenVO(String userName, boolean authenticated, Date created, Date expiration, String accessToken,
                   String refreshToken) {
        this.userName = userName;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
