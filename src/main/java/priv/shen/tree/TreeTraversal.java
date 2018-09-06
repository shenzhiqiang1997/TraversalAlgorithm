package priv.shen.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal<T> {
    public void preOrder(Tree<T> root){
        if (root!=null){
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Tree<T> root){
        if (root!=null){
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public void postOrder(Tree<T> root){
        if (root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void preOrderWithoutRecursion(Tree<T> node){
        Stack<Tree<T>> stack = new Stack<>();
        while (node!=null||!stack.empty()){
            if (node!=null){
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void inOrderWithoutRecursion(Tree<T> node){
        Stack<Tree<T>> stack = new Stack<>();
        while (node!=null||!stack.empty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    public void postOrderWithoutRecursion(Tree<T> node){
        Stack<Tree<T>> stack = new Stack<>();
        while (node!=null||!stack.empty()){
            if (node!=null){
                if (!node.visited)
                    stack.push(node);
                node = node.left;
            } else{
                node = stack.pop();
                if (!node.visited){
                    node.visited = true;
                    stack.push(node);
                } else {
                    System.out.println(node.value);
                }
                node = node.right;
            }
        }
    }

    public void levelOrder(Tree<T> root){
        Queue<Tree<T>> queue = new LinkedList<>();
        if (root!=null){
            queue.offer(root);
            while (queue.size()>0){
                Tree<T> node = queue.poll();
                System.out.println(node.value);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
        }
    }
}

class TreeTraversalTest{
    public static void main(String[] args) {
        TreeTraversal<Integer> treeTraversal = new TreeTraversal<>();

        Tree<Integer> root = new Tree<>(1);
        root.left = new Tree<>(2);
        root.right = new Tree<>(3);

        treeTraversal.preOrderWithoutRecursion(root);
        treeTraversal.inOrderWithoutRecursion(root);
        treeTraversal.postOrderWithoutRecursion(root);

        treeTraversal.levelOrder(root);
    }
}
