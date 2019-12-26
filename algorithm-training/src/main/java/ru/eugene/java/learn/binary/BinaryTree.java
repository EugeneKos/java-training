package ru.eugene.java.learn.binary;

/**
 * Что - то похожее на AVL дерево.
 */
public class BinaryTree {
    private Node root;

    public void put(int value){
        if(root == null){
            root = new Node(value, null);
            return;
        }
        Node node = root;
        Node parent = null;
        while (node != null){
            parent = node;
            int cmpResult = compareInt(value, node.value);
            if (cmpResult < 0){
                node = node.left;
                if(node == null){
                    parent.left = new Node(value, parent);
                }
            } else if (cmpResult > 0){
                node = node.right;
                if(node == null){
                    parent.right = new Node(value, parent);
                }
            }
        }

        do {
            int parentBalanceFactor = balanceFactor(parent);

            if(parentBalanceFactor == -2){
                System.out.println("требуется поворот налево");
                Node right = parent.right;
                if(right.right == null){
                    rightLeftRotate(parent);
                } else {
                    leftRotate(parent);
                }
            } else if(parentBalanceFactor == 2){
                System.out.println("требуется поворот направо");
                Node left = parent.left;
                if(left.left == null){
                    leftRightRotate(parent);
                } else {
                    rightRotate(parent);
                }
            }

            parent = parent.parent;
        } while (parent != null);
    }

    private int compareInt(int one, int two){
        return one >= two ? 1 : -1;
    }

    private int balanceFactor(Node node){
        if(node.left == null && node.right == null){
            return 0;
        }
        int leftHeight = -1;
        int rightHeight = -1;

        if(node.left != null){
            leftHeight = node.left.height();
        }
        if(node.right != null){
            rightHeight = node.right.height();
        }
        return leftHeight - rightHeight;
    }

    private void leftRotate(Node node){
        Node parent = node.parent;
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.parent = parent;
        node.parent = right;
        if(parent != null){
            parent.right = right;
        } else {
            root = right;
        }
    }

    private void rightLeftRotate(Node node){
        Node right = node.right;
        Node rightLeft = right.left;
        node.right = rightLeft;
        rightLeft.parent = node;
        rightLeft.right = right;
        right.parent = rightLeft;
        right.left = null;
        leftRotate(node);
    }

    private void rightRotate(Node node){
        Node parent = node.parent;
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.parent = parent;
        node.parent = left;
        if(parent != null){
            parent.left = left;
        } else {
            root = left;
        }
    }

    private void leftRightRotate(Node node){
        Node left = node.left;
        Node leftRight = left.right;
        node.left = leftRight;
        leftRight.parent = node;
        leftRight.left = left;
        left.parent = leftRight;
        left.right = null;
        rightRotate(node);
    }

    public int height(){
        if(root == null){
            return 0;
        }
        return root.height();
    }

    class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        int height(){
            if(left == null && right == null){
                return 0;
            }

            int leftHeight = 0;
            int rightHeight = 0;

            if(left != null){
                leftHeight = left.height();
            }
            if(right != null){
                rightHeight = right.height();
            }
            if(leftHeight == rightHeight){
                return leftHeight + 1;
            }
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    @Override
    public String toString() {
        return "" + root;
    }
}
