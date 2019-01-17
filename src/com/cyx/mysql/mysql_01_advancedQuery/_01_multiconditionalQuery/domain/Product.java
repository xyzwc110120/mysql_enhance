package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private Long id;
    private Integer productTypeId;      // 商品类型id
    private String name;                // 商品名称
    private String brand;               // 商品品牌
    private BigDecimal purchasingPrice; // 商品进价
    private BigDecimal originalPrice;   // 商品原价
    private BigDecimal currentPrice;    // 商品现价

    public Product() {
    }

    public Product(Integer productTypeId, String name, String brand, BigDecimal purchasingPrice,
                   BigDecimal originalPrice, BigDecimal currentPrice) {
        this.productTypeId = productTypeId;
        this.name = name;
        this.brand = brand;
        this.purchasingPrice = purchasingPrice;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
    }

    public Product(Long id, Integer productTypeId, String name, String brand, BigDecimal purchasingPrice,
                   BigDecimal originalPrice, BigDecimal currentPrice) {
        this.id = id;
        this.productTypeId = productTypeId;
        this.name = name;
        this.brand = brand;
        this.purchasingPrice = purchasingPrice;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productTypeId=" + productTypeId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", originalPrice=" + originalPrice +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
