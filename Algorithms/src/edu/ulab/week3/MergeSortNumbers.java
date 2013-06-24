package edu.ulab.week3;

public class MergeSortNumbers {
	public static void merge(Integer[] numbers, Integer[] helper, int low,
			int high, int middle) {
		int flag=0;
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
			flag++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	System.out.println(high+1+"   "+flag);
	}

	public static void devide(Integer[] args, Integer[] aux, int lo, int hi) {

		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		devide(args, aux, lo, mid);
		devide(args, aux, (mid + 1), hi);
		//System.out.println(lo + " "+mid+" " + hi);
		merge(args, aux, lo, hi, mid);

	}

	public static void main(String[] args) {
		Integer[] arg = { 1, 7, 4, 0, 6, 2,10,9 };
		devide(arg, new Integer[arg.length], 0, arg.length - 1);
		// for(int i=0;i<arg.length;i++) System.out.println(arg[i]);
		 }
}
