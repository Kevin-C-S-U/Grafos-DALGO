package uniandes.algorithms.minimumpath;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BFS {

	private static DirectedGraph grafo;
	
	public static List<List<Integer>> breadthFirstCompleto() {
		List<List<Integer>> connectedComponents = new ArrayList<List<Integer>>();
		List<Integer> revisados = new ArrayList<Integer>();
		for (Integer i = 0; i<grafo.getVertex().size();i++) {
			if (!revisados.contains(i)) {
				List<Integer> sol = breadthFirst(i);
				connectedComponents.add(sol);
				Iterator iterator = sol.iterator();
				while (iterator.hasNext())
					revisados.add((Integer) iterator.next());
			}
		}
		return connectedComponents;
		
	}
	
	public static List<Integer> breadthFirst (int start) {
		List<Integer> answer = new ArrayList<Integer>(grafo.getVertex().size());
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean [] visited = new boolean [grafo.getVertex().size()];
		Arrays.fill(visited, false);
		queue.add(start);
		visited[start] = true;
		while(queue.size()>0) {
			int next = queue.remove();
			answer.add(grafo.getVertex().get(next));
			for(int i=0;i<grafo.getVertex().size();i++) {
				if(grafo.getEdges()[next][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		
		try (FileReader reader = new FileReader(filename);
			BufferedReader in = new BufferedReader(reader)) { 
			String line = in.readLine();
			grafo = new DirectedGraph(line.split("\t").length);
			for (int i=0;line != null;i++) {
				try {
					String[] pesos = line.split("\t");
					int j=0;
					for (String peso:pesos) {
						int weight = Integer.parseInt(peso);
						grafo.addEdge(i, j, weight);
						j ++;
					}
				} catch (Exception e) {
					System.err.println("Can not read number from line "+i+" content: "+line);
					e.printStackTrace();
				}
				line = in.readLine();
			}
			long startTime;
			long endTime;
			startTime = System.currentTimeMillis();
			List<List<Integer>> solution = breadthFirstCompleto();
			endTime = System.currentTimeMillis();
			
			System.out.println("Aquellos conjuntos que son iguales pero en orden invertido son en realidad los mismos");
			Iterator<List<Integer>> iterator = solution.iterator();
			while (iterator.hasNext()) {
				Iterator iterator2 = iterator.next().iterator();
				String b = "";
				while (iterator2.hasNext()) {
					b = b+"  "+iterator2.next();
			}
				System.out.println(b);
			}
			System.out.println("Strongly connected elements. Total time(milliseconds): "+(endTime-startTime));
}}}
