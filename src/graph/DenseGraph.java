package graph;

import java.util.Vector;

//稠密图-邻接矩阵-尽量每个点都与其他点关联，避免浪费过多内存空间
public class DenseGraph implements Graph{
	private int nodeNum;//节点数
	private int edgeNum; //边数
	private boolean directed;//是否为有向图，true为有向图
	private boolean[][] g;//邻接矩阵
	public DenseGraph(int nodeNum,boolean directed){
		this.nodeNum=nodeNum;
		this.edgeNum=0;//初始无任何边
		this.directed=directed;
		g=new boolean[nodeNum][nodeNum];//为邻接矩阵申请内存空间
	}
	/**
	 * @return	返回节点个数
	 */
	public int V(){return nodeNum;}
	/**
	 * @return	返回连接边的个数
	 */
	public int E(){return edgeNum;}
	//连接两点
	public void addEdge(int p,int q){
		if(hasEdge(p,q)){
			return;
		}
		g[p][q]=true;
		//图为无向图
		if(!directed){
			g[q][p]=true;
		}
		//连接边数+1
		edgeNum++;
	}
	/**
	 * @param p	连接点p
	 * @param q	连接点q
	 * @return	判断两点间是否已有连线
	 */
	public boolean hasEdge(int p,int q){
		return g[p][q];
	}
	// TODO Auto-generated method stub
	
	/**
	 * 打印图
	 */
	@Override
	public void show() {
		for(int i=0;i<nodeNum;i++){
			for(int j=0;j<nodeNum;j++){
				if(g[i][j]){
					System.out.print("1\t");
				}else{
					System.out.print("0\t");
				}
			}
			//打印完一次换行
			System.out.println();
		}
	}
	/**
	 * @param v
	 * @return	返回与v顶点相连接的点
	 */
	@Override
	public Iterable<Integer> adj(int v) {
		// TODO Auto-generated method stub
		Vector<Integer> adjV=new Vector<Integer>();
		for(int i=0;i<nodeNum;i++){
			if(g[v][i]){
				adjV.add(i);
			}
		}
		return adjV;
	}
	
	public static void main(String[] args) {
		Graph graph=new DenseGraph(5, false);
		graph.addEdge(0, 4);
		graph.addEdge(0, 3);
		graph.show();
	}
}
