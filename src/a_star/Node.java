package a_star;

import java.util.List;

public class Node{
    private String name;
    private String ID;
    private String type;
    private List<Node> connections;
    private Coordinate point;

    public Node(List<Node> connections){
        this.connections = connections;
    }


    //STUB Added for KioskEngine::AddNode()
    //Change as needed
    public Node(String name, String ID, String type, int x, int y, int floor, List<Node> connections){
        this.name = name;
        this.ID = ID;
        this.type = type;
        this.connections = connections;
        this.point = new Coordinate();
        point.setX(x);
        point.setY(y);
        point.setFloor(floor);

    }

    public Node(){ }

    public Node(int x, int y){
        point = new Coordinate();
        point.setX(x);
        point.setY(y);
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Node> getConnections() {
        return connections;
    }

    public void setConnections(List<Node> connections) {
        this.connections = connections;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public int getFloor() {
        return point.getFloor();
    }

    //Encapsulated class in order to handle the simple cartesian graph point functionality
    private class Coordinate {
        private int floor;
        private int x;
        private int y;

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public String toString(){
        return name;
    }
}