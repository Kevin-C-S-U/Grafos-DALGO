package uniandes.algorithms.minimumpath;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

	private List<Integer> vertex;

	private int[][] edges;

	private List<Integer> weights;

	public DirectedGraph(int size) {

		this.vertex = new ArrayList<Integer>();

		this.edges = new int[size][size];
	}

	/**
	 * 
	 * @param idFirst
	 * @param idSecond
	 * @param weight
	 */
	public void addEdge(int idFirst, int idSecond, int weight) {
		if(!this.vertex.contains(idFirst)) {
			this.vertex.add(idFirst);
		}
		if(!this.vertex.contains(idSecond)) {
			this.vertex.add(idSecond);
		}
		this.edges[idFirst][idSecond] = weight;
	}

	public List<Integer> getVertex() {
		return vertex;
	}

	public void setVertex(List<Integer> vertex) {
		this.vertex = vertex;
	}

	public int[][] getEdges() {
		return edges;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}

	public List<Integer> getWeights() {
		return weights;
	}

	public void setWeights(List<Integer> weights) {
		this.weights = weights;
	}

	

	
}
