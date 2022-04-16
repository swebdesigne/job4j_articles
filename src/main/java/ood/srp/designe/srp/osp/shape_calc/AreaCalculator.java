package ood.srp.designe.srp.osp.shape_calc;

public class AreaCalculator {
    public double calculate(Object... shapes) {
        double area = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                area += rectangle.getHeight() * rectangle.getHeight();
            } else {
                Circle circle = (Circle) shape;
                area += Math.pow(circle.getRadius(), 2) * Math.PI;
            }
        }
        return area;
    }
}
