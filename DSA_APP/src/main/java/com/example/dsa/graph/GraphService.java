package com.example.dsa.graph;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GraphService {

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, ans);
            }
        }
        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, ans);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                vis[i] = true;
                bfs(i, adj, vis, ans);
            }
        }
        return ans;
    }

    private void bfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            int current = q.poll();
            ans.add(current);
            
            for (int it : adj.get(current)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    public boolean isCyclicDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCyclicDFSHelper(i, adj, vis, dfsVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicDFSHelper(int node, List<List<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[node] = true;
        dfsVis[node] = true;
        
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (isCyclicDFSHelper(it, adj, vis, dfsVis)) {
                    return true;
                }
            } else if (dfsVis[it]) {
                return true;
            }
        }
        dfsVis[node] = false;
        return false;
    }

    public boolean isCyclicBFS(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        return count != V;
    }

    public boolean isBipartiteDFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteDFSHelper(i, 0, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteDFSHelper(int node, int col, List<List<Integer>> adj, int[] color) {
        color[node] = col;
        
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!isBipartiteDFSHelper(it, 1 - col, adj, color)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteBFSHelper(i, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteBFSHelper(int start, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> topologicalSortDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topologicalSortDFSHelper(i, adj, vis, st);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    private void topologicalSortDFSHelper(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                topologicalSortDFSHelper(it, adj, vis, st);
            }
        }
        st.push(node);
    }

    public List<Integer> topologicalSortKahn(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ans;
    }

    public List<Integer> dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        if (adj == null || adj.size() != V) {
            throw new IllegalArgumentException("Adjacency list size must be equal to V. Got adj.size()=" + (adj == null ? 0 : adj.size()) + ", V=" + V);
        }
        if (S < 0 || S >= V) {
            throw new IllegalArgumentException("Source node S out of bounds: " + S);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[S] = 0;
        pq.add(new int[]{S, 0});
        
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int dis = pair[1];
            
            if (node < 0 || node >= V) {
                throw new IllegalArgumentException("Node index out of bounds in queue: " + node);
            }
            if (dis > dist[node]) continue;
            
            for (List<Integer> it : adj.get(node)) {
                if (it == null || it.size() < 2) {
                    throw new IllegalArgumentException("Malformed edge entry at node " + node + ": " + it);
                }
                int adjNode = it.get(0);
                int weight = it.get(1);
                if (adjNode < 0 || adjNode >= V) {
                    throw new IllegalArgumentException("Invalid node index in adjacency list: " + adjNode);
                }
                if (dis + weight < dist[adjNode]) {
                    dist[adjNode] = dis + weight;
                    pq.add(new int[]{adjNode, dist[adjNode]});
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d == Integer.MAX_VALUE ? -1 : d);
        }
        return result;
    }

    public List<Integer> bellmanFord(int V, List<List<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] ) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d == Integer.MAX_VALUE ? -1 : d);
        }
        return result;
    }

    public int[][] floydWarshall(int[][] matrix) {
        int n = matrix.length;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != -1 && matrix[k][j] != -1) {
                        if (matrix[i][j] == -1 || matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public int kruskal(int V, List<List<Integer>> edges) {
        Collections.sort(edges, (a, b) -> a.get(2) - b.get(2));
        
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        
        int mstWt = 0;
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            
            if (findPar(u, parent) != findPar(v, parent)) {
                union(u, v, parent, rank);
                mstWt += wt;
            }
        }
        return mstWt;
    }

    private int findPar(int u, int[] parent) {
        if (u == parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        
        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[v] < rank[u]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public int prim(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] vis = new boolean[V];
        
        pq.add(new int[]{0, 0});
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int wt = pair[1];
            
            if (vis[node]) continue;
            vis[node] = true;
            sum += wt;
            
            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int adjWt = it.get(1);
                
                if (!vis[adjNode]) {
                    pq.add(new int[]{adjNode, adjWt});
                }
            }
        }
        return sum;
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsIslands(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfsIslands(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        dfsIslands(i + 1, j, grid);
        dfsIslands(i - 1, j, grid);
        dfsIslands(i, j + 1, grid);
        dfsIslands(i, j - 1, grid);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        
        dfsFloodFill(sr, sc, image, oldColor, color);
        return image;
    }

    private void dfsFloodFill(int i, int j, int[][] image, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        
        image[i][j] = newColor;
        dfsFloodFill(i + 1, j, image, oldColor, newColor);
        dfsFloodFill(i - 1, j, image, oldColor, newColor);
        dfsFloodFill(i, j + 1, image, oldColor, newColor);
        dfsFloodFill(i, j - 1, image, oldColor, newColor);
    }

    public boolean canFinish(int numCourses, List<List<Integer>> prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> pre : prerequisites) {
            adj.get(pre.get(1)).add(pre.get(0));
        }
        return !isCyclicDFS(numCourses, adj);
    }

    public List<Integer> findOrder(int numCourses, List<List<Integer>> prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> pre : prerequisites) {
            adj.get(pre.get(1)).add(pre.get(0));
        }
        List<Integer> result = topologicalSortKahn(numCourses, adj);
        return result.size() == numCourses ? result : new ArrayList<>();
    }

    public int numProvinces(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfsProvinces(i, isConnected, vis);
            }
        }
        return count;
    }

    private void dfsProvinces(int node, int[][] isConnected, boolean[] vis) {
        vis[node] = true;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !vis[i]) {
                dfsProvinces(i, isConnected, vis);
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) return 0;
        
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
        }
        
        return fresh == 0 ? time - 1 : -1;
    }

    public int wordLadderLength(List<String> wordList, String beginWord, String endWord) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                if (curr.equals(endWord)) return level;
                
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newWord = new String(arr);
                        
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            q.add(newWord);
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public int cheapestFlight(int n, List<List<Integer>> flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> flight : flights) {
            adj.get(flight.get(0)).add(new int[]{flight.get(1), flight.get(2)});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0}); // {node, cost, stops}
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            
            if (stops > k) continue;
            
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];
                
                if (cost + nextCost < dist[nextNode] && stops <= k) {
                    dist[nextNode] = cost + nextCost;
                    q.add(new int[]{nextNode, dist[nextNode], stops + 1});
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public List<Integer> articulationPoints(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        int timer = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsArticulation(i, -1, adj, vis, tin, low, mark, timer);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void dfsArticulation(int node, int parent, List<List<Integer>> adj, boolean[] vis, 
                                int[] tin, int[] low, int[] mark, int timer) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;
        
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            
            if (!vis[it]) {
                dfsArticulation(it, node, adj, vis, tin, low, mark, timer);
                low[node] = Math.min(low[node], low[it]);
                
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    public List<List<Integer>> kosaraju(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        // Step 1: Topological sort
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsKosaraju(i, adj, vis, st);
            }
        }
        
        // Step 2: Transpose the graph
        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }
        
        // Step 3: DFS on transposed graph
        Arrays.fill(vis, false);
        List<List<Integer>> scc = new ArrayList<>();
        
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> component = new ArrayList<>();
                dfsKosarajuRev(node, adjT, vis, component);
                scc.add(component);
            }
        }
        return scc;
    }

    private void dfsKosaraju(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfsKosaraju(it, adj, vis, st);
            }
        }
        st.push(node);
    }

    private void dfsKosarajuRev(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> component) {
        vis[node] = true;
        component.add(node);
        
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfsKosarajuRev(it, adj, vis, component);
            }
        }
    }

    public List<String> disjointSet(int n, List<List<String>> queries) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        List<String> result = new ArrayList<>();
        
        for (List<String> query : queries) {
            String operation = query.get(0);
            
            if (operation.equals("union")) {
                int u = Integer.parseInt(query.get(1));
                int v = Integer.parseInt(query.get(2));
                union(u, v, parent, rank);
                result.add("Union performed");
            } else if (operation.equals("find")) {
                int u = Integer.parseInt(query.get(1));
                int v = Integer.parseInt(query.get(2));
                boolean sameSet = findPar(u, parent) == findPar(v, parent);
                result.add(sameSet ? "Yes" : "No");
            }
        }
        return result;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int timer = 0;
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfsBridges(i, -1, adj, vis, tin, low, timer, bridges);
            }
        }
        return bridges;
    }

    private void dfsBridges(int node, int parent, List<List<Integer>> adj, boolean[] vis, 
                           int[] tin, int[] low, int timer, List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (!vis[it]) {
                dfsBridges(it, node, adj, vis, tin, low, timer, bridges);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }
}
