package uniandes.algorithms.minimumpath;

public class FloydWarshallGraphMinimumPath implements GraphMinimumPath {

	public int[][] minimumpath(DirectedGraph graph) {
		int n = graph.getVertex().size();
		int [][] m = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j = 0; j<n;j++) {
				if(graph.getWeight(i,j)==-1) {
					m[i][j]=15000;
				}else {
					m[i][j]=graph.getWeight(i,j);
				}
			}
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++){
					m[i][j]=min(m[i][j], m[i][k]+m[k][j]);
				}
			}
		}
		return m;
	}

	private int min(int first, int second) {
		if (first <= second) {
			return first;
		} else {
			return second;
		}
	}

}
