package com.crackingTheCodingInterview.treesAndGraphs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * The {@link Graph}
 * <p>
 * A graph can be created with both a adjacency matrix and
 * an adjacency list. In this example we'll use an adjacency
 * list. 
 * <p>
 * An adjacency list is created with an array, where the indices
 * represent the nodes numbered 1 -> n, and the contents in the list
 * are the adjacent nodes.
 * <p>
 * @author szeyick
 */
public class Graph {

	/**
	 * The graph.
	 */
	private GraphNode graph[];
	
	/**
	 * The size of the graph.
	 */
	private int size;
	
	/**
	 * Constructor
	 * @param - graphSize - The size of the graph.
	 */
	public Graph(int graphSize) {
		size = 0;
		graph = new GraphNode[graphSize];
	}
	
	/**
	 * Print the contents of the graph.
	 */
	public void printGraph() {
		for (int i = 0; i < graph.length; i++) {
			GraphNode node = graph[i];
			System.out.print(i + " -> ");
			if (node != null) {
				GraphNode adjacent = node.next;
				while (adjacent != null) {
					System.out.print(adjacent.value + "->");
					adjacent = adjacent.next;
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Add a connection between two nodes in the graph.
	 * @param nodeFrom - The node that begins the connection.
	 * @param nodeTo - The node that ends the connection.
	 */
	public void addNode(int nodeFrom, int nodeTo) {
		// When we connect one node to another, we need to do the connection
		// both ways, so the nodeFrom becomes the nodeTo and vice versa.
		size++;
		if (graph[nodeFrom] == null) {
			graph[nodeFrom] = new GraphNode(nodeFrom);
		}
		if (graph[nodeTo] == null) {
			graph[nodeTo] = new GraphNode(nodeTo);
		}
		graph[nodeFrom].addNode(nodeTo);
		graph[nodeTo].addNode(nodeFrom);
	}
	
	/**
	 * Recursively add a connection between two nodes
	 * in a graph. In this method, we add to one index,
	 * then call the method and flip the arguments.
	 * @param nodeFrom - The node that begins the connection.
	 * @param nodeTo - The node that ends the connection.
	 */
	public void addNodeToGraph(int nodeFrom, int nodeTo) {
		if (graph[nodeFrom] == null) {
			graph[nodeFrom] = new GraphNode(nodeFrom);
			addNode(nodeTo, nodeFrom);
		}
		else {
			graph[nodeFrom].addNode(nodeTo);
			addNode(nodeFrom, nodeTo);
		}
	}

	/**
	 * @return - The number of nodes in the graph.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Determine if there is a path between two nodes.
	 * @param fromNode - The node to start from.
	 * @param toNode - The node to find.
	 * @return <code>true</code> if a path exists between the
	 * two, <code>false</code> otherwise.
	 */
	public boolean searchBFS(int fromNode, int toNode) {
		if (graph[fromNode] == null || graph[toNode] == null) {
			return false;
		}
		return bfs(graph[fromNode], graph[toNode]);
	}
	
	/**
	 * Use a breadth first search to find a path between two nodes.
	 * @param startNode - The node to begin the search.
	 * @param endNode - The destination node.
	 * @return <code>true</code> if a path exists, <code>false</code>
	 * otherwise.
	 */
	private boolean bfs(GraphNode startNode, GraphNode endNode) {
		List<Integer> queue = new LinkedList<Integer>(); // A list of visited nodes.
		List<Integer> visited = new LinkedList<Integer>(); // A list of visited nodes.
		if (reachedDestination(startNode, endNode)) {
			return true;
		}
		
		boolean pathExists = false;
		queue.add(startNode.value); // We add the first node to the queue since we need to visit its neighbours.
		while (!queue.isEmpty()) {
			GraphNode currentNode = graph[queue.remove(0)]; // Dequeue the first item from the queue.
			visited.add(currentNode.value);
			GraphNode adjacentNode = currentNode.next;
			while (adjacentNode != null) {
				if (reachedDestination(adjacentNode, endNode)) {
					pathExists = true;
					break;
				}
				if (!visited.contains(adjacentNode.value)) {
					queue.add(adjacentNode.value);
				}
				adjacentNode = adjacentNode.next;
			}
		}
		return pathExists;
	}

	/**
	 * Use a DFS to determine if a path exists between two nodes.
	 * @param startNode - The node to begin.
	 * @param targetNode - The target or destination.
	 * @return <code>true</code> if there is a path between the start
	 * and target, <code>false</code> otherwise.
	 */
	public boolean searchDFS(int startNode, int targetNode) {
		if (graph[startNode] == null || graph[targetNode] == null) {
			return false;
		}
		return dfs(startNode, targetNode, new ArrayList<Integer>());
	}
	
	/**
	 * Use a DFS to find the target node. The DFS uses recursion which 
	 * maintains a natural stack to determine the next node to visit.
	 * @param currentNode - The current node we're searching.
	 * @param targetNode - The target node to find.
	 * @return <code>true</code> if we can find the target node, 
	 * <code>false</code> otherwise.
	 */
	private boolean dfs(Integer currentNode, Integer targetNode, List<Integer> visited) {
		// Base case - if the current node is null we return.
		GraphNode currNode = graph[currentNode];
		if (currNode == null) {
			return false;
		}
		if (reachedDestination(graph[currentNode], graph[targetNode])) {
			return true;
		}
		// Mark the current node as visited.
		visited.add(currNode.value);
		GraphNode adjacentNode = currNode.next;
		while (adjacentNode != null) {
			if (!visited.contains(adjacentNode.value)) {
				return dfs(adjacentNode.value, targetNode, visited);
			}
			adjacentNode = adjacentNode.next;
		}
		return false;
	}
	
	/**
	 * Evaluate if we have reached out destination.
	 * @param currentNode - The current node.
	 * @param destination - The destination node.
	 * @return <code>true</code> if the current node is the destination, <code>false</code>
	 * otherwise.
	 */
	private boolean reachedDestination(GraphNode currentNode, GraphNode destination) {
		if (currentNode.value == destination.value) {
			return true;
		}
		return false;
	}
}
