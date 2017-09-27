package sort;

import util.SortContext;

public class Main {
	public static void main(String[] args) {
		SortContext context=new SortContext();
		//��������
		InsertrionSort insertrionSort=new InsertrionSort();
		context.setSortAlgorithm(insertrionSort);
		context.sortPerformanceTest(1000000, 0, 10);
	/*	//ѡ������
		SelectionSort selectionSort=new SelectionSort();
		context.setSortAlgorithm(selectionSort);
		context.sortPerformanceTest(1000000, 0, 10);*/
		//�鲢����
		MergeSort mergeSort=new MergeSort();
		context.setSortAlgorithm(mergeSort);
		context.sortPerformanceTest(1000000, 0, 10);
	}
}
