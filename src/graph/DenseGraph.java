package graph;

import java.util.Vector;

//����ͼ-�ڽӾ���-����ÿ���㶼������������������˷ѹ����ڴ�ռ�
public class DenseGraph implements Graph{
	private int nodeNum;//�ڵ���
	private int edgeNum; //����
	private boolean directed;//�Ƿ�Ϊ����ͼ��trueΪ����ͼ
	private boolean[][] g;//�ڽӾ���
	public DenseGraph(int nodeNum,boolean directed){
		this.nodeNum=nodeNum;
		this.edgeNum=0;//��ʼ���κα�
		this.directed=directed;
		g=new boolean[nodeNum][nodeNum];//Ϊ�ڽӾ��������ڴ�ռ�
	}
	/**
	 * @return	���ؽڵ����
	 */
	public int V(){return nodeNum;}
	/**
	 * @return	�������ӱߵĸ���
	 */
	public int E(){return edgeNum;}
	//��������
	public void addEdge(int p,int q){
		if(hasEdge(p,q)){
			return;
		}
		g[p][q]=true;
		//ͼΪ����ͼ
		if(!directed){
			g[q][p]=true;
		}
		//���ӱ���+1
		edgeNum++;
	}
	/**
	 * @param p	���ӵ�p
	 * @param q	���ӵ�q
	 * @return	�ж�������Ƿ���������
	 */
	public boolean hasEdge(int p,int q){
		return g[p][q];
	}
	// TODO Auto-generated method stub
	
	/**
	 * ��ӡͼ
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
			//��ӡ��һ�λ���
			System.out.println();
		}
	}
	/**
	 * @param v
	 * @return	������v���������ӵĵ�
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
