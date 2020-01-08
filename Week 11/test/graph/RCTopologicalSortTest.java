package graph;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

class RCTopologicalSortTest {

    @Test
    void testCorrectAmountOfElements(){
        RCTopologicalSort<Integer> sort = createExampleSort();
        try {
            List<Integer> list = sort.getSort();

            if(list.size() != sort.getNodes().size()){
                for(Integer i : list){
                    System.out.println(i);
                }
                fail();
            }
        }
        catch(GraphError g){
            System.out.println(g.toString());
        }
    }

    @Test
    void testCorrectElementsInGraph(){
        RCTopologicalSort<Integer> sort = createExampleSort();
        try {
            List<Integer> list = sort.getSort();

            for(Integer i : list){
                if(!sort.contains(i)){
                    fail();
                }
            }
        }
        catch(GraphError g){
            System.out.println(g.toString());
        }
    }

    @Test
    void testOnlyOneElementOfEachNode(){
        RCTopologicalSort<Integer> sort = createExampleSort();
        try {
            List<Integer> list = sort.getSort();

            //HashSets only allow one of each element and the add method returns false if a duplicate is added.
            // We can use this to detect more than one element in a time complexity of O(n).
            HashSet<Integer> duplicateChecker = new HashSet<Integer>();

            for(Integer i : list){
                if(!duplicateChecker.add(i)){
                    fail();
                }
            }
        }
        catch(GraphError g){
            System.out.println(g.toString());
        }
    }

    @Test
    void checkTopological(){
        RCTopologicalSort<Integer> sort = createExampleSort();
        try {
            List<Integer> list = sort.getSort();

            for(int i = 0; i < list.size(); i++){

                for(Integer t : sort.getNeighbours(list.get(i))){
                    int position = list.indexOf(t);
                    if(position < i){
                        fail();
                    }
                }

            }
        }
        catch(GraphError g){
            System.out.println(g.toString());
        }
    }

    /**
     *
     * @return returns a pre-determined graph which is used by the above tests. If this cannot be created for whatever reason, null is returned.
     */
    RCTopologicalSort<Integer> createExampleSort(){
        RCTopologicalSort<Integer> sort = new RCTopologicalSort<>();
        try {
            sort.add(1);
            sort.add(2);
            sort.add(3);
            sort.add(4);
            sort.add(5);
            sort.add(6);
            sort.add(7);
            sort.add(8);
            sort.add(9);

            sort.add(1,9);
            sort.add(3,4);
            sort.add(2,3);
            sort.add(1,2);
            sort.add(1,4);
            sort.add(5,6);
            sort.add(5,8);
            sort.add(6,7);
            sort.add(9,5);
            return sort;
        }
        catch (GraphError error){
            System.out.println(error.toString());
        }
        return null;
    }
}
