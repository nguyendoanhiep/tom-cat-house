package com.tom.restaurant.entity.dto;

import com.tom.restaurant.entity.VoucherCode;
import com.tom.restaurant.entity.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrdersDto {
    private Long id;
    private String code;
    private Long customerId;
    private String numberPhone;
    private Long originalPrice;
    private Long discountAmount;
    private Long finalPrice;
    private Date createDate;
    private Date modifiedDate;
    private List<Product> products;
    private List<VoucherCode> voucherCodes;

}
