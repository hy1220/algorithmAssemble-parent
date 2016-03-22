import com.gdu.algorithms.netflow.MaxFlow;

/**
 * Created by hy2 on 2016/3/22.
 */
public class Main {
    public static void main(String[] args){
        MaxFlow maxF=new MaxFlow();
        int[][] graph={
                {0,3,2,3,0,0,0},
                {0,0,0,0,0,0,5},
                {0,1,0,0,0,1,0},
                {0,0,2,0,2,0,0},
                {0,0,0,0,0,0,5},
                {0,4,0,0,2,0,1},
                {0,0,0,0,0,0,0}
        };
        maxF.V=graph.length;
        int flow=maxF.maxFlow(graph, 0, 6);
        System.out.println("MaxFlow is :"+flow);
    }
}
