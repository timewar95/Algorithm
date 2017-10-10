package graph;

import java.util.Stack;
import java.util.Vector;

//帮助求图的路径
public class Path {
	private Graph graph;//传入来求连通分类的图
	private boolean[] visited;//判断这个节点是否已被遍历
	private int start;
	private int[] form;//记录从form[i]的节点到i节点
	public Path(Graph graph,int start){
		this.graph=graph;
		this.start=start;
		visited=new boolean[graph.V()];
		form=new int[graph.V()];
		//初始化每个节点在visted,form中的数据
		for(int i=0;i<graph.V();i++){
			visited[i]=false;
			form[i]=-1;
		}
		//深度优先寻路算法
		dfs(start);
	}
	//图的深度优先遍历
	private	void dfs(int v){
		//设置v点的被查看状态，连通分量状态
		visited[v]=true;
		//遍历与v点连接的其他点
		for(int j:this.graph.adj(v)){
			if(!visited[j]){
				form[j]=v;
				dfs(j);
			}
		}
	}
	//判断是否有到w节点的路径
	public boolean hasPath(int w){
		return visited[w];
	}
	//求从开始节点到指定节点的路径，路径存放在iterator中
	public Vector<Integer> path(int w){
		int p=w;
		Stack<Integer> stack=new Stack<Integer>();
		//初始节点对应form数据为-1
		while(p!=-1){
			stack.push(p);
			p=form[p];
		}
		//从栈中取出数据
		Vector<Integer> vector=new Vector<Integer>();
		while(!stack.isEmpty()){
			vector.add(stack.pop());
		}
		return vector;
	}
	public void showPath(int w){
		Vector<Integer> path = path(w);
		for (int i=0;i<path.size();i++){
			if(i!=path.size()-1){
				System.out.print(path.get(i)+"-->");
			}else{
				System.out.print(path.get(i));
			}
		}
	}
}
