package util;

import sort.Sort;

public class SortContext{
	private Sort sortAlgorithm;

	public Sort getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(Sort sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		sortAlgorithm.sort(arr);
	}

	public void sortPerformanceTest(int arrLength, int min, int max) {
		// TODO Auto-generated method stub
		sortAlgorithm.sortPerformanceTest(arrLength, min, max);
	}
	
}
