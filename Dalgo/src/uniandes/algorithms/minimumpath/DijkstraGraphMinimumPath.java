package uniandes.algorithms.minimumpath;

import java.util.Arrays;

public class DijkstraGraphMinimumPath implements GraphMinimumPath{
	
	public int[][] minimumpath(DirectedGraph graph){
		int[][] grafo = graph.getEdges();
		int[][] minCost = new int[grafo.length][grafo[0].length];
		for (int i = 0;i<grafo.length;i++) {
			minCost[i] = Dijkstra(grafo,i);
		}
		return minCost;
	}
	
	public int[] Dijkstra(int[][] grafo, int vertice) {
		//Iniciamos el arreglo de respuesta y lo llenamos de los arcos directos
		int[] minCost = new int[grafo.length];
		minCost = grafo[vertice];
		Boolean[] marcados = new Boolean[grafo.length];
		
		//Iniciamos la lista de marcados con false y true en el vertice
		for(int m = 0;m < grafo.length;m++) {
			if (m==vertice) {
				marcados[m]=true;
			}else {
				marcados[m] = false;
			}
		}
		int ver = 0;
		while (Arrays.asList(marcados).contains(false)) {
			int control = 100000000;
			for (int i = 0;i<grafo.length;i++) {
				if (minCost[i]<control && marcados[i] == false && minCost[i] != -1) {
					ver = i;
					control = minCost[i];
				}
			}
			marcados[ver] = true;
			for (int j = 0;j<grafo.length;j++) {
				if (minCost[j] == -1 && grafo[ver][j] != -1) {
					minCost[j] = minCost[ver]+grafo[ver][j];
				}else if (minCost[j]>minCost[ver]+grafo[ver][j] && grafo[ver][j] != -1) {
					minCost[j] = minCost[ver]+grafo[ver][j];
				}
			}
		}
		
		return minCost;
	}

}
