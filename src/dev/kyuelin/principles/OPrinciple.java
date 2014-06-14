package principles;

public class OPrinciple {
	// no change required when a new shape is added.
	class GraphicEditor {
		public void drawShape(Shape s) {s.draw();}
	}
	abstract class Shape {
		abstract void draw();
	}
	class Rectangle extends Shape {
		public void draw() {}
	}
}
