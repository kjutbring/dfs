package com.dfs;

import java.awt.*;
import java.lang.reflect.Array;
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
    private boolean isExit;
    private int xPos;
    private int yPos;

    public MazeNode(int x, int y) {
        xPos = x;
        yPos = y;
    }

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

    public boolean isExit() {
        return isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /*
        This method returns a 2d arraylist representing a 10x10 grid of maze nodes.
    */
    public static ArrayList<ArrayList<MazeNode>> initializeMaze() {
        // create array with nodes
        ArrayList<MazeNode> mazeNodeArrayList = new ArrayList<MazeNode>();
        ArrayList<ArrayList<MazeNode>> mazeGrid = new ArrayList<ArrayList<MazeNode>>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mazeNodeArrayList.add(new MazeNode(j,i));
            }
        }

        // add elements of arraylist into the 2d arraylist.
        for (int i = 0; i < mazeNodeArrayList.size(); i = i + 10) {
            mazeGrid.add(new ArrayList<MazeNode>(mazeNodeArrayList.subList(i, i + 10)));
        }

        return mazeGrid;
    }

    /*
        This method determines if a node has any unvisited neighbours.
     */
    public static boolean determineVisitedNeighbours(MazeNode node) {
        if (node.isConnectedDown() || node.isConnectedLeft() ||
                node.isConnectedRight() || node.isConnectedUp()) {
            System.out.println("has univisited nebgbgsrs");
            return true;
        } else {
            return false;
        }
    }

    /*
        This method determines if a node is visited.
     */
    public static boolean isNodeVisited(MazeNode node) {
        if (node.isVisited()) {
            return true;
        } else {
            return false;
        }
    }




}
