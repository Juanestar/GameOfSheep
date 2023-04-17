package com.game.test;

import com.game.model.*;
import com.game.util.*;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public class TestRenderMap extends JFrame{

    public static GameMap gameMap = MapUtil.build(3);

    private Image background;

    public TestRenderMap() throws FileNotFoundException, JavaLayerException {
        // 1.初始化图层
        init();

        // 2.渲染图层
//        renderLayer();
        List<Layer> list = gameMap.getList();;



        for (int i = 0;i<list.size();i++){
            renderLayer(list.get(i));
        }

        // 判断是否置灰
        gameMap.compareAll();

        //  3.自动刷新
        autoRefresh();

        new Music().music();
    }

    private void init(){

        this.setTitle("羊了个羊");                  //窗口标题
        this.setSize(550,800);        //窗口尺寸

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //窗口关闭的同时，进程也关闭


        // 设置绝对布局
        this.setLayout(null);
        this.setBounds(0,0,450,800);

        this.setLocationRelativeTo(null);       //窗口居中

        this.setVisible(true);

        // 插入背景图
        paintBackground();

        // 启动自动刷新线程
        autoRefresh();
    }

    private void renderLayer(Layer layer){
        Cell[][] cells = layer.getCells();
        layer.showCells();
        for (int row=0;row<cells.length;row++){
            for (int col=0;col<cells[row].length;col++){
                Brand brand1 = cells[row][col].getBrand();
                int x = col * 50 + layer.getOffsetx();
                int y = row * 50 + layer.getOffsety();
                brand1.setBounds(x,y,50,50);


                this.getContentPane().add(brand1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {

        new TestRenderMap();

    }

    private void autoRefresh(){
        JFrame start = this;

        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true){
                    start.repaint();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    //绘制背景图片
    public void paintBackground(){
        Image image = Toolkit.getDefaultToolkit().getImage("imgs\\背景图.png");
        Button button = new Button();

        Background background = new Background(image,0,0,450,800);

        this.getContentPane().add(background);

        System.out.println("check background");


    }
}
