package util;

import java.util.Random;

public class SortTestHelper{

	/**
	 * @param i �������Ԫ�ظ���
	 * @param left �������Ԫ����Сֵ
	 * @param right �������Ԫ�����ֵ
	 * @return �������ɵ��������
	 */
	public static int[] generateRandomArray(int count,int min,int max){
		int[] arr=new int[count];
		Random random=new Random();
		for(int i=0;i<count;i++){
			//��Ҫ����[4,8]��Χ��Ԫ�أ���������[4,9)
			//max-min+1 
			arr[i]=random.nextInt(max-min+1)+min;
		}
		return arr;
	}
	
	/**
	 * @param i �������Ԫ�ظ���
	 * @param left �������Ԫ����Сֵ
	 * @param right �������Ԫ�����ֵ
	 * @return �������ɵ��������
	 */
	public static Integer[] geRandomIntegerArray(int count,int min,int max){
		Integer[] arr=new Integer[count];
		Random random=new Random();
		for(int i=0;i<count;i++){
			//��Ҫ����[4,8]��Χ��Ԫ�أ���������[4,9)
			//max-min+1 
			arr[i]=random.nextInt(max-min+1)+min;
		}
		return arr;
	}
	
	/**
	 * @param arrlength �����С
	 * @param swapTime ��������
	 * @return ����һ���������������
	 */
	public static int[] generateAlmostOrderArray(int arrlength,int swapTime){
		int[] arr=new int[arrlength];
		//������������
		for(int i=0;i<arrlength;i++){
			arr[i]=i;
		}
		//���������������������Ԫ�ص�λ��
		Random random=new Random();
		int index1,index2;
		for(int i=0;i<swapTime;i++){
			index1 = random.nextInt(arrlength);
			index2 = random.nextInt(arrlength);
			int temp=arr[index1];
			arr[index1]=arr[index2];
			arr[index2]=temp;
		}
		return arr;
	}
	
	/**
	 * @param arr Ҫ��ӡ������
	 */
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(" ");
			//ÿ��ӡ10��Ԫ�ػ�1��
			/*if((i+1)%10==0){
				System.out.println();
			}*/
		}
		System.out.println();
	}
}
