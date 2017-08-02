package sort;

import util.SortTestHelper;

public class SelectionSort {
	
	//��ֹʵ����ѡ���������
	private SelectionSort() {
	}
	public static void selectionSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			//һ���ڲ�ѭ������Ž�����СԪ��λ�õĽ���
			int tmep=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=tmep;
		}
	}
	public static void  main(String args[]){
		int[] arr = SortTestHelper.generateRandomArray(100, 0, 100);
		System.out.println("����ǰ:");
		SortTestHelper.printArray(arr);
		SelectionSort.selectionSort(arr);
		System.out.println("�����:");
		SortTestHelper.printArray(arr);
	}
}
