package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class GraphTest1 {
	
/*




*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] vertexValues = {"A","B","C","D","E","F","G"};
		Graph g = new Graph(vertexValues.length);
		for(String s: vertexValues){
			g.insertVertex(s);
		}
		g.insertEdge(0,1,5);
		g.insertEdge(0,2,7);
		g.insertEdge(0,6,2);
		g.insertEdge(1,3,9);
		g.insertEdge(1,6,3);
		g.insertEdge(2,4,8);
		g.insertEdge(3,5,4);
		g.insertEdge(4,5,5);
		g.insertEdge(4,6,4);
		g.insertEdge(5,6,6);
		
		g.showGraph();

		System.out.println("-----------");

		g.floyd();
	}
	
	

}

class Graph{
	
	private ArrayList<String> vertexList;
	private ArrayList<int[]> edgeSet;
	private int[][] edges;
	private int numOfEdges;
	
	public Graph(int n){
		edges = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(edges[i], Integer.MAX_VALUE);
		}
		vertexList = new ArrayList<>(n);
		edgeSet = new ArrayList<>();
		numOfEdges = 0;
	}
	
	public void insertVertex(String vertex){
		this.vertexList.add(vertex);
	}
	
	public void insertEdge(int v1, int v2, int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		int e[] = new int[3];
		e[0] = v1;
		e[1] = v2;
		e[2] = weight;
		edgeSet.add(e);
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
	
	public int getIndexByValue(String str){
		for(int i = 0; i < this.vertexList.size(); i++){
			if(this.vertexList.get(i).equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	public int getWeight(int v1, int v2){
		return edges[v1][v2];
	}
	
	public void showGraph(){
		for(int i = 0; i < edges.length; i++){
			System.out.println(Arrays.toString(edges[i]));
		}
	}
	
	public <T> void showGraph(T arr[][]){
		for(int i = 0; i < edges.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public void showGraph(int arr[][]){
		for(int i = 0; i < edges.length; i++){
			System.out.println(Arrays.toString(arr[i]));
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
	
	public void prim(int n){
		int vertexs[] = new int[this.vertexList.size()];
		int paths[] = new int[this.vertexList.size()];
		Arrays.fill(paths, Integer.MAX_VALUE);
		paths[n] = 0;
		vertexs[n] = n;
		ArrayList<String> list = new ArrayList<>();
		list.add(this.getValueByIndex(n));
		while(list.size() < vertexs.length){
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < list.size(); i++){
				int v = this.getIndexByValue(list.get(i));
				for(int j = 0; j < vertexs.length; j++){
					if(!list.contains(this.getValueByIndex(j)) && edges[v][j] != Integer.MAX_VALUE){
						int t1 = paths[v] + edges[v][j];
						if(t1 < paths[j]){
							paths[j] = t1;
							vertexs[j] = v;
						}
						if(edges[v][j] < min){
							min = edges[v][j];
							n = j;
							vertexs[j] = v;
						}
					}
				}
			}
			list.add(this.getValueByIndex(n));	
		}
		System.out.println(Arrays.toString(paths));
		System.out.println(Arrays.toString(vertexs));
	}
	
	
	public void krus(){
		Collections.sort(this.edgeSet, (e1, e2)->{
			return Integer.compare(e1[2], e2[2]);
		});
		ArrayList<int[]> lists = new ArrayList<>();
		ArrayList<ArrayList<Integer>> conn = new ArrayList<>();
		for(int i = 0; i < this.vertexList.size(); i++){
			ArrayList<Integer> li = new ArrayList<>();
			li.add(this.getIndexByValue(this.vertexList.get(i)));
			conn.add(li);
		}
		while(!this.edgeSet.isEmpty()&& conn.size() > 1){
			int[] temp = this.edgeSet.remove(0);
			int a1 = 0;
			int a2 = 0;
			for(int i = 0; i < conn.size(); i++){
				if(conn.get(i).contains(temp[0])){
					a1 = i;
				}
				if(conn.get(i).contains(temp[1])){
					a2 = i;
				}
			}
			if(a1 != a2){
				lists.add(temp);
				conn.get(a1).addAll(conn.get(a2));
				conn.remove(a2);
			}
		}
		lists.forEach((e)->{
			System.out.println(Arrays.toString(e));
		});
	}
	
	public void djistra(int n){
		int[] pre = new int[this.vertexList.size()];
		Arrays.fill(pre, -1);
		int[] path = new int[pre.length];
		Arrays.fill(path, Integer.MAX_VALUE);
		ArrayList<Integer> list = new ArrayList<>();
		pre[n] = n;
		path[n] = 0;
		while(list.size() != pre.length){
			list.add(n);
			for(int i = 0; i < pre.length; i++){
				if(!list.contains(i)){
					if(this.edges[n][i] != Integer.MAX_VALUE){
						int tempPath = path[n] + edges[n][i];
						if(tempPath < path[i]){
							path[i] = tempPath;
							pre[i] = n;
						}
					}
				}
			}
			int min = Integer.MAX_VALUE, loc = -1;
			for(int j = 0; j < path.length; j++){
				if(!list.contains(j)){
					if(path[j] < min){
						min = path[j];
						loc = j;
					}
				}
			}
			if(loc == -1){
				break;
			}else{
				n = loc;
			}
			System.out.println(Arrays.toString(pre));
			System.out.println(Arrays.toString(path));
			System.out.println("------");
		}
		System.out.println(Arrays.toString(pre));
		System.out.println(Arrays.toString(path));
	}
	
	
	public void floyd(){
		System.out.println("floyd");
		int[][] v = new int[this.vertexList.size()][this.vertexList.size()];
		String[][] s = new String[this.vertexList.size()][this.vertexList.size()];
		for(int i = 0; i < this.vertexList.size(); i++){
			for(int j = 0; j < this.vertexList.size(); j++){
				v[i][j] = this.edges[i][j];
				s[i][j] = this.getValueByIndex(i);
			}
			v[i][i] = 0;
		}
		System.out.println("---------------");
		this.showGraph(s);
		System.out.println("---------------");
		this.showGraph(v);
		System.out.println("---------------");
		for(int i = 0; i < v.length; i++){
			
			for(int j = 0; j < v.length; j++){
				
				for(int k = 0; k < v.length; k++){
					int t = Integer.MAX_VALUE;
					if(v[j][i] != Integer.MAX_VALUE && v[i][k] != Integer.MAX_VALUE){
						t = v[j][i] + v[i][k];
					}
					if(v[j][k] > t){
						v[j][k] = t;
						s[j][k] = this.getValueByIndex(i);
					}
				}
			}
			System.out.println("round : " + i);
			this.showGraph(s);
			System.out.println("---------------");
			this.showGraph(v);
			System.out.println("---------------");
		}
		
		System.out.println("---------------");
		this.showGraph(s);
		System.out.println("---------------");
		this.showGraph(v);
		System.out.println("---------------");
		
	}
	
	
	
	
}