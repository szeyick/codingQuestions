package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.graph.Graph;

/**
 * The {@link DirectedGraph}
 * <p>
 * Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes.
 * <p>
 * This question involves a start node and a finish node, and
 * the operation to implement is a "search". If you can find
 * the second node from the first one, it means that there is a
 * path between the two. It may also be beneficial to ask as to
 * whether the nodes are close together or not as it may be more
 * efficient to implement a DFS or BFS depending on how closely the
 * nodes are together or how big the graph is
 * <p>
 * @author szeyick
 */
public class DirectedGraph {
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Graph directedGraph = constructGraph();
		directedGraph.printGraph();
		
		System.out.println("Searching using BFS - ");
		System.out.println("Is there a path between node 0 and 2 - " + directedGraph.searchBFS(0, 2));
		System.out.println("Is there a path between node 3 and 2 - " + directedGraph.searchBFS(3, 2));
		System.out.println("Is there a path between node 0 and 7 - " + directedGraph.searchBFS(0, 7));
		System.out.println("Is there a path between node 7 and 8 - " + directedGraph.searchBFS(7, 8));
		System.out.println("Is there a path between node 8 and 7 - " + directedGraph.searchBFS(8, 7));
		System.out.println("Is there a path between node 1 and 1 - " + directedGraph.searchBFS(1, 1));
		
		System.out.println();
		System.out.println("Searching using DFS - ");
		System.out.println("Is there a path between node 0 and 2 - " + directedGraph.searchDFS(0, 1));
		System.out.println("Is there a path between node 3 and 2 - " + directedGraph.searchDFS(3, 2));
		System.out.println("Is there a path between node 0 and 7 - " + directedGraph.searchDFS(0, 7));
		System.out.println("Is there a path between node 7 and 8 - " + directedGraph.searchDFS(7, 8));
		System.out.println("Is there a path between node 8 and 7 - " + directedGraph.searchDFS(8, 7));
		System.out.println("Is there a path between node 1 and 1 - " + directedGraph.searchDFS(1, 1));
	}
	
	/**
	 * @return - A constructed graph of 4 nodes in a square.
	 */
	private static Graph constructGraph() {
		Graph graph = new Graph(10);
		graph.addNodeToGraph(0, 1);
		graph.addNodeToGraph(0, 3);
		graph.addNodeToGraph(1, 2);
		graph.addNodeToGraph(2, 3);
		graph.addNodeToGraph(7, 8);
		return graph;
	}
}
