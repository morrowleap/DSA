/*
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/
 * https://youtu.be/V6H1qAeB-l4?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/
 * https://youtu.be/PATgNiuTP20?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/g-34-dijkstras-algorithm-intuition-and-time-complexity-derivation/
 * https://youtu.be/3dINsjyfooY?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 * https://youtu.be/rp1SMw7HSO8?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 * 
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * 
 * https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * 
*/

package graph;

public class ShortestPathDijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {

        return null;
    }

    public static void main(String[] args) {
        int V = 3, edges[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } }, src = 2;

        ShortestPathDijkstraAlgorithm sol = new ShortestPathDijkstraAlgorithm();
        System.out.println(sol.dijkstra(V, edges, src));
    }
}
