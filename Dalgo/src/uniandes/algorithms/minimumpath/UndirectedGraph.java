package uniandes.algorithms.minimumpath;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {
	
	private List<Integer> vertex;
	
	private List<ArrayList<Integer>> edges;
	
	private List<Integer> weights;
	
	public UndirectedGraph() {
		
		this.vertex = new ArrayList<Integer>();
		
		this.edges = new ArrayList<ArrayList<Integer>>();
		
		this.weights = new ArrayList<Integer>();
	}
	
	/**
	 * 
	 * @param idFirst
	 * @param idSecond
	 * @param weight
	 */
	public void addEdges(int idFirst,int idSecond,int weight) {
		if(weight!=-1) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(idFirst);
			path.add(idSecond);
			this.edges.add(path);
			this.weights.add(weight);
			if(!vertex.contains(idFirst)) {
				this.vertex.add(idFirst);
			}
			if(!vertex.contains(idSecond)){
				this.vertex.add(idFirst);
			}
		}else {
			if(!vertex.contains(idFirst)) {
				this.vertex.add(idFirst);
			}
			if(!vertex.contains(idSecond)){
				this.vertex.add(idFirst);
			}
		}
	}
	public void getWeight(int idFirst,int idSecond) {
		int pos = 0;
		boolean found = false;
		for(ArrayList<Integer> path : this.edges) {
			if(path.get(0)==idFirst && path.get(1)==idSecond){
				pos ++;
			}
		}
	}
	

}
