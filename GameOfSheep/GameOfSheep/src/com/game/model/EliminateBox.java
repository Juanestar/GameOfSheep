package com.game.model;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class EliminateBox {
    // 存放牌的数据
    private static List<Brand> slot = new ArrayList<>();

    // 迭代器清空
    void deleteByBrandName(String name){
        Iterator<Brand> iterator = slot.iterator();
        while (iterator.hasNext()){
            Brand next = iterator.next();
            if (next.getName().equals(name)){
                next.getParent().remove(next);
                iterator.remove();
            }
        }
    }

    public void addSlot(Brand brand){
        slot.add(brand);

        // 牌的排序
        slot.sort(Comparator.comparing(Brand::getName));
        Map<String,List<Brand>> map = slot.stream().collect(Collectors.groupingBy(Brand::getName));
        Set<String> strings = map.keySet();
        for (String s : strings) {
            List<Brand> brands = map.get(s);
            if (brands.size()==3){
                deleteByBrandName(s);
            }
        }
        paint();
        over(brand);
    }

    // 绘制到消除框
    void paint(){
        for (int i = 0;i<slot.size();i++){
            Brand brand = slot.get(i);
            int x = i*brand.getWidth()+10;
            brand.setBounds(x,600,50,50);
        }
    }

    void over(Brand brand){
        if (slot.size()>=7){
            JOptionPane.showMessageDialog(brand,"游戏结束");
            System.exit(0);
        }
    }
}
