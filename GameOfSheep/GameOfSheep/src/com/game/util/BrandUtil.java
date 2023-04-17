package com.game.util;

import com.game.model.Brand;

import java.util.Random;

public class BrandUtil {
    public static Random random = new Random();

    public static String[] brandNames={
            "刷子","剪刀","奶瓶","小草",
            "手套","木墩","毛线","水桶",
            "火堆","玉米","白菜","稻草",
            "羊毛","萝卜","铃铛","锄头",
    };

    // getBrandName 每次调用随机获取一个牌的名称
    public static String getBrandName(){
        int randomIndex = random.nextInt(brandNames.length);
        return brandNames[randomIndex];
    }

    // 创建牌的数组
    public static Brand[] buildBrands(Integer capacity){
        Brand[] brands = new Brand[capacity];   //数组的容量等于图层的容量

        for (int i=0;i<brands.length;i=i+3){
            String randomBrandName = getBrandName();    // 每次获取一个随机的名称

            Brand brand1 = new Brand(randomBrandName);
            Brand brand2 = new Brand(randomBrandName);
            Brand brand3 = new Brand(randomBrandName);

            brands[i] = brand1;
            brands[i+1] = brand2;
            brands[i+2] = brand3;
        }

        // 打乱算法
        for (int i=0;i<brands.length;i=i+3){

            // 当前位置A的变量
            Brand brandA = brands[i];

            // 交换位置的B索引
            int randomIndex = random.nextInt(brands.length);
            Brand brandB = brands[randomIndex];

            Brand temp = brandA;
            brands[i]=brandB;
            brands[randomIndex]=temp;

        }

        return brands;
    }

}
