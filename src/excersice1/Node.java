package excersice1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Node {

    private String data;

    private Node parent = null;
    private Set<Node> children;

    public Node(String data) {
        this.data = data;
    }

    public void insertChild(Node nodeToInsert) {
        nodeToInsert.setParent(this);
        getChildren().add(nodeToInsert);
    }

    public boolean deleteChild(Node nodeToDelete) {
        nodeToDelete.setParent(null);
        return children.remove(nodeToDelete);
    }

    public void moveTo(Node nodeToMoveTo) {
        Node currentNode = this;
        currentNode.getParent().deleteChild(currentNode);
        nodeToMoveTo.insertChild(currentNode);
    }

    /**
     * Returns path from root to this node (exclusive)
     * @return
     */
    public List<Node> getPath() {
        LinkedList<Node> path = new LinkedList<>();
        Node parentNode = parent;
        while (parentNode != null) {
            path.addFirst(parentNode);
            parentNode = parentNode.getParent();
        }
        return path;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Set<Node> getChildren() {
        if (children == null) {
            children = new HashSet<>();
        }
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}