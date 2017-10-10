package graph;

import java.util.Vector;

//ϡ��ͼ-�ڽӱ�-ÿ���ڵ���Բ��������е������ڵ������
public class SparseGraph implements Graph{
	private int nodeNum;//�ڵ���
	private int edgeNum;//����
	private Vector<Integer>[] g;//�ڽӱ�
	private boolean directed;
	public SparseGraph(int nodeNum,boolean directed){
		this.nodeNum=nodeNum;
		this.directed=directed;
		//��ʼ���ڽӱ�
		g=(Vector<Integer>[])new Vector[nodeNum];
		for(int i=0;i<nodeNum;i++){
			g[i]=new Vector<Integer>();
		}
	}
	
	/**
	 * @return	����ͼ�Ľڵ���
	 */
	public int V(){return nodeNum;}
	
	/**
	 * @return	����ͼ�ı���
	 */
	public int E(){return edgeNum;}
	
	public void addEdge(int p,int q){
		//p���ڽӱ��в�����q��,����ƽ�б�
		if(!g[p].contains(q)){
			g[p].add(q);
			//q��p��Ϊͬһ�㣬����ͼΪ����ͼ
			if(p!=q&&!directed){
				//q���ڽӱ��в�����p��
				if(!g[q].contains(p)){
					g[q].add(p);
				}
			}
		}
	}
	//�ж�ͼ���Ƿ�����ӵ�v����w�ı�
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
		System.out.println("��ͨ��������:"+component.count());
		System.out.println(component.isConnect(3, 4));*/
		Path path=new Path(graph, 0);
		path.showPath(2);
	}
	
}
