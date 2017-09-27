package sort;

import util.SortContext;

public class Main {
	public static void main(String[] args) {
		SortContext context=new SortContext();
		//≤Â»Î≈≈–Ú
		InsertrionSort insertrionSort=new InsertrionSort();
		context.setSortAlgorithm(insertrionSort);
		context.sortPerformanceTest(1000000, 0, 10);
	/*	//—°‘Ò≈≈–Ú
		SelectionSort selectionSort=new SelectionSort();
		context.setSortAlgorithm(selectionSort);
		context.sortPerformanceTest(1000000, 0, 10);*/
		//πÈ≤¢≈≈–Ú
		MergeSort mergeSort=new MergeSort();
		context.setSortAlgorithm(mergeSort);
		context.sortPerformanceTest(1000000, 0, 10);
	}
}
