package edu.ulab.week3;

public class MergeSortString {
	public static void merge(String[] numbers, String[] helper, int low,
			int high, int middle) {
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
			if (helper[i].compareTo(helper[j]) <= 0) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}

	public static void devide(String[] args, String[] aux, int lo, int hi) {

		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		devide(args, aux, lo, mid);
		devide(args, aux, (mid + 1), hi);
		merge(args, aux, lo, hi, mid);

	}

	public static void buttomUp(String[] args, String[] aux) {
		int hi;
		
		for (int ii = 1; ii < args.length; ii = 2 * ii) {
			for (int jj = 0; jj < (args.length-2*ii); jj += 2 * ii) {
				hi=jj+2*ii-1;
				merge(args, aux, jj, jj+2*ii-1, (jj + (hi - jj) / 2));	
			}
		}
	}

	public static void sort(String[] a) {
		int N = a.length;
		String[] aux = new String[N];
		for (int sz = 1; sz < N; sz = sz + sz)
			for (int lo = 0; lo < N - sz; lo += sz + sz)
				merge(a, aux, lo, lo + sz - 1,
						Math.min(lo + sz + sz - 1, N - 1));
	}

	public static void main(String[] args) {
		String[] arg = { "d", "h", "a", "k", "e", "n", "z", "v" };
		//devide(arg, new String[arg.length], 0, arg.length - 1);
		buttomUp(arg, new String[arg.length]);
		for (int i = 0; i < arg.length; i++)
			System.out.println(arg[i]);
	}
}
