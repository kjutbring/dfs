package com.dfs;

import java.util.ArrayList;

/**
 * Created by kittyj on 8/7/15.
 */
public class MazeNode {
    private boolean connectedUp;
    private boolean connectedDown;
    private boolean connectedLeft;
    private boolean connectedRight;
    private boolean isVisited;

    public boolean isConnectedUp() {
        return connectedUp;
    }

    public void setConnectedUp(boolean connectedUp) {
        this.connectedUp = connectedUp;
    }

    public boolean isConnectedDown() {
        return connectedDown;
    }

    public void setConnectedDown(boolean connectedDown) {
        this.connectedDown = connectedDown;
    }

    public boolean isConnectedLeft() {
        return connectedLeft;
    }

    public void setConnectedLeft(boolean connectedLeft) {
        this.connectedLeft = connectedLeft;
    }

    public boolean isConnectedRight() {
        return connectedRight;
    }

    public void setConnectedRight(boolean connectedRight) {
        this.connectedRight = connectedRight;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    /*
            This method returns a 2d arraylist representing a 10x10 grid of maze nodes.
         */
    public static ArrayList<ArrayList<MazeNode>> initializeMaze() {
        // create array with nodes, this creates a 10x10 grid.
        ArrayList<MazeNode> mazeNodeArrayList = new ArrayList<MazeNode>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                mazeNodeArrayList.add(new MazeNode());
            }
        }

        ArrayList<ArrayList<MazeNode>> mazeArrayList = new ArrayList<>();
        mazeArrayList.add(mazeNodeArrayList);

        return mazeArrayList;
    }

    /*
        This method determines if a has any unvisited neighbours.
     */
    public static boolean determineVisitedNeighbours(MazeNode node) {
        if (node.isConnectedDown() || node.isConnectedLeft() ||
                node.isConnectedRight() || node.isConnectedUp()) {
            return true;
        } else {
            return false;
        }
    }


}
