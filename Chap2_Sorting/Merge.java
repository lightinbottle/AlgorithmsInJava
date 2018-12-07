package Chap2_Sorting;

public class Merge {
	
	private static Comparable[] tmp;
	
	//算法时间复杂度 1/2NlgN~NlgN次比较  缺点是需要N额外的空间 top-down mergesort
	public static void sort(Comparable[] a) {
		
		tmp=new Comparable[a.length];
		sort(a,0,a.length-1);
		
	}
	private static void sort(Comparable[] a,int lo, int hi) {
		
		if(lo>=hi)return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	private static void merge(Comparable[] a,int lo, int mid, int hi) {
		//System.out.println(lo+"   "+mid+"   "+hi);
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			tmp[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid)a[k]=tmp[j++];
			else if(j>hi)a[k]=tmp[i++];
			else if(less(tmp[i],tmp[j]))a[k]=tmp[i++];
			else a[k]=tmp[j++];
		}
	}
	
	private static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1]))return false;
		}
		return true;
	}

	private static void show(Comparable[] a) {
		for(Comparable c:a) {
			System.out.print(c+" ");
		}
		System.out.println();
	}
	private static void exch(Object[] a, int i, int min) {
		Object tmp=a[i];
		a[i]=a[min];
		a[min]=tmp;
		return;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)<0;
	}
	
	public static void main(String[] args) {
		Integer[] a=new Integer[] {2,4,4,66,78,0,-1,8,10,99,14,5};
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
