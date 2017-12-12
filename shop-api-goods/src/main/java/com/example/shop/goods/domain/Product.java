package com.example.shop.goods.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Product extends BaseDomain implements Serializable {
    private Date       createdDate;
    private Date       lastModifiedDate;
    private Integer    version;
    private Long       catalogId;
    private Long       brandId;
    private String     name;
    private String     keyword;
    private String     code;
    private String     image;
    private BigDecimal marketPrice;
    private BigDecimal basePrice;
    private Long       mods;
    private String     impressions;
}