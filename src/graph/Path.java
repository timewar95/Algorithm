package graph;

import java.util.Stack;
import java.util.Vector;

//������ͼ��·��
public class Path {
	private Graph graph;//����������ͨ�����ͼ
	private boolean[] visited;//�ж�����ڵ��Ƿ��ѱ�����
	private int start;
	private int[] form;//��¼��form[i]�Ľڵ㵽i�ڵ�
	public Path(Graph graph,int start){
		this.graph=graph;
		this.start=start;
		visited=new boolean[graph.V()];
		form=new int[graph.V()];
		//��ʼ��ÿ���ڵ���visted,form�е�����
		for(int i=0;i<graph.V();i++){
			visited[i]=false;
			form[i]=-1;
		}
		//�������Ѱ·�㷨
		dfs(start);
	}
	//ͼ��������ȱ���
	private	void dfs(int v){
		//����v��ı��鿴״̬����ͨ����״̬
		visited[v]=true;
		//������v�����ӵ�������
		for(int j:this.graph.adj(v)){
			if(!visited[j]){
				form[j]=v;
				dfs(j);
			}
		}
	}
	//�ж��Ƿ��е�w�ڵ��·��
	public boolean hasPath(int w){
		return visited[w];
	}
	//��ӿ�ʼ�ڵ㵽ָ���ڵ��·����·�������iterator��
	public Vector<Integer> path(int w){
		int p=w;
		Stack<Integer> stack=new Stack<Integer>();
		//��ʼ�ڵ��Ӧform����Ϊ-1
		while(p!=-1){
			stack.push(p);
			p=form[p];
		}
		//��ջ��ȡ������
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
