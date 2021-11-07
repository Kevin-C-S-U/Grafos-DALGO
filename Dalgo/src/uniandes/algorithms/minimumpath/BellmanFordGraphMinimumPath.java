package uniandes.algorithms.minimumpath;

import java.util.ArrayList;

public class BellmanFordGraphMinimumPath implements GraphMinimumPath{

	@Override
	public ArrayList<Integer> minimumpath(DirectedGraph graph, int idFirst) {
		ArrayList<Integer> df = new ArrayList<>();
		for(int i:graph.getVertex()) {
			df.add(123456);
		}
		df.set(idFirst, 0);
		for (int i = 0; i<graph.getVertex().size();i ++) {
			for(ArrayList<Integer> j:graph.getDefinededges()) {
				df.set(j.get(1), min(df.get(j.get(1)),df.get(j.get(0))+graph.getWeight(j.get(0), j.get(1))));
			}
		}
		return df;
	}

	private int min(int first,int second) {
		if(first<= second) {
			return first;
		}else {
			return second;
		}
	}
}
