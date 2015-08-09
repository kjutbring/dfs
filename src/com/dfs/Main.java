package com.dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<MazeNode>> nodeArray = MazeNode.initializeMaze();

        // initialize stack
        Stack nodeStack = new Stack();
        System.out.println(nodeArray);


    }

    /*
        This method adds a MazeNode to the stack
     */
    /*
    public static Stack addToStack(Stack stack) {
        stack.pop();

    }
    */

    /*
        This randomly selects from the unvisited neigbours which direction to go next.
     */
    public static String selectNeigbour(MazeNode node) {
        ArrayList<String> directionList = new ArrayList<String>();
        if (MazeNode.determineVisitedNeighbours(node)) {
            if (!node.isConnectedDown()) {
                directionList.add("Down");
            } if (!node.isConnectedLeft()) {
                directionList.add("Left");
            } if (!node.isConnectedRight()) {
                directionList.add("Right");
            } if (!node.isConnectedUp()) {
                directionList.add("Up");
            }
        } else {
            System.out.println("No unvisited neigbours.");
        }

        // get random object from string
        Random random = new Random();
        int index = random.nextInt(directionList.size());

        return directionList.get(index);
    }

    /*
        This method parses a string direction to select the correct node
     */
    /*
    public static MazeNode parseStringToNode(String direction, ArrayList<ArrayList<MazeNode>> nodeGrid) {
        int down = -1
        int left = -1;
        int right = 1;
        int up = 1;
        MazeNode node

        if (direction.equals("Down")) {
            node = nodeGrid.get(1).get(2);
        }
        return node;
    }
    */
}
