package space.gavinklfong.demo.streamapi.challenge;

public class Node {

    private int data;
    private Node nextNode;

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
