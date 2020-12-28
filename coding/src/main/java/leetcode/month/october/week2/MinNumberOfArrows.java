package leetcode.month.october.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MinNumberOfArrows {

	public static void main(String[] args) {
		int[][] points = new int[][] {{10,16},{2,8},{1,6}};
		MinNumberOfArrows m = new MinNumberOfArrows();
		System.out.println(m.findMinArrowShots(points));

	}

	public int findMinArrowShots(int[][] points) {
		ArrayList<Point> p = new ArrayList<Point>();
		for (int i = 0; i < points.length; i++) {
			p.add(new Point(points[i][0], points[i][1]));
		}
		/*
		 * Collections.sort(p, new Comparator<Point>() {
		 * 
		 * @Override public int compare(Point o1, Point o2) { if (o1.b < o2.b) { return
		 * -1; } return 1; }
		 * 
		 * });
		 */
		mergesort(p, 0, p.size()-1);
		Stack<Point> st = new Stack<Point>();
		for (int i = 0; i < p.size(); i++) {
			if (st.isEmpty()) {
				st.push(p.get(i));
			} else {
				if (st.peek().b >= p.get(i).a) {
					if (st.peek().a < p.get(i).a) {
						st.peek().a = p.get(i).a;
					}
					if (st.peek().b > p.get(i).b) {
						st.peek().b = p.get(i).b;
					}
				}else {
					st.push(p.get(i));
				}
			}
		}
		return st.size();

	}
	
	public void mergesort(ArrayList<Point> al , int left ,int right) {
		if(left == right) {
			return;
		}
		int mid = left +(right-left)/2;
		mergesort(al,left,mid);
		mergesort(al,mid+1,right);
		merge(al,left,mid,right);
	}

	private void merge(ArrayList<Point> al, int left, int mid, int right) {
		ArrayList<Point> point = new ArrayList<Point>();
		int i = left;
		int j = mid+1;
		while(i <= mid && j <= right) {
			if(al.get(i).b < al.get(j).b) {
				point.add(al.get(i));
				i++;
			}else {
				point.add(al.get(j));
				j++;
			}
		}
		while(i <= mid) {
			point.add(al.get(i));
			i++;
		}
		while(j <= right) {
			point.add(al.get(j));
			j++;
		}
		int k = 0;
		while(left <= right) {
			al.set(left, point.get(k));
			k++;
			left++;
		}
	}
}

class Point {
	int a;
	int b;

	Point(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
