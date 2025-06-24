package com.example.dsa.graph;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/graph")
@Tag(name = "Graph", description = "DSA Graph Problems")
public class GraphController {
    private final GraphService service;

    @Autowired
    public GraphController(GraphService service) {
        this.service = service;
    }

    @Operation(summary = "DFS traversal of graph")
    @PostMapping("/dfs-traversal")
    public ResponseEntity<GraphResponse> dfsTraversal(@Valid @RequestBody GraphRequest.DFSTraversalInput request) {
        System.out.println("Received V = " + request.getV());
        List<Integer> result = service.dfsOfGraph(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setDfsTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "BFS traversal of graph")
    @PostMapping("/bfs-traversal")
    public ResponseEntity<GraphResponse> bfsTraversal(@Valid @RequestBody GraphRequest.BFSTraversalInput request) {
        List<Integer> result = service.bfsOfGraph(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setBfsTraversal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if graph is cyclic using DFS")
    @PostMapping("/is-cyclic-dfs")
    public ResponseEntity<GraphResponse> isCyclicDFS(@Valid @RequestBody GraphRequest.IsCyclicInput request) {
        boolean result = service.isCyclicDFS(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setIsCyclicDFS(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if graph is cyclic using BFS")
    @PostMapping("/is-cyclic-bfs")
    public ResponseEntity<GraphResponse> isCyclicBFS(@Valid @RequestBody GraphRequest.IsCyclicInput request) {
        boolean result = service.isCyclicBFS(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setIsCyclicBFS(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if graph is bipartite using DFS")
    @PostMapping("/is-bipartite-dfs")
    public ResponseEntity<GraphResponse> isBipartiteDFS(@Valid @RequestBody GraphRequest.IsBipartiteInput request) {
        boolean result = service.isBipartiteDFS(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setIsBipartiteDFS(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Check if graph is bipartite using BFS")
    @PostMapping("/is-bipartite-bfs")
    public ResponseEntity<GraphResponse> isBipartiteBFS(@Valid @RequestBody GraphRequest.IsBipartiteInput request) {
        boolean result = service.isBipartiteBFS(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setIsBipartiteBFS(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Topological sort using DFS")
    @PostMapping("/topological-sort-dfs")
    public ResponseEntity<GraphResponse> topologicalSortDFS(@Valid @RequestBody GraphRequest.TopologicalSortInput request) {
        List<Integer> result = service.topologicalSortDFS(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setTopologicalSortDFS(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Topological sort using Kahn's algorithm")
    @PostMapping("/topological-sort-kahn")
    public ResponseEntity<GraphResponse> topologicalSortKahn(@Valid @RequestBody GraphRequest.TopologicalSortInput request) {
        List<Integer> result = service.topologicalSortKahn(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setTopologicalSortKahn(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Dijkstra's shortest path algorithm")
    @PostMapping("/dijkstra")
    public ResponseEntity<GraphResponse> dijkstra(@Valid @RequestBody GraphRequest.DijkstraInput request) {
        List<Integer> result = service.dijkstra(request.getV(), request.getAdj(), request.getS());
        GraphResponse response = new GraphResponse();
        response.setDijkstra(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Bellman-Ford algorithm")
    @PostMapping("/bellman-ford")
    public ResponseEntity<GraphResponse> bellmanFord(@Valid @RequestBody GraphRequest.BellmanFordInput request) {
        List<Integer> result = service.bellmanFord(request.getV(), request.getEdges(), request.getS());
        GraphResponse response = new GraphResponse();
        response.setBellmanFord(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Floyd-Warshall algorithm")
    @PostMapping("/floyd-warshall")
    public ResponseEntity<GraphResponse> floydWarshall(@Valid @RequestBody GraphRequest.FloydWarshallInput request) {
        int[][] result = service.floydWarshall(request.getMatrix());
        GraphResponse response = new GraphResponse();
        response.setFloydWarshall(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Kruskal's algorithm for MST")
    @PostMapping("/kruskal")
    public ResponseEntity<GraphResponse> kruskal(@Valid @RequestBody GraphRequest.KruskalInput request) {
        int result = service.kruskal(request.getV(), request.getEdges());
        GraphResponse response = new GraphResponse();
        response.setKruskal(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Prim's algorithm for MST")
    @PostMapping("/prim")
    public ResponseEntity<GraphResponse> prim(@Valid @RequestBody GraphRequest.PrimInput request) {
        int result = service.prim(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setPrim(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Number of islands")
    @PostMapping("/num-islands")
    public ResponseEntity<GraphResponse> numIslands(@Valid @RequestBody GraphRequest.NumIslandsInput request) {
        int result = service.numIslands(request.getGrid());
        GraphResponse response = new GraphResponse();
        response.setNumIslands(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Flood fill algorithm")
    @PostMapping("/flood-fill")
    public ResponseEntity<GraphResponse> floodFill(@Valid @RequestBody GraphRequest.FloodFillInput request) {
        int[][] result = service.floodFill(request.getImage(), request.getSr(), request.getSc(), request.getColor());
        GraphResponse response = new GraphResponse();
        response.setFloodFill(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Course schedule - can finish")
    @PostMapping("/can-finish")
    public ResponseEntity<GraphResponse> canFinish(@Valid @RequestBody GraphRequest.CanFinishInput request) {
        boolean result = service.canFinish(request.getNumCourses(), request.getPrerequisites());
        GraphResponse response = new GraphResponse();
        response.setCanFinish(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Course schedule - find order")
    @PostMapping("/find-order")
    public ResponseEntity<GraphResponse> findOrder(@Valid @RequestBody GraphRequest.FindOrderInput request) {
        List<Integer> result = service.findOrder(request.getNumCourses(), request.getPrerequisites());
        GraphResponse response = new GraphResponse();
        response.setFindOrder(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Number of provinces")
    @PostMapping("/num-provinces")
    public ResponseEntity<GraphResponse> numProvinces(@Valid @RequestBody GraphRequest.NumProvincesInput request) {
        int result = service.numProvinces(request.getIsConnected());
        GraphResponse response = new GraphResponse();
        response.setNumProvinces(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Oranges rotting")
    @PostMapping("/oranges-rotting")
    public ResponseEntity<GraphResponse> orangesRotting(@Valid @RequestBody GraphRequest.OrangesRottingInput request) {
        int result = service.orangesRotting(request.getGrid());
        GraphResponse response = new GraphResponse();
        response.setOrangesRotting(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Word ladder length")
    @PostMapping("/word-ladder-length")
    public ResponseEntity<GraphResponse> wordLadderLength(@Valid @RequestBody GraphRequest.WordLadderLengthInput request) {
        int result = service.wordLadderLength(request.getWordList(), request.getBeginWord(), request.getEndWord());
        GraphResponse response = new GraphResponse();
        response.setWordLadderLength(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cheapest flights within k stops")
    @PostMapping("/cheapest-flight")
    public ResponseEntity<GraphResponse> cheapestFlight(@Valid @RequestBody GraphRequest.CheapestFlightInput request) {
        int result = service.cheapestFlight(request.getN(), request.getFlights(), request.getSrc(), request.getDst(), request.getK());
        GraphResponse response = new GraphResponse();
        response.setCheapestFlight(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Articulation points")
    @PostMapping("/articulation-points")
    public ResponseEntity<GraphResponse> articulationPoints(@Valid @RequestBody GraphRequest.ArticulationPointsInput request) {
        List<Integer> result = service.articulationPoints(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setArticulationPoints(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Critical connections")
    @PostMapping("/critical-connections")
    public ResponseEntity<GraphResponse> criticalConnections(@Valid @RequestBody GraphRequest.CriticalConnectionsInput request) {
        List<List<Integer>> result = service.criticalConnections(request.getN(), request.getConnections());
        GraphResponse response = new GraphResponse();
        response.setCriticalConnections(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Kosaraju's algorithm for strongly connected components")
    @PostMapping("/kosaraju")
    public ResponseEntity<GraphResponse> kosaraju(@Valid @RequestBody GraphRequest.KosarajuInput request) {
        List<List<Integer>> result = service.kosaraju(request.getV(), request.getAdj());
        GraphResponse response = new GraphResponse();
        response.setKosaraju(result);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Disjoint set operations")
    @PostMapping("/disjoint-set")
    public ResponseEntity<GraphResponse> disjointSet(@Valid @RequestBody GraphRequest.DisjointSetInput request) {
        List<String> result = service.disjointSet(request.getN(), request.getQueries());
        GraphResponse response = new GraphResponse();
        response.setDisjointSet(result);
        return ResponseEntity.ok(response);
    }
}