package com.game.view;

import com.game.model.Brand;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {
    /*
    游戏的启动入口
    */

    private Brand brand = new Brand("小草");

    public Start() throws HeadlessException {
        this.setTitle("羊了个羊");                  //窗口标题
        this.setSize(450,800);        //窗口尺寸

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //窗口关闭的同时，进程也关闭
        this.setLocationRelativeTo(null);       //窗口居中
        this.setVisible(true);
        // 将组件添加到窗口中
        this.getContentPane().add(brand);

        // 启动自动刷新线程
        autoRefresh();
    }

    private void autoRefresh(){
        Start start = this;

        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true){
                    start.repaint();

                    try {

                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Start();
    }

}
