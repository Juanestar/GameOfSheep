package com.game.util;

import com.game.model.Brand;
import com.game.model.Cell;
import com.game.model.GameMap;
import com.game.model.Layer;

import java.awt.*;

public class MapUtil {
    public static GameMap build(Integer floorHeight){
        GameMap map = new GameMap();
        map.setFloorHeight(3);

        Layer layer1 = LayerUtil.build(6,5);
        Layer layer2 = LayerUtil.build(3,6);
        Layer layer3 = LayerUtil.build(3,7);

        // 构建图层关系
        layer3.setParent(layer2);
        layer2.setParent(layer1);
        layer1.setParent(null);     // parent为空说明该层是顶层，循环或结束的重要条件

        layer1.setOffsetx(30);
        layer1.setOffsety(30);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);

        return map;
    }

    /*
    * 判断当前牌 和某一图层内所有牌是否有矩阵交集
    * true就是有交集，显示灰色
    * false是没有交集，显示正常
    * */
    public static boolean compare(Brand brand,Layer layer){
        Cell[][] cells = layer.getCells();
        for(int row=0;row< cells.length;row++){
            for (int col=0;col<cells[row].length;col++){
                // 如果当前的单元格是空，不用比较了
                Cell cell = cells[row][col];
                if (cell.getState()==1){
                    // 单元格有牌，可以比较
                    Rectangle temp = cell.getBrand().getBounds();

                    Rectangle rect = brand.getBounds();

                    boolean result = rect.intersects(temp);

                    if (result){
                        // 有交集
                        return result;
                    }
                }
            }
        }
        if (layer.getParent()!=null){
            return compare(brand, layer.getParent());
        }else {
            // 如果Parent为null，则已经到第一层
            return false;
        }
    }
}
