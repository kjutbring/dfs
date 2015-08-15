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
        MazeNode node = grid.get(4).get(2);
        System.out.println(node.isVisited());
        node.setVisited(true);
        System.out.println(node.isVisited());

        // set the node where the end/exit is
        int exitX = 0;
        int exitY = 0;

        mazeDfs(startX, startY, grid);

        ArrayList<ArrayList<MazeNode>> gri = mazeDfs(4,2,grid);

        System.out.println(gri.get(2).get(4).isConnectedDown());
        System.out.println(gri.get(2).get(4).isConnectedUp());
        System.out.println(gri.get(2).get(4).isConnectedLeft());
        System.out.println(gri.get(2).get(4).isConnectedRight());



    }


    /*
        This method is recursive and visits each node until the exit.
     */
    public static ArrayList<ArrayList<MazeNode>> mazeDfs(int x, int y, ArrayList<ArrayList<MazeNode>> mazeGrid) {
        // initialize stack
        Stack<MazeNode> stack = new Stack();
        ArrayList<ArrayList<MazeNode>> grid = mazeGrid;

        // set active node and mark as visited
        MazeNode node = grid.get(y).get(x);
        node.setVisited(true);

        // add node to stack
        stack.push(node);

        // check if node have any unvisited neighbours
        if (!MazeNode.determineVisitedNeighbours(node)) {

            if (randomDirections(node) == 0) {
                // check if position is outside grid
                if (y - 1 >= 0) {
                    node.setConnectedUp(true);
                    grid.get(y - 1).get(x).setConnectedDown(true);
                    mazeDfs(x, y - 1, grid);
                }
            }

            if (randomDirections(node) == 1) {
                // check if position is outside grid.
                if (y + 1 <= 9) {
                    node.setConnectedDown(true);
                    grid.get(y + 1).get(x).setConnectedUp(true);
                    mazeDfs(x, y + 1, grid);
                }
            }

            if (randomDirections(node) == 2) {
                // check if position is outside grid
                if (x - 1 >= 0) {
                    node.setConnectedLeft(true);
                    grid.get(y).get(x - 1).setConnectedRight(true);
                    mazeDfs(x - 1, y, grid);
                }
            }

            if (randomDirections(node) == 3) {
                // check if position is outside grid
                if (x + 1 <=9) {
                    node.setConnectedRight(true);
                    grid.get(y).get(x + 1).setConnectedLeft(true);
                    mazeDfs(x + 1, y, grid);
                }
            }

        } /* else {
            if (!stack.empty()) {
                node = stack.peek();
                mazeDfs(node.getPx(), node.getPy(), grid);
            }
        }
        */
        return grid;
    }


    /*
        This method generates a random direction to go next
     */
    public static Integer randomDirections(MazeNode node) {

        ArrayList<Integer> randomIntegers = new ArrayList<Integer>();

        for (int i = 0; i <= 3; i++) {
            if (!node.isConnectedUp() && !randomIntegers.contains(0)) {
                randomIntegers.add(0);
            } if (!node.isConnectedDown() && !randomIntegers.contains(1)) {
                randomIntegers.add(1);
            } if (!node.isConnectedLeft() && !randomIntegers.contains(2)) {
                randomIntegers.add(2);
            } if (!node.isConnectedRight() && !randomIntegers.contains(3)) {
                randomIntegers.add(3);
            }
        }

        // shuffle directions
        Collections.shuffle(randomIntegers);
        return randomIntegers.get(0);
    }

}
