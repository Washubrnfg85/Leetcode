package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Path_Crossing {

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
    }

    public static boolean isPathCrossing(String path) {
        char[] directions = path.toCharArray();
        List<Coordinate> coordinates = new ArrayList<>();
        int currentX = 0;
        int currentY = 0;

        for (int i = 0; i < path.length(); i++) {
            coordinates.add(new Coordinate(currentX, currentY));

            switch (directions[i]) {
                case 'N':
                    currentY++;
                    if (listContainsCoordinate(coordinates, new Coordinate(currentX, currentY))) return true;
                    coordinates.add(new Coordinate(currentX, currentY));
                    break;
                case 'E':
                    currentX++;
                    if (listContainsCoordinate(coordinates, new Coordinate(currentX, currentY))) return true;
                    coordinates.add(new Coordinate(currentX, currentY));
                    break;
                case 'S':
                    currentY--;
                    if (listContainsCoordinate(coordinates, new Coordinate(currentX, currentY))) return true;
                    coordinates.add(new Coordinate(currentX, currentY));
                    break;
                case 'W':
                    currentX--;
                    if (listContainsCoordinate(coordinates, new Coordinate(currentX, currentY))) return true;
                    coordinates.add(new Coordinate(currentX, currentY));
                    break;
            }
        }
        return false;
    }

    //class to hold coordinate of certain point
    static class Coordinate {
        int x = 0;
        int y = 0;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean listContainsCoordinate(List<Coordinate> list, Coordinate coordinate) {
        for(Coordinate point : list) {
            if (point.x == coordinate.x && point.y == coordinate.y)
                return true;
        }
        return false;
    }

}