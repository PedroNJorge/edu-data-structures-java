public class Rectangle {
	Point p1, p2;

	Rectangle(Point P1, Point P2) {
		p1 = P1;
		p2 = P2;		
	}

	Rectangle(int x1, int y1, int x2, int y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
	}
	
	public int area() {
		int delta_x = this.p2.x - this.p1.x;
		int delta_y = this.p2.y - this.p1.y;
		return delta_x * delta_y;
	}

	public int perimeter() {
		int delta_x = this.p2.x - this.p1.x;
		int delta_y = this.p2.y - this.p1.y;
		return 2*delta_x + 2* delta_y;
	}

	public boolean pointInside(Point p) {
		boolean x = (p.x <= this.p2.x && p.x >= this.p1.x);
		boolean y = (p.y <= this.p2.y && p.y >= this.p1.y);
		return (x && y);
	}

	public boolean rectangleInside(Rectangle r) {
		return (this.pointInside(r.p1) && this.pointInside(r.p2));
	}	
}
