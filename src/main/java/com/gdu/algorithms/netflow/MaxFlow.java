package com.gdu.algorithms.netflow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hy2 on 2016/3/22.
 */
public class MaxFlow {
    public static int V=7;

    /**
     *
     * @param graph  残留网络
     * @param source 起始节点
     * @param target 目的节点
     * @param path  路径
     * @return  是否存在这样的一条路径
     */
    public static boolean hasPath(int graph[][],int source,int target,int path[] ){
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        visited[source]=true;
        while (queue.size()>0){
            int hqueue=queue.poll();
            for (int i=0;i<V;i++){
                if(!visited[i] && graph[hqueue][i]>0){
                    queue.add(i);
                    visited[i]=true;
                    path[i]=hqueue;
                    System.out.println("Visiting node :"+i);
                }//end if
            }//end for
        }//end while
        return visited[target]==true;
    }

    /**
     *
     * @param graph 有向图
     * @param source 起始节点
     * @param target 目标节点
     */
    public static int maxFlow(int[][] graph,int source,int target){
        int[][] tGraph=new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                tGraph[i][j]=graph[i][j];
                System.out.println(tGraph[i][j]+":visited"+"i="+i+"  j="+j);
            }
        }

        int maxFlow=0;
        int[] path=new int[V];
        while (hasPath(tGraph,source,target,path)){
            int minFlow=Integer.MAX_VALUE;
            for (int v=target;v!=source;v=path[v]){
                int p=path[v];
                minFlow=Math.min(minFlow,tGraph[p][v]);
                System.out.println("minflow="+minFlow);
            }

            for(int v=target;v!=source;v=path[v]){
                int p=path[v];
                tGraph[p][v]-=minFlow;
                tGraph[v][p]+=maxFlow;
                System.out.println("minflow="+minFlow);
            }
            maxFlow+=minFlow;
            System.out.println("maxFlow="+maxFlow);
        }
        return maxFlow;
    }
}
