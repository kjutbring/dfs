package com.dfs;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // start coordinates for debugging
        int startX = 4;
        int startY = 2;
        ArrayList<ArrayList<MazeNode>> grid = MazeNode.initializeMaze();
        MazeNode node = grid.get(7).get(2);
        System.out.println("x: " + node.getxPos() + "y: " + node.getyPos());
    }

    public static void mazeDfs(int startX, int startY) {
        ArrayList<ArrayList<MazeNode>> nodeGrid = MazeNode.initializeMaze();

        // set the node where the end/exit is
        int exitX = 9;
        int exitY = 0;
        nodeGrid.get(exitY).get(exitX).setIsExit(true);

        // holds the coordinates for the active node.
        Point activeCoordinates = new Point(startX, startY);
        // set the active node to a node from the grid.
        MazeNode activeNode = nodeGrid.get(startY).get(startX);



        while (!activeNode.isExit()) {

        }
    }

    /*
        This method generates a random direction to go next
     */
    public static ArrayList<Integer> randomDirections() {
        ArrayList<Integer> randomIntegers = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            randomIntegers.add(i);
        }

        // shuffle directions
        Collections.shuffle(randomIntegers);
        return randomIntegers;
    }


}
