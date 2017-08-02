package sort;

import util.SortTestHelper;

public class SelectionSort {
	
	//禁止实例化选择排序的类
	private SelectionSort() {
	}
	public static void selectionSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			//一次内层循环过后才进行最小元素位置的交换
			int tmep=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=tmep;
		}
	}
	public static void  main(String args[]){
		int[] arr = SortTestHelper.generateRandomArray(100, 0, 100);
		System.out.println("排序前:");
		SortTestHelper.printArray(arr);
		SelectionSort.selectionSort(arr);
		System.out.println("排序后:");
		SortTestHelper.printArray(arr);
	}
}
