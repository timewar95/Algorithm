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
		System.out.println("Ԫ���Ƿ�����:"+this.isOrder(randomArray));
		System.out.println("�鲢����"+arrLength+"��Ԫ�ػ���"+(endTime-startTime)+"ms");
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
		//����һ��������������,��Ϊjava�������ǰ�ͷ����β��,����right+1
		int[] aux=Arrays.copyOfRange(arr, left, right+1);
		//i��¼��벿��Ԫ�ص���ʼλ��,j��¼�Ұ벿��Ԫ�ص���ʼλ��
		int i=left,j=mid+1;
		for(int k=left;k<=right;k++){
			if(i>mid){//��벿��Ԫ����ȫ��������,ֻ�����Ұ벿�ֵ�Ԫ��,j-left������Ԫ�ص�ƫ����
				arr[k]=aux[j-left];
				j++;
			}
			else if(j>right){//�Ұ벿�ֵ�Ԫ��ȫ��������,ֻ������벿�ֵ�Ԫ��
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
