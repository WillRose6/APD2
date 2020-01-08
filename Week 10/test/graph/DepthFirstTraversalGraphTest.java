package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class DepthFirstTraversalGraphTest {

    @Test
    void testContainAllNodes(){
        DepthFirstTraversalGraph<Integer> graph = setUpGraphOfSizeSeven();
        try {
            List<Integer> list = graph.traverse();

            if(!list.contains(1) || !list.contains(2) || !list.contains(3) || !list.contains(4) || !list.contains(5) || !list.contains(6) || !list.contains(7)){
                fail();
            }
        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }
    }

    @Test
    void testOnlyNodesFromThisGraph(){
        DepthFirstTraversalGraph<Integer> graph = setUpGraphOfSizeSeven();
        try {
            List<Integer> list = graph.traverse();
            for(Integer i : list){
                if(i < 1 || i > 7){
                    fail();
                }
            }
        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }
    }

    @Test
    void testOnlyOneNodeEach(){
        DepthFirstTraversalGraph<Integer> graph = setUpGraphOfSizeSeven();
        try {
            List<Integer> list = graph.traverse();

            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.size(); j++){
                    if(i != j){
                        if(list.get(i) == list.get(j)){
                            fail();
                        }
                    }
                }
            }
        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }
    }

    @Test
    void testExampleGraphOne(){
        DepthFirstTraversalGraph<Integer> graph = setUpExampleGraph1();
        try {
            List<Integer> list = graph.traverse();

            for(int i = 0; i < list.size(); i++){
                if(i != 3){
                    if(!list.get(i).equals(list.get(i+1)-1)){
                        fail();
                    }
                }
            }
        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }
    }

    DepthFirstTraversalGraph<Integer> setUpGraphOfSizeSeven(){
        DepthFirstTraversalGraph<Integer> dft = new DepthFirstTraversalGraph<>();
        try {
            dft.add(1);
            dft.add(2);
            dft.add(3);
            dft.add(4);
            dft.add(5);
            dft.add(6);
            dft.add(7);

            dft.add(1,3);
            dft.add(1,2);
            dft.add(2,6);
            dft.add(6,7);
            dft.add(2,4);
            dft.add(4,5);

        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }

        return dft;
    }

    DepthFirstTraversalGraph<Integer> setUpExampleGraph1(){
        DepthFirstTraversalGraph<Integer> dft = new DepthFirstTraversalGraph<>();
        try {
            dft.add(0);
            dft.add(1);
            dft.add(2);
            dft.add(3);

            dft.add(0,1);
            dft.add(1,2);
            dft.add(2,3);
            dft.add(3,0);
        }
        catch(GraphError graphError){
            System.out.println(graphError.toString());
        }

        return dft;
    }
}