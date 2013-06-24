package edu.ulab.week4;

public class BinaryHeap {
	Comparable<String>[] a;
	
	public void swap(int i,int j){
		Comparable<String> temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void swim(Comparable<String> ele, int index){
		if(index>=1){
		int upIndex=index/2;
		if(a[upIndex].compareTo((String) a[index])<0)
			swap(upIndex,index);
		swim(a[upIndex], upIndex);
	}
}	
	
	public void insert(Comparable<String> item){
		a[a.length]=item;
		swim(a[a.length-1],a.length-1);
	}
	public void deleteMax(){
		
	}

	public static void main(String[] args) {
		System.out.println("Choose an option");
		System.out.println("1. Insert element");
		System.out.println("2. Delete max");
		System.out.println("3. Exit");

	}

}
