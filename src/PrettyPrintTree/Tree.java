package PrettyPrintTree;

public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public static void main(String args[]) {
        Tree ttester = new Tree(null);
        ttester.run();

    }

    public boolean add(Node n, Node root) {
        Node current = root;
        while (current.left != null || current.right != null) {
            if (n.value == current.value) {
                return false;
            }
            if (current.left != null && current.value > n.value) {
                current = current.left;
                continue;
            } else if (current.right != null && current.value < n.value) {
                current = current.right;
                continue;
            }
            break;
        }
        if (current.left == null && current.value > n.value) {
            n.parent = current;
            current.left = n;
            return true;
        } else if (current.right == null && current.value < n.value) {
            n.parent = current;
            current.right = n;
            return true;
        }
        return false;
    }

    public String print_tree(Node n) {
        String tree = "";
        if (n != null) {
            tree += print_tree(n.left);
            tree += "-" + n.value;
            tree += print_tree(n.right);
        }
        return tree;
    }

    public void print_poggers_tree(Node n, String tabs, int xd) {
        if (n != null) {
            if (tabs != "") {
                System.out.println(tabs.substring(0, tabs.length() - 4) + "----" + n.value);
            } else {
                System.out.println(tabs + "" + n.value);
            }

            if (xd > 0) {
                tabs = tabs.replace("|", " ");
                xd -= 1;
            }

            tabs += "|    ";
            xd += 1;
            print_poggers_tree(n.right, tabs, 0);
            print_poggers_tree(n.left, tabs, xd);
        } else {
            System.out.println(tabs.substring(0, tabs.length() - 4) + "----X");
        }
    }

    public Node find(int value, Tree t) {
        Node current = t.root;
        boolean searching = true;
        Node found = null;
        while (searching) {
            if (current == null) {
                searching = false;
            } else if (current.value == value) {
                found = current;
                searching = false;
            } else if (value > current.value) {
                current = current.right;
            } else if (value < current.value) {
                current = current.left;
            }
        }
        return found;
    }

    //TODO
    public boolean remove(int value, Tree t) {
        //root stuff
        Node r = find(value, t);
        if (r == null) {
            return false;
        } else if (r.parent == null) {
            if (r.right != null) {
                t.root = r.right;
                t.root.left = r.left;
            } else {
                t.root = r.left;
                t.root.right = r.right;
            }
            return true;
        } else {
            //TODO
            return false;
        }
    }

    public void run() {
        Node first = new Node(null, 10, null, null);
        Tree t = new Tree(first);
        t.add(new Node(null, 5, null, null), t.root);
        t.add(new Node(null, 15, null, null), t.root);
        t.add(new Node(null, 4, null, null), t.root);
        t.add(new Node(null, 3, null, null), t.root);
        t.add(new Node(null, 6, null, null), t.root);
        t.add(new Node(null, 7, null, null), t.root);
        t.add(new Node(null, 1, null, null), t.root);
        t.add(new Node(null, 2, null, null), t.root);
        t.add(new Node(null, 3, null, null), t.root);
        t.add(new Node(null, 18, null, null), t.root);
        t.add(new Node(null, 78, null, null), t.root);
        Node f = t.find(2, t);
        System.out.println("FOUND: " + f.value);
        System.out.println(t.print_tree(t.root));
        t.print_poggers_tree(t.root, "", 0);


        t.remove(78, t);
        System.out.println(t.print_tree(t.root));
        t.remove(10, t);
        System.out.println(t.print_tree(t.root));
        System.out.println(t.root.value);


        Node second = new Node(null, 5, null, null);
        Tree t2 = new Tree(second);
        t2.add(new Node(null, 4, null, null), t2.root);
        t2.add(new Node(null, 3, null, null), t2.root);
        System.out.println(t2.print_tree(t2.root));
        t.remove(5, t2);
        System.out.println(t2.print_tree(t2.root));
        System.out.println(t2.root.value);
    }

    private class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public Node(Node parent, int value, Node left, Node right) {
            this.parent = parent;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}