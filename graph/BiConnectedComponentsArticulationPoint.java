/*
 * https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/
 * https://youtu.be/j1QDfU21iZk
 * 
 * https://youtu.be/jFZsDDB0-vo (Abdul Bari)
 * 
 * https://www.geeksforgeeks.org/problems/articulation-point2616/1
*/

package graph;

import java.util.ArrayList;
import java.util.List;

public class BiConnectedComponentsArticulationPoint {

    private static int timer = 0;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        int[] dt = new int[V];
        int[] ldt = new int[V];
        boolean[] mark = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!vis[u]) {
                dfs(u, -1, vis, dt, ldt, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            if (mark[u]) {
                ans.add(u);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }

    private static void dfs(int u, int parent, boolean[] vis, int[] dt, int[] ldt, boolean[] mark,
            List<List<Integer>> adj) {
        vis[u] = true;
        dt[u] = ldt[u] = timer++;

        int child = 0;
        for (int v : adj.get(u)) {
            if (v == parent) {
                continue;
            }

            if (!vis[v]) {
                dfs(v, u, vis, dt, ldt, mark, adj);

                ldt[u] = Math.min(ldt[u], ldt[v]);

                if (ldt[v] >= dt[u] && parent != -1) {
                    mark[u] = true;
                }
                child++;
            } else {
                ldt[u] = Math.min(ldt[u], dt[v]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[u] = true;
        }
    }

    public static void main(String[] args) {
        int V = 7, edges[][] = { { 1, 4 }, { 1, 2 }, { 4, 3 }, { 2, 3 }, { 3, 5 }, { 3, 6 }, { 5, 6 } };

        System.out.println(BiConnectedComponentsArticulationPoint.articulationPoints(V, edges));
    }
}
