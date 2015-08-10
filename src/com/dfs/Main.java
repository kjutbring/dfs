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

    public static MazeNode parseStringToNode(String direction, ArrayList<ArrayList<MazeNode>> nodeGrid,
                                             int x, int y) {
        int down =  y - 1;
        int left =  x - 1;
        int right = x + 1;
        int up = y + 1;
        MazeNode newNode;

        if (direction.equals("Down")) {
            newNode = nodeGrid.get(down).get(x);
        } if (direction.equals("Left")) {
            newNode = nodeGrid.get(y).get(left);
        } if (direction.equals("Right")) {
            newNode = nodeGrid.get(y).get(right);
        } if (direction.equals("Up")) {
            newNode = nodeGrid.get(up).get(x);
        } else {
            newNode = new MazeNode();
        }

        return newNode;
    }

}
