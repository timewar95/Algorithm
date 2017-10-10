package graph;

import java.util.Vector;

//稀疏图-邻接表-每个节点可以不用与所有的其他节点相关联
public class SparseGraph implements Graph{
	private int nodeNum;//节点数
	private int edgeNum;//边数
	private Vector<Integer>[] g;//邻接表
	private boolean directed;
	public SparseGraph(int nodeNum,boolean directed){
		this.nodeNum=nodeNum;
		this.directed=directed;
		//初始化邻接表
		g=(Vector<Integer>[])new Vector[nodeNum];
		for(int i=0;i<nodeNum;i++){
			g[i]=new Vector<Integer>();
		}
	}
	
	/**
	 * @return	返回图的节点数
	 */
	public int V(){return nodeNum;}
	
	/**
	 * @return	返回图的边数
	 */
	public int E(){return edgeNum;}
	
	public void addEdge(int p,int q){
		//p点邻接表中不存在q点,消除平行边
		if(!g[p].contains(q)){
			g[p].add(q);
			//q、p不为同一点，并且图为无向图
			if(p!=q&&!directed){
				//q点邻接表中不存在p点
				if(!g[q].contains(p)){
					g[q].add(p);
				}
			}
		}
	}
	//判断图中是否包含从点v到点w的边
	public boolean hasEdge(int v, int w) {
		if(g[v].contains(w)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void show() {
		for(int i=0;i<nodeNum;i++){
			System.out.print(i+": ");
			for(int j=0;j<g[i].size();j++){
				System.out.print(g[i].get(j)+"\t");
			}
			System.out.println();
		}
	}

	// TODO Auto-generated method stub
	@Override
	public Iterable<Integer> adj(int v) {
		Vector<Integer> vector=new Vector<Integer>(g[v]);
		return vector;
	}
	
	public static void main(String[] args) {
		Graph graph=new SparseGraph(5, false);
		graph.addEdge(0, 4);
		graph.addEdge(0, 3);
		graph.addEdge(3, 2);
		graph.show();
		
		/*Component component=new Component(graph);
		System.out.println("联通分量数量:"+component.count());
		System.out.println(component.isConnect(3, 4));*/
		Path path=new Path(graph, 0);
		path.showPath(2);
	}
	
}
