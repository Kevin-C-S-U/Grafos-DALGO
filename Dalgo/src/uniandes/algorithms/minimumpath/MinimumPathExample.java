package uniandes.algorithms.minimumpath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MinimumPathExample {

	public static void main(String[] args) throws Exception {
		String filename = args[0];
		String algorithm = null;
		if(args.length>1) {
			algorithm = args[1];
		}
		try (FileReader reader = new FileReader(filename);
			BufferedReader in = new BufferedReader(reader)) { 
			String line = in.readLine();
			DirectedGraph graph = new DirectedGraph(line.split("\t").length);
			for (int i=0;line != null;i++) {
				try {
					String[] pesos = line.split("\t");
					int j=0;
					for (String peso:pesos) {
						int weight = Integer.parseInt(peso);
						graph.addEdge(i, j, weight);
						j ++;
					}
				} catch (Exception e) {
					System.err.println("Can not read number from line "+i+" content: "+line);
					e.printStackTrace();
				}
				line = in.readLine();
			}
			String a="";
			for(int i=0;i<graph.getEdges().length;i++) {
				for (int j = 0; j<graph.getEdges()[0].length;j++) {
					a = a+"  " + graph.getEdges()[i][j];
				}
				System.out.println(a);
				a="";
			}
		}
	}
}
