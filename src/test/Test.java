package test;

import java.util.ArrayList;

public class Test {
	
	static class Dataset{
		public ArrayList<Point> points; 
		public Point selectedPoint;
		
		public Point selectCell(){
			return points.get(0);
		}
		public Dataset(){
			points = new ArrayList<Point>();
		}
		public void update(Point point, int x, int y){
			point.x = x;
			point.y = y;
		}
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Dataset dataset = new Dataset();
		dataset.points.add(new Point(3,2));
		Point selectedPoint = dataset.selectCell();
		dataset.update(selectedPoint, 10, 10);
		
		System.out.println(dataset.points.get(0).x + " " + dataset.points.get(0).y);
		
	}
	

}
