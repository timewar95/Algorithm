package tree.binarysearch;

public class BinarySearchMain {
	public static void main(String[] args) {
		int[] arr=new int[]{1,7,8,11,23,45};
		int index = BinarySearch.binarySearch(arr, 45);
		System.out.println(arr[index]);
	}
}
