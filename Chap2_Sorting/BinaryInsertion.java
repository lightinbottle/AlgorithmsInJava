package Chap2_Sorting;

public class BinaryInsertion {
	
	//将二分查找用在插入位置的选择中
	public static void sort(Comparable[] a) {
		
		for(int i=1;i<a.length;i++) {
			Comparable tmp=a[i];
			int lo=0,hi=i;
			while(lo<hi) {
				int mid=lo+(hi-lo)/2;
				if(less(tmp,a[mid]))hi=mid;
				else lo=mid+1;
			}
			for(int j=i-1;j>=lo;j--)a[j+1]=a[j];
			a[lo]=tmp;
		}
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
		Integer[] a=new Integer[] {2,4,-1,8,10,99,14,5};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
