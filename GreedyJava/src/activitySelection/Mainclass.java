package activitySelection;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int []  start = new int [n];
		int [] end = new int [n];
		for(int i=0; i<n; i++) {
			start [i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			end [i] = sc.nextInt();
		}
		mergeSort(end, start, 0, n-1);
		int activities = 1;
		int prevsend = end[0];
		for(int i=0; i<n-1; i++) {
			if(start[i+1] > prevsend ) {
				activities++;
				prevsend = end[i+1];
			}
		}
		System.out.println(activities);
		
	}
	static void mergeSort(int [] a, int [] dup, int l, int r) {
		
		if(l==r)return;
		
		int mid = (l+r)/2;
		mergeSort(a, dup, l, mid);
		mergeSort(a, dup, mid+1, r);
		merge(a,dup, l, r, mid);
		
	}
	
	static void merge(int [] a, int [] dup, int l, int r, int mid) {

		int n1 = mid -l +1;
		int n2 = r-mid;
		
		int [] a1 = new int [n1];
		int [] a2 = new int [n2];
		
		int [] b1 = new int [n1];
		int [] b2 = new int [n2];
		for(int i=0; i<n1; i++) {
			a1[i] = a[l + i];
			b1[i] = dup[l + i];
		}
		for(int i=0; i<n2; i++) {
			a2[i] = a[mid + 1 +  i];
			b2[i] = dup[mid + 1 + i];
		}
		int i=0;
		int j=0;
		int k=l;
		
		while(i<=n1-1 && j<=n2-1) {
			if(a1[i] < a2[j]) {
				a[k] = a1[i];
				dup[k] = b1[i];
				i++; 
				k++;
			}
			else {
				a[k] = a2[j];
				dup[k] = b2[j];
				j++;
				k++;
			}
		}
		
		if(i == n1) {
			for( ; j<n2; ) {
			 a[k] = a2[j];
			 dup[k] = b2[j];
				k++;
				j++;
			} 
		}
		else {
			for( ; i<n1; ) {
			a[k] = a1[i];
			dup[k] = b1[i];
				k++;
				i++;
			}
		}
	}
	}