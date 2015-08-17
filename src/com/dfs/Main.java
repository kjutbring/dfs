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

        // set the node where the end/exit is
        int exitX = 0;
        int exitY = 0;

        grid = mazeDfs(startX, startY, grid);

        generateMaze(grid);

        System.out.println("Done...?");

    }


    /*
        This method is recursive and visits each node until the exit.
     */
    public static ArrayList<ArrayList<MazeNode>> mazeDfs(int x, int y, ArrayList<ArrayList<MazeNode>> grid) {
        Stack<MazeNode> stack = new Stack();

        MazeNode tempNode;
        MazeNode node = grid.get(y).get(x);
        node.setVisited(true);

        int visitedCells = 1;
        while (visitedCells < 100) {
            Integer direction = randomDirections(node);
            node.setVisited(true);

            // check if node have any unvisited neighbours
            if (!MazeNode.determineVisitedNeighbours(node)) {
                if (direction.equals(0)) {
                    // check if position is outside grid
                    if (y - 2 >= 0) {
                        node.setConnectedUp(true);
                        grid.get(y - 2).get(x).setConnectedDown(true);
                        grid.get(y - 1).get(x).setVisited(true);
                        node = grid.get(y - 2).get(x);
                        stack.push(node);
                    }
                }

                if (direction.equals(1)) {
                    // check if position is outside grid.
                    if (y + 2 <= 9) {
                        node.setConnectedDown(true);
                        grid.get(y + 2).get(x).setConnectedUp(true);
                        grid.get(y + 1).get(x).setVisited(true);
                        node = grid.get(y + 2).get(x);
                        stack.push(node);
                    }
                }

                if (direction.equals(2)) {
                    // check if position is outside grid
                    if (x - 2 >= 0) {
                        node.setConnectedLeft(true);
                        grid.get(y).get(x - 2).setConnectedRight(true);
                        grid.get(y).get(x - 1).setVisited(true);
                        node = grid.get(y).get(x - 2);
                        stack.push(node);
                    }
                }

                if (direction.equals(3)) {
                    // check if position is outside grid
                    if (x + 2 <= 9) {
                        node.setConnectedRight(true);
                        grid.get(y).get(x + 2).setConnectedLeft(true);
                        grid.get(y).get(x - 1).setVisited(true);
                        node = grid.get(y).get(x + 2);
                        stack.push(node);
                    }
                }

                else {
                    if (!stack.empty()) {
                        tempNode = stack.pop();
                        node = tempNode;
                    }
                }
            }
            visitedCells += 1;
        }
        return grid;
    }



    /*
        This method prints all nodes
     */
    public static void generateMaze(ArrayList<ArrayList<MazeNode>> maze) {
        for (ArrayList<MazeNode> mazeArray : maze) {
            for (MazeNode node : mazeArray) {
                if (node.isVisited()) {
                    System.out.print(".");
                } else {
                    System.out.print("a");
                }
            }
        }
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
