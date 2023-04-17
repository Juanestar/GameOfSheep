package com.game.model;

import com.game.util.MapUtil;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private Integer floorHeight; // 层高 有几张图层

    private List<Layer> list = new ArrayList<>();   // 存放图层数据

    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getList() {
        return list;
    }

    public void setList(List<Layer> list) {
        this.list = list;
    }

    /*
        判断当前的map中所有的牌是否置灰（该算法性能差）
        1 游戏开始时要调用一次
        2 点击一次要调用一次
     */
    public void compareAll(){
        // i=0是最顶层layer不需要判断
        for (int i=1;i<list.size();i++){
            Layer layer = list.get(i);
            Cell[][] cells = layer.getCells();

            for (int row=0;row<cells.length;row++){
                for (int col=0;col<cells[row].length;col++){
                    Cell cell = cells[row][col];
                    if (cell.getState()==1){
                        Brand brand = cell.getBrand();
                        boolean result = MapUtil.compare(brand,layer.getParent());
                        brand.setGray(result);
                    }
                }
            }
        }
    }
}
