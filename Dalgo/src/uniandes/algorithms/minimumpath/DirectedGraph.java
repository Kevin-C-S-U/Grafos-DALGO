package uniandes.algorithms.minimumpath;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

	private List<Integer> vertex;

	private int[][] edges;
	
	private ArrayList<ArrayList<Integer>> definededges;

	private List<Integer> weights;

	//Para grafos no dirigidos se representa como una matriz simétrica
	public DirectedGraph(int size) {

		this.vertex = new ArrayList<Integer>();

		this.edges = new int[size][size];
		
		this.definededges = new ArrayList<ArrayList<Integer>>();
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
		if(weight!=-1) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(idFirst);
			path.add(idSecond);
			ArrayList<ArrayList<Integer>> edges = getDefinededges();
			edges.add(path);			
			setDefinededges(edges);
			
		}
	}

	public ArrayList<ArrayList<Integer>> getDefinededges() {
		return definededges;
	}

	public void setDefinededges(ArrayList<ArrayList<Integer>> definededges) {
		this.definededges = definededges;
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

	public int getWeight(int idFirst,int idSecond) {
		return getEdges()[idFirst][idSecond];
	}

	
}
