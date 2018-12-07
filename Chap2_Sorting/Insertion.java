package Chap2_Sorting;

public class Insertion {
	// 平均N^2/4次比较  平均N^2/4次交换 最优情况下N-1次比较 0次交换
	public static void sort(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			Comparable tmp=a[i];
			int j=i-1;
			while(j>=0&&less(tmp,a[j])) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=tmp;
		}
	}
	/*
	 * 还有一种方法是先将列表中最小的元素找出来放到第一个位置 充当哨兵
	 * int exchanges = 0;
        for (int i = n-1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                exch(a, i, i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;


        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
	 */
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
