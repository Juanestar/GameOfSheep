package com.game.test;

import com.game.model.*;
import com.game.util.LayerUtil;

import java.util.List;

//import java.util.List;

public class TestBuildMap {

    public static void main(String[] args) {
        GameMap map = new GameMap();
        map.setFloorHeight(3);

        Layer layer1 = LayerUtil.build(3,3);
        Layer layer2 = LayerUtil.build(6,6);
        Layer layer3 = LayerUtil.build(9,9);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);

        List<Layer> list = map.getList();
        for (int i=0;i<list.size();i++){
            System.out.println();
            System.out.println("第" + (i+1) + "个图层");
            list.get(i).showCells();
        }
    }
}
