/*
 * https://takeuforward.org/graph/introduction-to-graph/
 * https://takeuforward.org/graph/graph-representation-in-c/
*/

package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Graph {
    private int vertexCount;
    private List<List<Integer>> adjList;
    private int[][] adjMatrix;

    Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }
        adjMatrix = new int[vertexCount + 1][vertexCount + 1];
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);

        adjMatrix[u][v] = 1;
        adjMatrix[u][v] = 1;
    }

    public void printAdjList() {
        for (int u = 0; u <= vertexCount; u++) {
            System.out.print(u + "-> ");
            for (int v : adjList.get(u)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    void printMatrix() {
        for (int i = 0; i <= vertexCount; ++i) {
            for (int j = 0; j <= vertexCount; ++j) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// In case of vertex is not an Integer we will make a new class for vertex and
// use that in place of int, Integer
// adjList will become adjMap in that case

public class GraphRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printAdjList();
        g.printMatrix();

        sc.close();
    }
}
