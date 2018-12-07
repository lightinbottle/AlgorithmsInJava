package Chap2_Sorting;

public class Buddle {
    //算法复杂度 N^2/2
	public static void sort(Comparable[] a) {
		for(int i=a.length-1;i>0;i--)
			for(int j=1;j<=i;j++) {
				if(less(a[j],a[j-1]))exch(a,j,j-1);
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
