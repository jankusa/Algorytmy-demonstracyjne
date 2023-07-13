public class BST {
    class Node {
        int key;
        Node left, right;
        public Node(int k) {
            key = k;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int k) {
        if(root == null) {
            root = new Node(k);
            return;
        }
        Node current_node = root;
        while((k < current_node.key&&current_node.left != null)||(k >= current_node.key&&current_node.right != null)) {
            if(k < current_node.key) {
                current_node = current_node.left;
            } else {
                current_node = current_node.right;
            }
        }
        if(k < current_node.key) {
            current_node.left = new Node(k);
        } else {
            current_node.right = new Node(k);
        }
    }

    Node getMinimumKey(Node n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    void delete(int k) {
        Node current_node = root, previous_node = null;
        while(current_node != null && current_node.key != k) {
            if(k < current_node.key) {
                previous_node = current_node;
                current_node = current_node.left;
            } else {
                previous_node = current_node;
                current_node = current_node.right;
            }
        }
        if(current_node == null) {
            return;
        } else if(current_node == root) {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left != null && root.right == null) {
                root = root.left;
            } else if(root.left == null && root.right != null) {
                root = root.right;
            } else {
                Node n = root.left;
                while(n.right != null) {
                    n = n.right;
                }
                n.right = root.right;
                root = root.left;
            }
        } else if(previous_node.left == current_node) {
            if(current_node.left == null && current_node.right == null) {
                previous_node.left = null;
            } else if(current_node.left != null && current_node.right == null) {
                previous_node.left = current_node.left;
            } else if(current_node.left == null && current_node.right != null) {
                previous_node.left = current_node.right;
            } else {
                Node n = current_node.left;
                while(n.right != null) {
                    n = n.right;
                }
                n.right = current_node.right;
                previous_node.left = current_node.left;
            }
        } else if(previous_node.right == current_node) {
            if (current_node.left == null && current_node.right == null) {
                previous_node.right = null;
            } else if (current_node.left != null && current_node.right == null) {
                previous_node.right = current_node.left;
            } else if (current_node.left == null && current_node.right != null) {
                previous_node.right = current_node.right;
            } else {
                Node n = current_node.left;
                while(n.right != null) {
                    n = n.right;
                }
                n.right = current_node.right;
                previous_node.right = current_node.left;
            }
        }
    }

    public Node search(Node root, int k)
    {
        if(root == null || root.key == k)
            return root;
        if(root.key < k)
            return search(root.right, k);
        return search(root.left, k);
    }

    void preorder(Node root) {
        if(root != null) {
            System.out.printf(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.printf(root.key + " ");
            inorder(root.right);
        }
    }


    void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf(root.key + " ");
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(20);
        bst.insert(32);
        bst.insert(12);
        bst.insert(16);
        bst.delete(20);
        bst.inorder(bst.root);
    }
}
