package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    List<Integer[]> list;

    public MyHashMap() {
        list = new ArrayList<>();
    }

    public void put(int key, int value) {
        Integer[] pair = new Integer[]{key, value};
        if (list.size() == 0) {
            list.add(pair);
            return;
        }

        int count = -1;
        for(Integer[] each : list) {
            if (each[0] == key) {
                count++;
                each[1] = value;
            }
        }
        if (count < 0) list.add(pair);
    }

    public int get(int key) {
        if(list.size() == 0) return -1;
        for(Integer[] each : list) {
            if (each[0] == key) {
                return each[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        if (list.size() == 0) return;
        int index = -1;
        for(Integer[] each : list) {
            if (each[0] == key) {
                index = list.indexOf(each);
            }
        }
        if (index < 0) return;
        list.remove(index);
    }
}
