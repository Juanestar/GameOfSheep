package com.game.model;

import java.awt.*;

public class Background extends Component{
    private Image image;    // 正常的图片

    private Integer x;  // 当前牌的坐标，起始点为桌面左上角
    private Integer y;

    private Integer width;  // 牌的尺寸，宽和高
    private Integer height;

    public Background(Image image, Integer x, Integer y, Integer width, Integer height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
