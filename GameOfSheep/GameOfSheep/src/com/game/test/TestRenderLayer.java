package com.game.test;

import com.game.model.Brand;
import com.game.model.Cell;
import com.game.model.Layer;
import com.game.util.LayerUtil;

import javax.swing.*;
import java.awt.*;

public class TestRenderLayer extends JFrame{

    private Layer layer = LayerUtil.build(6,6);



    public TestRenderLayer(){
        // 1.初始化图层
        init();

        // 2.渲染图层
        renderLayer();

        //  3.自动刷新
        autoRefresh();

    }

    private void init(){

        this.setTitle("羊了个羊");                  //窗口标题
        this.setSize(450,800);        //窗口尺寸

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //窗口关闭的同时，进程也关闭
        this.setLocationRelativeTo(null);       //窗口居中

        // 设置绝对布局
        this.setLayout(null);
        this.setBounds(0,0,450,800);

        this.setVisible(true);


        // 启动自动刷新线程
        autoRefresh();
    }

    private void renderLayer(){
        Cell[][] cells = layer.getCells();
        for (int row=0;row<cells.length;row++){
            for (int col=0;col<cells[row].length;col++){
                Brand brand1 = cells[row][col].getBrand();
                int x = col * 50;
                int y = row * 50;
                brand1.setBounds(x,y,50,50);
                System.out.println(brand1.getName());


                this.getContentPane().add(brand1);
            }
        }
    }

    public static void main(String[] args) {

        new TestRenderLayer();

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
}
