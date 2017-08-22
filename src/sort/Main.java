package sort;

import util.SortContext;

public class Main {
	public static void main(String[] args) {
		SortContext context=new SortContext();
		//≤Â»Î≈≈–Ú
		InsertrionSort insertrionSort=new InsertrionSort();
		context.setSortAlgorithm(insertrionSort);
		context.sortPerformanceTest(100000, 0, 100000);
/*		//—°‘Ò≈≈–Ú
		SelectionSort selectionSort=new SelectionSort();
		context.setSortAlgorithm(selectionSort);
		context.sortPerformanceTest(100000, 0, 10);*/
		
		MergeSort mergeSort=new MergeSort();
		context.setSortAlgorithm(mergeSort);
		context.sortPerformanceTest(100000, 0, 100000);
	}
}
