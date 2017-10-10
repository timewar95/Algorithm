package graph;
//帮助求图连通分量的类
public class Component {
	private Graph graph;//传入来求连通分类的图
	private boolean[] visited;//判断这个节点是否已被遍历
	private int[] id;//记录每个节点的连通分量的id
	private int ccount=0;//连通分量的个数
	public Component(Graph graph){
		this.graph=graph;
		visited=new boolean[graph.V()];
		id=new int[graph.V()];
		for(int i=0;i<graph.V();i++){
			visited[i]=false;
			//开始所有节点的连通分量均为-1
			id[i]=-1;
		}
		//遍历所有未访问过的点，初始化连通分量的值
		for(int i=0;i<graph.V();i++){
			if(!visited[i]){
				dfs(i);
				//遍历完一次后，连通分量+1
				ccount++;
			}
		}
	}
	//图的深度优先遍历
	private	void dfs(int v){
		//设置v点的被查看状态，连通分量状态
		visited[v]=true;
		id[v]=ccount;
		System.out.println(v);
		//遍历与v点连接的其他点
		for(int j:this.graph.adj(v)){
			if(!visited[j]){
				dfs(j);
			}
		}
	}
	//返回连通分量个数
	public int count(){return ccount;}
	
	public boolean isConnect(int p,int q){
		return id[p]==id[q];
	}
}
