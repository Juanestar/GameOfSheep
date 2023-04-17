package com.game.util;

import com.game.model.Brand;
import com.game.model.Cell;
import com.game.model.Layer;

import java.util.Random;

public class LayerUtil {
    public static Random random = new Random();

    public static Layer build(Integer rowNum,Integer colNum){
        Layer layer = null;
        try {
            layer = new Layer(rowNum,colNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Brand[] brands = BrandUtil.buildBrands(layer.getCapacity() );

        // 放牌
        int flag=0;
        Cell[][] cells = layer.getCells();

        for(int row=0;row< cells.length;row++){
            for (int col=0;col<cells[row].length;col++){
                Brand brand1 = brands[flag++];

                Cell cell = new Cell();
                cell.setState(1);
                cell.setBrand(brand1);

                brand1.setCell(cell);



                cells[row][col]=cell;
            }
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

        return layer;
    }
}
