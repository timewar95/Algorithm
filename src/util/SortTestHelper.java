package util;

import java.util.Random;

public class SortTestHelper{
	/**
	 * @param i 随机数组元素个数
	 * @param left 随机数组元素最小值
	 * @param right 随机数组元素最大值
	 * @return 返回生成的随机数组
	 */
	public static int[] generateRandomArray(int count,int min,int max){
		int[] arr=new int[count];
		Random random=new Random();
		for(int i=0;i<count;i++){
			//若要生成[4,8]范围的元素，则需区间[4,9)
			//max-min+1 
			arr[i]=random.nextInt(max-min+1)+min;
		}
		return arr;
	}
	
	/**
	 * @param arr 要打印的数组
	 */
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(" ");
			//每打印10个元素换1行
			/*if((i+1)%10==0){
				System.out.println();
			}*/
		}
		System.out.println();
	}
}
