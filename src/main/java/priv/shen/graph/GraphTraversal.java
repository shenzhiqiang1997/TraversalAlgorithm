package priv.shen.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal<T>{
    private VNode<T>[] vNodes;

    public GraphTraversal(VNode<T>[] vNodes){
        this.vNodes = vNodes;
    }

    public void DFSTraversal(){
        boolean[] visited = new boolean[vNodes.length];
        for (int i = 0; i < vNodes.length; i++) {
            if (!visited[i])
                DFS(i,visited);
        }
    }

    private void DFS(int i, boolean[] visited) {
        VNode<T> vNode = vNodes[i];

        System.out.println(vNode.value);
        visited[i] = true;

        AdjNode adjNode = vNode.firstAdj;

        while (adjNode!=null){
            if (!visited[adjNode.adjVex])
                DFS(adjNode.adjVex,visited);

            adjNode = adjNode.next;
        }
    }

    public void BFSTraversal(){
        boolean[] visited = new boolean[vNodes.length];

        for (int i = 0; i < vNodes.length; i++) {
            if (!visited[i])
                BFS(i,visited);
        }
    }

    private void BFS(int i, boolean[] visited) {
        Queue<VNode<T>> queue = new LinkedList<>();

        VNode<T> vNode = vNodes[i];
        System.out.println(vNode.value);
        visited[i] = true;

        queue.offer(vNode);

        while (!queue.isEmpty()){
            vNode = queue.poll();
            AdjNode adjNode = vNode.firstAdj;

            while (adjNode!=null){
                if (!visited[adjNode.adjVex]){
                    VNode vAdjNode = vNodes[adjNode.adjVex];
                    System.out.println(vAdjNode.value);
                    visited[adjNode.adjVex] = true;
                    queue.offer(vAdjNode);
                }
                adjNode = adjNode.next;
            }
        }

    }
}

