package com.example.shop.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
public class BaseDomain implements Serializable{
    private Long id;
}
