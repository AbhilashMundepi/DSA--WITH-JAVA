import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    static class Edge {
        int src;
        int dest;
        // int wt;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            // this.wt = w;

        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[2].add(new Edge(4, 1));

        graph[4].add(new Edge(5, 0));
        graph[4].add(new Edge(4, 0));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));

        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }

    }

    // O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;

            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }

            }
            // case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing -> continue
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no color
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {// BFS
                q.add(i);
                col[i] = 0;// yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; // NOT bipartite
                        }
                    }
                }
            }

        }

        return true;

    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {// cycle
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s); // modified dfs

            }
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void bfsTopSort(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bfsTopSort(graph);

        int src = 5, dest = 1;
        printAllPath(graph, src, dest, "");

    }

}
