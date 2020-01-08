package graph;

import java.util.*;

public class DepthFirstTraversalGraph<T> extends AdjacencyGraph<T> implements Traversal<T> {
    private List<T> traversalList = new ArrayList<T>();

    @Override
    public List<T> traverse() throws GraphError {
        Set<T> set = getNodes();
        for(T t : set){
            visitNode(t);
        }
        return traversalList;
    }

    private Boolean checkVisited(T t){
        return traversalList.contains(t);
    }

    private void visitNode(T t){
        if(checkVisited(t)) { return; }
        traversalList.add(t);
        try {
            Set<T> neighbours = getNeighbours(t);
            for(T j : neighbours){
                if(!checkVisited(j)){
                    visitNode(j);
                }
            }
        }
        catch(GraphError e){
            System.out.println(e.toString());
        }
    }

}
