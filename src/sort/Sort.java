package sort;

public abstract class Sort {
	public abstract void sort(int[] arr);
	public abstract void sortPerformanceTest(int arrLength,int min,int max);
	public boolean isOrder(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>arr[i+1]){
				return false;
			}
		}
		return true;
	}
}
