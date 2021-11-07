package uniandes.algorithms.minimumpath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Scanner;


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
			long startTime;
			long endTime;
			if(algorithm==null) {
				System.out.println("Ingrese por parametro un algoritmo");
			}else {
				String classname = GraphMinimumPath.class.getPackage().getName()+"."+algorithm+"GraphMinimumPath";
				GraphMinimumPath minimumAlgorithm;
				try {
					Class<?> algorithmClass = Class.forName(classname);
					Constructor<?> emptyConstructor = algorithmClass.getConstructor();
					minimumAlgorithm = (GraphMinimumPath)emptyConstructor.newInstance();
				} catch (Exception e) {
					throw new Exception("Invalid algorithm "+algorithm,e);
				}
				Scanner sc= new Scanner(System.in);    
				startTime = System.currentTimeMillis();
				int[][] minimumpath = minimumAlgorithm.minimumpath(graph);
				endTime = System.currentTimeMillis();
				String b = "";
				System.out.println("Matriz de costos minimos, el número de las columnas y filas representa el vertice");
				for (int[] i:minimumpath) {
					for(int j:i) {
						b = b+"  "+j;
					}
					System.out.println(b);
					b="";
				}
				System.out.println("Matriz of minimum paths. Total time(milliseconds): "+(endTime-startTime));
			}
		}
	}
}
