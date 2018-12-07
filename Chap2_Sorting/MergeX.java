package Chap2_Sorting;

public class MergeX {
	
	private static Comparable[] tmp;
	private static final int CUTOFF=7;
	
	//算法时间复杂度 1/2NlgN~NlgN次比较  缺点是需要N额外的空间 top-down mergesort
	public static void sort(Comparable[] a) {
		
		tmp=a.clone();
		sort(tmp,a,0,a.length-1);
		
	}
	private static void sort(Comparable[] src,Comparable[] dst,int lo, int hi) {
		
		//if(lo>=hi)return;
		if (hi <= lo + CUTOFF) {          //对于小的数组 用插入排序的速度更快 提高小数组的排序速度
            insertionSort(dst, lo, hi);
            return;
        }
		int mid=lo+(hi-lo)/2;
		sort(dst,src,lo,mid);               //通过在递归中交换参数避免数组复制
		sort(dst,src,mid+1,hi); 
		if (!less(src[mid+1], src[mid])) {       //提前判断数组是否已经有序
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi);
	}
	private static void merge(Comparable[] src,Comparable[] dst,int lo, int mid, int hi) {
		
		int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }
	}
	
	public static void insertionSort(Comparable[] a,int lo,int hi) {
		for(int i=lo;i<=hi;i++) {
			Comparable tmp=a[i];
			int j=i-1;
			while(j>=lo&&less(tmp,a[j])) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=tmp;
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
