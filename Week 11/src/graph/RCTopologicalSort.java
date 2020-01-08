package graph;

import java.util.*;

/**
 *
 * @param <T> The generic type to be used by the topological sort.
 */
public class RCTopologicalSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T>{

    private List<T> sortList = new ArrayList<T>();
    private Hashtable<T, Integer> referenceCount = new Hashtable<>();

    /**
     *
     * @return A list of type T which is in a topological sort
     * @throws GraphError A type of error made for the graph used by the topological sort
     */
    @Override
    public List<T> getSort() throws GraphError {
        Set<T> set = getNodes();

        //1: setup the hashtable so that each value is 0
        for(T t : set){
            referenceCount.put(t, 0);
        }

        //2: now count how many links each node has going into it and apply that to the hash table
        for(T t : set){
            Set<T> neighbours = getNeighbours(t);
            for(T neighbour : neighbours){
                referenceCount.put(neighbour, referenceCount.get(neighbour) + 1);
            }
        }

        //3: perform the actual reference counting topological sort
        while(getNextNode(set) != null) {
            T next = getNextNode(set);
            sortList.add(next);
            for (T neighbour : getNeighbours(next)) {
                referenceCount.put(neighbour, referenceCount.get(neighbour) - 1);
            }
        }

        return sortList;
    }

    /**
     *
     * @param set a set of the nodes used by the graph
     * @return the next node to be used by the topological sort, found by getting the next node which is not already in the return list and has a reference count of 0
     */
    private T getNextNode(Set<T> set){
        for(T t : set){
            if(!sortList.contains(t)) {
                if (referenceCount.get(t) == 0) {
                    return t;
                }
            }
        }
        return null;
    }
}
