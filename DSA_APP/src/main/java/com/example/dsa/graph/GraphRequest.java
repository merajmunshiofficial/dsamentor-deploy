package com.example.dsa.graph;

import jakarta.validation.constraints.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphRequest {

    public static class DFSTraversalInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class BFSTraversalInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class IsCyclicInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class IsBipartiteInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class TopologicalSortInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class DijkstraInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<List<Integer>>> adj;
        
        @Min(0)
        private int S;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<List<Integer>>> getAdj() { return adj; }
        public void setAdj(List<List<List<Integer>>> adj) { this.adj = adj; }
        
        public int getS() { return S; }
        public void setS(int S) { this.S = S; }
    }

    public static class BellmanFordInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> edges;
        
        @Min(0)
        private int S;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getEdges() { return edges; }
        public void setEdges(List<List<Integer>> edges) { this.edges = edges; }
        
        public int getS() { return S; }
        public void setS(int S) { this.S = S; }
    }

    public static class KruskalInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> edges;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getEdges() { return edges; }
        public void setEdges(List<List<Integer>> edges) { this.edges = edges; }
    }

    public static class PrimInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<List<Integer>>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<List<Integer>>> getAdj() { return adj; }
        public void setAdj(List<List<List<Integer>>> adj) { this.adj = adj; }
    }

    public static class NumIslandsInput {
        @NotNull
        private char[][] grid;

        public char[][] getGrid() { return grid; }
        public void setGrid(char[][] grid) { this.grid = grid; }
    }

    public static class FloodFillInput {
        @NotNull
        private int[][] image;
        
        @Min(0)
        private int sr;
        
        @Min(0)
        private int sc;
        
        @Min(0)
        private int color;

        public int[][] getImage() { return image; }
        public void setImage(int[][] image) { this.image = image; }
        
        public int getSr() { return sr; }
        public void setSr(int sr) { this.sr = sr; }
        
        public int getSc() { return sc; }
        public void setSc(int sc) { this.sc = sc; }
        
        public int getColor() { return color; }
        public void setColor(int color) { this.color = color; }
    }

    public static class CanFinishInput {
        @Min(1)
        private int numCourses;
        
        @NotNull
        private List<List<Integer>> prerequisites;

        public int getNumCourses() { return numCourses; }
        public void setNumCourses(int numCourses) { this.numCourses = numCourses; }
        
        public List<List<Integer>> getPrerequisites() { return prerequisites; }
        public void setPrerequisites(List<List<Integer>> prerequisites) { this.prerequisites = prerequisites; }
    }

    public static class FindOrderInput {
        @Min(1)
        private int numCourses;
        
        @NotNull
        private List<List<Integer>> prerequisites;

        public int getNumCourses() { return numCourses; }
        public void setNumCourses(int numCourses) { this.numCourses = numCourses; }
        
        public List<List<Integer>> getPrerequisites() { return prerequisites; }
        public void setPrerequisites(List<List<Integer>> prerequisites) { this.prerequisites = prerequisites; }
    }

    public static class NumProvincesInput {
        @NotNull
        private int[][] isConnected;

        public int[][] getIsConnected() { return isConnected; }
        public void setIsConnected(int[][] isConnected) { this.isConnected = isConnected; }
    }

    public static class OrangesRottingInput {
        @NotNull
        private int[][] grid;

        public int[][] getGrid() { return grid; }
        public void setGrid(int[][] grid) { this.grid = grid; }
    }

    public static class WordLadderLengthInput {
        @NotNull
        private List<String> wordList;
        
        @NotBlank
        private String beginWord;
        
        @NotBlank
        private String endWord;

        public List<String> getWordList() { return wordList; }
        public void setWordList(List<String> wordList) { this.wordList = wordList; }
        
        public String getBeginWord() { return beginWord; }
        public void setBeginWord(String beginWord) { this.beginWord = beginWord; }
        
        public String getEndWord() { return endWord; }
        public void setEndWord(String endWord) { this.endWord = endWord; }
    }

    public static class CheapestFlightInput {
        @Min(1)
        private int n;
        
        @NotNull
        private List<List<Integer>> flights;
        
        @Min(0)
        private int src;
        
        @Min(0)
        private int dst;
        
        @Min(0)
        private int k;

        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        
        public List<List<Integer>> getFlights() { return flights; }
        public void setFlights(List<List<Integer>> flights) { this.flights = flights; }
        
        public int getSrc() { return src; }
        public void setSrc(int src) { this.src = src; }
        
        public int getDst() { return dst; }
        public void setDst(int dst) { this.dst = dst; }
        
        public int getK() { return k; }
        public void setK(int k) { this.k = k; }
    }

    public static class ArticulationPointsInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class CriticalConnectionsInput {
        @Min(1)
        private int n;
        
        @NotNull
        private List<List<Integer>> connections;

        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        
        public List<List<Integer>> getConnections() { return connections; }
        public void setConnections(List<List<Integer>> connections) { this.connections = connections; }
    }

    public static class KosarajuInput {
        @Min(1)
        private int V;
        
        @NotNull
        private List<List<Integer>> adj;

        public int getV() { return V; }
        public void setV(int V) { this.V = V; }
        @JsonProperty("v")
        public void setVLower(int v) { this.V = v; }
        @JsonProperty("V")
        public void setVUpper(int V) { this.V = V; }
        
        public List<List<Integer>> getAdj() { return adj; }
        public void setAdj(List<List<Integer>> adj) { this.adj = adj; }
    }

    public static class DisjointSetInput {
        @Min(1)
        private int n;
        
        @NotNull
        private List<List<String>> queries;

        public int getN() { return n; }
        public void setN(int n) { this.n = n; }
        
        public List<List<String>> getQueries() { return queries; }
        public void setQueries(List<List<String>> queries) { this.queries = queries; }
    }

    public static class FloydWarshallInput {
        @NotNull
        private int[][] matrix;

        public int[][] getMatrix() { return matrix; }
        public void setMatrix(int[][] matrix) { this.matrix = matrix; }
    }
}