package graph;
//������ͼ��ͨ��������
public class Component {
	private Graph graph;//����������ͨ�����ͼ
	private boolean[] visited;//�ж�����ڵ��Ƿ��ѱ�����
	private int[] id;//��¼ÿ���ڵ����ͨ������id
	private int ccount=0;//��ͨ�����ĸ���
	public Component(Graph graph){
		this.graph=graph;
		visited=new boolean[graph.V()];
		id=new int[graph.V()];
		for(int i=0;i<graph.V();i++){
			visited[i]=false;
			//��ʼ���нڵ����ͨ������Ϊ-1
			id[i]=-1;
		}
		//��������δ���ʹ��ĵ㣬��ʼ����ͨ������ֵ
		for(int i=0;i<graph.V();i++){
			if(!visited[i]){
				dfs(i);
				//������һ�κ���ͨ����+1
				ccount++;
			}
		}
	}
	//ͼ��������ȱ���
	private	void dfs(int v){
		//����v��ı��鿴״̬����ͨ����״̬
		visited[v]=true;
		id[v]=ccount;
		System.out.println(v);
		//������v�����ӵ�������
		for(int j:this.graph.adj(v)){
			if(!visited[j]){
				dfs(j);
			}
		}
	}
	//������ͨ��������
	public int count(){return ccount;}
	
	public boolean isConnect(int p,int q){
		return id[p]==id[q];
	}
}
