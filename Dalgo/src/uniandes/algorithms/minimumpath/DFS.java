package uniandes.algorithms.minimumpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



public class DFS {
	
	private static DirectedGraph graph;
	
	private static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		String filename = args[0];
		String algorithm = null;
		if (args.length > 1) {
			algorithm = args[1];
		}
		try (FileReader reader = new FileReader(filename); BufferedReader in = new BufferedReader(reader)) {
			String line = in.readLine();
			graph= new DirectedGraph(line.split("\t").length);
			for (int i = 0; line != null; i++) {
				try {
					String[] pesos = line.split("\t");
					int j = 0;
					for (String peso : pesos) {
						int weight = Integer.parseInt(peso);
						if(weight>0) {
							weight=1;
						}else {
							weight =0;
						}
						graph.addEdge(i, j, weight);
						j++;
					}
				} catch (Exception e) {
					System.err.println("Can not read number from line " + i + " content: " + line);
					e.printStackTrace();
				}
				line = in.readLine();
				
			}
			long startTime;
			System.out.println("----------------");
			boolean ciclos =  depthFirst(0);
			if (ciclos) {
				System.out.println("El grafo contiene ciclos");
				
			}else {
				String b = "";
				System.out.println("El grafo no contiene ciclos, este es su orden topológico:");
				Iterator<Integer> iterator = answer.iterator();
				while (iterator.hasNext()) {
				
					b = b+"  "+iterator.next();
				}
					System.out.println(b);
			}
			
			System.out.println();
			long endTime;

		}
	}

	

	public static boolean depthFirst(int start) {
		boolean r = false;
		answer = new ArrayList<Integer>(graph.getVertex().size());
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.getVertex().size()];
		Arrays.fill(visited, false);
		stack.push(start);
		visited[start] = true;
		while (stack.size() > 0) {
			int next = stack.pop();
			answer.add(graph.getVertex().get(next));
			for (int i = 0; i < graph.getVertex().size(); i++) {
				if (graph.getEdges()[next][i]==1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}else if(visited[i] && graph.getEdges()[next][i]==1) {
					r=true;
				}
			}
		}
		return r;
	}
	
	
	
}
