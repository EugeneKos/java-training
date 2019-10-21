package ru.eugene.java.learn.graphs.tree;

public class TreeReverse {
    public static Node reverse(Node root){
        Node prev = null;
        Node current = root;

        Node next;
        while ((next = current.getNext()) != null){
            current.setNext(prev);
            prev = current;
            current = next;
        }

        current.setNext(prev);

        return current;
    }


    public static class Node {
        private String value;

        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
