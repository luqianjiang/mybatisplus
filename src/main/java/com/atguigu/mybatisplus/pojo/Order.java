package com.atguigu.mybatisplus.pojo;

import lombok.Data;

/**
 * @author 陆钱江
 * @create 2022-11-27 19:47
 */
@Data
public class Order {
    private int id;
    private int orderId;
    private String cityName;
    private String toPlace;
    private String fromPlace;
    private int isActive;
    private int localException;
    private double price;
}
