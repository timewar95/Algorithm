package sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

import util.SortTestHelper;

public class MergeSort extends Sort{
	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		mergeSort(arr,0,arr.length-1);
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
		System.out.println("归并排序"+arrLength+"个元素花费"+(endTime-startTime)+"ms");
	}
	private void mergeSort(int[] arr,int left,int right){
		if(left>=right)
			return;
		int mid=(left+right)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		merge(arr,left,mid,right);
	}
	// TODO Auto-generated method stub
	private void merge(int[] arr, int left, int mid, int right) {
		//复制一个辅助排序数组,因为java方法都是包头不包尾的,所有right+1
		int[] aux=Arrays.copyOfRange(arr, left, right+1);
		//i记录左半部分元素的起始位置,j记录右半部分元素的起始位置
		int i=left,j=mid+1;
		for(int k=left;k<=right;k++){
			if(i>mid){//左半部分元素已全部排完序,只需排右半部分的元素,j-left代表辅助元素的偏移量
				arr[k]=aux[j-left];
				j++;
			}
			else if(j>right){//右半部分的元素全部拍完序,只需排左半部分的元素
				arr[k]=aux[i-left];
				i++;
			}
			else if(aux[i-left]<aux[j-left]){
				arr[k]=aux[i-left];
				i++;
			}
			else{
				arr[k]=aux[j-left];
				j++;
			}
		}
	};
	
	public static void main(String[] args) {
		double   f   =   111231.5585;  
		BigDecimal   b   =   new   BigDecimal(f);  
		long f1 = Math.round(f);
		System.out.println(f1);
	}
}
