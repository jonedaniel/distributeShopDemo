package com.example.shop.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class User extends BaseDomain {
    private String     userName;
    private String     password;
    private String     nickName;
    private String     account;
    private String     phone;
    private String     email;
    private Boolean    sex;
    private BigDecimal userMoney;
    private String     grade;
    private Integer    experience;
    private Long       integral;
}