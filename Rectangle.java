public class Rectangle implements Comparable<Rectangle> {
    
    private double side1;
    private double side2;

    public Rectangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
    }

    public Rectangle(double side1, double side2) {
        setSide1(side1);
        setSide2(side2);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        if (side1 <= 0) {
            throw new IllegalArgumentException("Довжина першої сторони повинна бути додатнім числом.");
        }
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        if (side2 <= 0) {
            throw new IllegalArgumentException("Довжина другої сторони повинна бути додатнім числом.");
        }
        this.side2 = side2;
    }

    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    public double getArea() {
        return side1 * side2;
    }

    @Override
    public int compareTo(Rectangle other) {
        if (other == null) {
            throw new IllegalArgumentException("Порівнюваний прямокутник не може бути null.");
        }
        return Double.compare(this.getArea(), other.getArea());
    }

    public boolean isSimilar(Rectangle other) {
        if (other == null) {
            return false;
        }
        double ratio1 = this.side1 / this.side2;
        double ratio2 = other.side1 / other.side2;
        
        return Double.compare(ratio1, ratio2) == 0 ||
               Double.compare(ratio1, 1.0 / ratio2) == 0;
    }

    @Override
    public String toString() {
        return "Прямокутник [Сторона 1: " + side1 + ", Сторона 2: " + side2 + "]";
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4.0, 6.0);
        Rectangle rect2 = new Rectangle(2.0, 3.0);
        Rectangle rect3 = new Rectangle(5.0, 10.0);
        
        System.out.println(rect1);
        System.out.println("Периметр: " + rect1.getPerimeter());
        System.out.println("Площа: " + rect1.getArea());
        System.out.println();
        
        System.out.println(rect2);
        System.out.println("Периметр: " + rect2.getPerimeter());
        System.out.println("Площа: " + rect2.getArea());
        System.out.println();
        
        System.out.println(rect3);
        System.out.println("Периметр: " + rect3.getPerimeter());
        System.out.println("Площа: " + rect3.getArea());
        System.out.println();
        
        int comparison = rect1.compareTo(rect2);
        if (comparison > 0) {
            System.out.println("rect1 має більшу площу за rect2.");
        } else if (comparison < 0) {
            System.out.println("rect1 має меншу площу за rect2.");
        } else {
            System.out.println("rect1 та rect2 мають однакову площу.");
        }
        System.out.println();
        
        System.out.println("rect1 та rect2 подібні? " + rect1.isSimilar(rect2));
        System.out.println("rect1 та rect3 подібні? " + rect1.isSimilar(rect3));
    }
}
