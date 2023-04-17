package com.game.model;

/*
* Brand代表游戏的一张牌
* */

import com.game.test.TestRenderMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Brand extends Component{

    private String name;    // 牌的名称

    private Boolean isGray;     // 是否置灰

    private Image image;    // 正常的图片

    private Image grayImage;    // 灰色的图片

    private Integer x;  // 当前牌的坐标，起始点为桌面左上角
    private Integer y;

    private Integer width;  // 牌的尺寸，宽和高
    private Integer height;

    private Cell cell;


    public Brand(String name) {
        this.name = name;

        // 获取图片
        this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
        this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_gray.png");

        this.isGray = false;

        this.width = 50;
        this.height = 50;

        this.x = 0;
        this.y = 0;

        EliminateBox eliminateBox = new EliminateBox();



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("该牌被点击");
                // 获取该牌
                Brand brand = (Brand) e.getSource();
                if (brand.isGray){
                    return;
                }else {
                    // 如果牌不是灰的，就可以点击并移除
                    // 但是数据还是存储在数组中，数组中的cell对象的属性state并未置为0
                    // brand.getParent().remove(brand);
                    eliminateBox.addSlot(brand);

                    // 将数据结构中存放的数据也给换掉
                    cell.setState(0);
                    cell.setBrand(null);

                    // 点击完之后，系统需要重新刷新，判断所有牌是否置灰
                    TestRenderMap.gameMap.compareAll();

                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (isGray==true){
            //绘制灰色图片
            g.drawImage(this.grayImage,this.x,this.y,null);
        }else{
            //绘制正常图片
            g.drawImage(this.image,this.x,this.y,null);
        }
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGray() {
        return isGray;
    }

    public void setGray(Boolean gray) {
        isGray = gray;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getGrayImage() {
        return grayImage;
    }

    public void setGrayImage(Image grayImage) {
        this.grayImage = grayImage;
    }

//    public Integer getX() {
//        return x;
//    }
//
//    public void setX(Integer x) {
//        this.x = x;
//    }
//
//    public Integer getY() {
//        return y;
//    }
//
//    public void setY(Integer y) {
//        this.y = y;
//    }
//
//    public Integer getWidth() {
//        return width;
//    }
//
//    public void setWidth(Integer width) {
//        this.width = width;
//    }
//
//    public Integer getHeight() {
//        return height;
//    }
//
//    public void setHeight(Integer height) {
//        this.height = height;
//    }
}
