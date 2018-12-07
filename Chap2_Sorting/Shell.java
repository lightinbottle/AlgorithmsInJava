package Chap2_Sorting;

public class Shell {

		//突破了平方复杂度的算法 复杂度跟递增序列有关 默认的递增序列（1,4,13...）下最差情况下时间复杂度N^(3/2)
		public static void sort(Comparable[] a) {
			int N=a.length;
			int h=1;
			while(h<N/3)h=3*h+1;   
			while(h>=1) {
				for(int i=h;i<N;i++)
					for(int j=i-h;j>=0&&less(a[j+h],a[j]);j-=h) {
						exch(a,j+h,j);
					}
				h/=3;
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
			Integer[] a=new Integer[] {2,4,-1,8,10,99,14,5};
			sort(a);
			assert isSorted(a);
			show(a);
		}
	
}
