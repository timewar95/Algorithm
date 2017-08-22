package sort;

import util.SortContext;

public class Main {
	public static void main(String[] args) {
		SortContext context=new SortContext();
		//��������
		InsertrionSort insertrionSort=new InsertrionSort();
		context.setSortAlgorithm(insertrionSort);
		context.sortPerformanceTest(100000, 0, 100000);
/*		//ѡ������
		SelectionSort selectionSort=new SelectionSort();
		context.setSortAlgorithm(selectionSort);
		context.sortPerformanceTest(100000, 0, 10);*/
		
		MergeSort mergeSort=new MergeSort();
		context.setSortAlgorithm(mergeSort);
		context.sortPerformanceTest(100000, 0, 100000);
	}
}
