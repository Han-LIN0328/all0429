// 檔案名稱：RedBlackTree.java
class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    int color; // 0 代表黑色，1 代表紅色
}

public class RedBlackTree {
    private Node root;
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    private void fixInsert(Node k) {
        Node u;
        while (k.parent != null && k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) break;
        }
        root.color = 0;
    }

    public void insert(int key) {
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // 新節點預設為紅色

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) x = x.left;
            else x = x.right;
        }

        node.parent = y;
        if (y == null) root = node;
        else if (node.data < y.data) y.left = node;
        else y.right = node;

        if (node.parent == null) {
            node.color = 0;
            return;
        }
        if (node.parent.parent == null) return;
        fixInsert(node);
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] values = {10, 20, 30, 15}; // 投影片 Page 5 的測試資料
        System.out.println("--- Assignment 1: Red-Black Tree ---");
        for (int v : values) {
            rbt.insert(v);
            System.out.println("Inserted: " + v);
        }
        
        System.out.println("\n[Time Complexity]");
        System.out.println("Insertion: O(log N)");
        System.out.println("Search: O(log N)");
        System.out.println("Deletion: O(log N)");
    }
}