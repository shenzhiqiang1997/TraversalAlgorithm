package priv.shen.tree;

public class Tree<T> {
    public T value;
    public boolean visited;
    public Tree<T> left;
    public Tree<T> right;

    public Tree(T value){
        this.value = value;
    }
}
