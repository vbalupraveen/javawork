package edu.ulab.week3;

public class QuickSortNumbers {
	Integer[] a;

	public QuickSortNumbers(Integer[] a) {
		this.a = a;
	}

	public void swap(Integer[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void partition(int left, int right) {
		int k = 0;
		int pivot = a[(int) ((Math.random() % a.length)+left)];
		System.out.println("\nPivot Number=" + pivot);
		int i = left;
		int j = right;
		if(i==j)
			swap(a, i, j);
		while (i < j) {
			while (a[i] < pivot) {
				System.out.print(a[i]);
				i++;
			}
			while (a[j] > pivot) {
				System.out.print(a[j]);
				j--;
			}
			if(i<j){
				System.out.println("\nswap("+a[i]+","+a[j]+")");
				swap(a, i, j);
			}
		}
		// Recursion
		if (left < j){
			System.out.println("\npartition("+left+","+ (j-1)+")");
			partition(left, j-1);
		}
		if (i < right){
			System.out.println("\npartition("+(i+1)+","+right+")");
			partition(i+1, right);
		}
	}

	public static void main(String[] args) {
		Integer[] b = { 2, 5, 6, 4, 8, 1, 3, 7 };
		QuickSortNumbers qsn = new QuickSortNumbers(b);
		qsn.partition(0, qsn.a.length - 1);
		System.out.println("---------------------------------------------");
		for (Integer i=0;i<qsn.a.length;i++) {
			System.out.print(qsn.a[i]+"\t");
		}
	}

}
