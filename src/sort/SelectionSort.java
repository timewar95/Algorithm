package sort;

import util.SortTestHelper;

public class SelectionSort extends Sort{
	
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length-1;i++){
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			//һ���ڲ�ѭ���������ٽ�����СԪ�ص�λ��
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	@Override
	public void sortPerformanceTest(int arrLength, int min, int max) {
		// TODO Auto-generated method stub
		int[] randomArray = SortTestHelper.generateRandomArray(arrLength,min, max);
		long startTime = System.currentTimeMillis();
		sort(randomArray);
		long endTime=System.currentTimeMillis();
		System.out.println("Ԫ���Ƿ�����:"+isOrder(randomArray));
		System.out.println("ѡ������"+arrLength+"��Ԫ�ػ���"+(endTime-startTime)+"ms");
	}
}
