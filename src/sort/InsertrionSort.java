package sort;

import util.SortTestHelper;

public class InsertrionSort extends Sort{
	
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=1;i<arr.length;i++){
			int j=i;
			int e=arr[i];
			for(;j>0&&arr[j-1]>e;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[j]=e;
		}
	}
	@Override
	public void sortPerformanceTest(int arrLength, int min, int max) {
		// TODO Auto-generated method stub
		
		int[] randomArray = SortTestHelper.generateRandomArray(arrLength,min, max);
		//int[] randomArray= SortTestHelper.generateAlmostOrderArray(arrLength, 10);
		long startTime = System.currentTimeMillis();
		sort(randomArray);
		long endTime=System.currentTimeMillis();
		System.out.println("元素是否有序:"+this.isOrder(randomArray));
		System.out.println("插入排序"+arrLength+"个元素花费"+(endTime-startTime)+"ms");
	}
}
