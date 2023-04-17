package com.game.test;

/*
* 测试图层数据构建
* */

import com.game.model.Brand;
import com.game.model.Cell;
import com.game.model.Layer;

import java.util.Random;

public class TestBuildLayer {
    public static Random random = new Random();

    public static String[] brandNames={
            "刷子","剪刀","奶瓶","小草",
            "手套","木墩","毛线","水桶",
            "火堆","玉米","白菜","稻草",
            "羊毛","萝卜","铃铛","锄头"
    };


    // getBrandName 每次调用随机获取一个牌的名称
    public static String getBrandName(){
        int randomIndex = random.nextInt(brandNames.length);
        return brandNames[randomIndex];
    }


    public static void main(String[] args) {
        Layer layer = null;
        try {
            layer = new Layer(3,5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Brand[] brands = new Brand[layer.getCapacity()];

        for (int i=0;i<brands.length;i=i+3){

            String randomBrandName = getBrandName();    // 获取牌名称

            Brand brand = new Brand(randomBrandName);
            Brand brand1 = new Brand(randomBrandName);
            Brand brand2 = new Brand(randomBrandName);

            brands[i] = brand;
            brands[i+1] = brand1;
            brands[i+2] = brand2;


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

        // 放牌
        int flag=0;
        Cell[][] cells = layer.getCells();

        for(int row=0;row< cells.length;row++){
            for (int col=0;col<cells[row].length;col++){
                Cell cell = new Cell();
                cell.setState(1);
                cell.setBrand(brands[flag++]);

                cells[row][col]=cell;
            }
        }



    }
}
