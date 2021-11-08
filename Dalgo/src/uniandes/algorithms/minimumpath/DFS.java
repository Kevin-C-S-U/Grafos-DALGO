package uniandes.algorithms.minimumpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) throws Exception {
		String filename = args[0];
		String algorithm = null;
		if (args.length > 1) {
			algorithm = args[1];
		}
		try (FileReader reader = new FileReader(filename); BufferedReader in = new BufferedReader(reader)) {
			String line = in.readLine();
			DirectedGraph graph = new DirectedGraph(line.split("\t").length);
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
			Boolean list = depthFirst(0,graph);
			System.out.print(list);
			long endTime;

		}
	}

	public static Boolean depthFirst (int start,DirectedGraph graph) {
		boolean r = true;
		List<Integer> answer = new ArrayList<Integer>(graph.getVertex().size());
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visited = new boolean [graph.getVertex().size()];
		Arrays.fill(visited, false);
		stack.push(start);
		visited[start] = true;
		while(stack.size()>0) {
			int next = stack.pop();
			answer.add(graph.getVertex().get(next));
			for(int i=0;i<graph.getVertex().size();i++) {
				if(graph.getEdges()[next][i]==1 && visited[i]) {
					r=false;
				}
				if(graph.getEdges()[next][i]==1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
				
			}
		}
		return r;
	}
}
