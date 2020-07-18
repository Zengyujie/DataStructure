package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphTest1 {
	
/*




*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] vertexValues = {"1","2","3","4","5","6","7","8"};
		Graph g = new Graph(vertexValues.length);
		for(String s: vertexValues){
			g.insertVertex(s);
		}
		g.insertEdge(0,1,1);
		g.insertEdge(0,2,1);
		g.insertEdge(1,3,1);
		g.insertEdge(1,4,1);
		g.insertEdge(2,5,1);
		g.insertEdge(2,6,1);
		g.insertEdge(3,7,1);
		g.insertEdge(4,7,1);
		g.showGraph();
		g.DFS(0);
		System.out.println("-----------");
		g.BFS(0);
		
	}
	
	

}

class Graph{
	
	private ArrayList<String> vertexList;
	private int[][] edges;
	private int numOfEdges;
	
	public Graph(int n){
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
	}
	
	public void insertVertex(String vertex){
		this.vertexList.add(vertex);
	}
	
	public void insertEdge(int v1, int v2, int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	public int getNumberOfVertex(){
		return this.vertexList.size();
	}
	
	public int getNumberOfEdges(){
		return this.numOfEdges;
	}
	
	public String getValueByIndex(int i){
		return this.vertexList.get(i);
	}
	
	public int getWeight(int v1, int v2){
		return edges[v1][v2];
	}
	
	public void showGraph(){
		for(int i = 0; i < edges.length; i++){
			System.out.println(Arrays.toString(edges[i]));
		}
	}
	
	public void DFS(int n){
		boolean flag[] = new boolean[edges.length];
		Arrays.fill(flag, true);
		System.out.println(this.getValueByIndex(n));
		flag[n] = false;
		dfsloop(flag, n);
	}
	
	public void dfsloop(boolean[] flag, int n){
		for(int i = 0; i < edges.length; i++){
			if(edges[n][i] == 1 && flag[i]){
				System.out.println(this.getValueByIndex(i));
				flag[i] = false;
				dfsloop(flag, i);
			}
		}
	}
	
	public void BFS(int n){
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		boolean flag[] = new boolean[edges.length];
		Arrays.fill(flag, true);
		System.out.println(this.getValueByIndex(n));
		flag[n] = false;
		queue.offerLast(n);
		while(!queue.isEmpty()){
			int temp = queue.poll();
			for(int i = 0; i < edges.length; i++){
				if(edges[temp][i] == 1 && flag[i]){
					System.out.println(this.getValueByIndex(i));
					flag[i] = false;
					queue.offerLast(i);
				}
			}
		}
	}
	
}