package Chap2_Sorting;

public class Selection {
	//N^2/2次比较  N次交换
	public static void sort(Comparable[] a) {
		int len=a.length;
		int min;
		
		for(int i=0;i<len-1;i++) {
			min=i;
			for(int j=i+1;j<len;j++) {
				if(less(a[j],a[i]))min=j;
			}
			exch(a,i,min);
		}
		//System.out.println(isSorted(a));
	}

	private static boolean isSorted(Comparable[] a) {
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
		Integer[] a=new Integer[] {2,4,1,8,10,99,14,5};
		sort(a);
		assert isSorted(a);
		show(a);
	}
	
}
