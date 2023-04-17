package com.game.model;

import java.util.Random;

public class Layer {

    private Integer offsetx = new Random().nextInt(100);    // 图层横坐标位移变量
    private Integer offsety = new Random().nextInt(100);    // 图层纵坐标位移变量

    private Integer rowNum;     // 行数
    private Integer colNum;     // 列数

    private Integer capacity;       // 当前图层能最多容纳的牌数

    private Integer size;       // 当前图层有多少牌，当牌的数量改变时，该变量同时也要改变

    private Layer parent;   // 保存上一层的图层对象

    private Cell[][] cells = new Cell[4][5];

    public void showCells(){
        for (int i=0;i<cells.length;i++){
            for (int j=0;j<cells[i].length;j++){
                System.out.print(cells[i][j].getBrand().getName()+" ");
            }
            System.out.println();
        }
    }

    public Layer(Integer rowNum, Integer colNum) throws Exception {
        this.rowNum = rowNum;
        this.colNum = colNum;

        this.capacity = this.rowNum*this.colNum;

        if (this.capacity%3!=0){
            throw new Exception("容量不是3的倍数");
        }

        this.cells = new Cell[this.rowNum][this.colNum];

        this.size = 0;
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public Integer getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(Integer offsetx) {
        this.offsetx = offsetx;
    }

    public Integer getOffsety() {
        return offsety;
    }

    public void setOffsety(Integer offsety) {
        this.offsety = offsety;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
