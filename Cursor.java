public class Cursor {
    
    private int horizontalCoordinate;
    private int verticalCoordinate;
    private Appearance appearance;
    private int size;
    private boolean isHidden;

    public enum Appearance {
        HORIZONTAL,
        VERTICAL
    }

    public Cursor() {
        this.horizontalCoordinate = 0;
        this.verticalCoordinate = 0;
        this.appearance = Appearance.HORIZONTAL;
        this.size = 1;
        this.isHidden = false;
    }

    public Cursor(int horizontalCoordinate, int verticalCoordinate, Appearance appearance, int size) {
        setHorizontalCoordinate(horizontalCoordinate);
        setVerticalCoordinate(verticalCoordinate);
        setAppearance(appearance);
        setSize(size);
        this.isHidden = false;
    }

    public void changeCoordinates(int newHorizontalCoordinate, int newVerticalCoordinate) {
        setHorizontalCoordinate(newHorizontalCoordinate);
        setVerticalCoordinate(newVerticalCoordinate);
        System.out.println("Координати курсору змінено на (" + horizontalCoordinate + ", " + verticalCoordinate + ").");
    }

    public void changeAppearance(Appearance newAppearance) {
        if (newAppearance == null) {
            System.out.println("Недійсний вигляд курсору.");
            return;
        }
        this.appearance = newAppearance;
        System.out.println("Вигляд курсору змінено на " + appearance + ".");
    }

    public void changeSize(int newSize) {
        setSize(newSize);
        System.out.println("Розмір курсору змінено на " + size + ".");
    }

    public void hideCursor() {
        if (!isHidden) {
            isHidden = true;
            System.out.println("Курсор приховано.");
        } else {
            System.out.println("Курсор вже прихований.");
        }
    }

    public void restoreCursor() {
        if (isHidden) {
            isHidden = false;
            System.out.println("Курсор відновлено.");
        } else {
            System.out.println("Курсор вже відображений.");
        }
    }

    public int getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public void setHorizontalCoordinate(int horizontalCoordinate) {
        if (horizontalCoordinate < 0) {
            throw new IllegalArgumentException("Горизонтальна координата повинна бути додатнім числом.");
        }
        this.horizontalCoordinate = horizontalCoordinate;
    }

    public int getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public void setVerticalCoordinate(int verticalCoordinate) {
        if (verticalCoordinate < 0) {
            throw new IllegalArgumentException("Вертикальна координата повинна бути додатнім числом.");
        }
        this.verticalCoordinate = verticalCoordinate;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        if (appearance == null) {
            throw new IllegalArgumentException("Вигляд курсору не може бути null.");
        }
        this.appearance = appearance;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1 || size > 15) {
            throw new IllegalArgumentException("Розмір курсору повинен бути від 1 до 15.");
        }
        this.size = size;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void displayStatus() {
        if (isHidden) {
            System.out.println("Курсор прихований.");
        } else {
            System.out.println("Курсор відображений:");
            System.out.println("  Координати: (" + horizontalCoordinate + ", " + verticalCoordinate + ")");
            System.out.println("  Вигляд: " + appearance);
            System.out.println("  Розмір: " + size);
        }
    }

    public static void main(String[] args) {
        Cursor cursor = new Cursor(10, 20, Appearance.HORIZONTAL, 5);
        cursor.displayStatus();
        cursor.changeCoordinates(15, 25);
        cursor.changeAppearance(Appearance.VERTICAL);
        cursor.changeSize(10);
        cursor.hideCursor();
        cursor.hideCursor();
        cursor.restoreCursor();
        cursor.displayStatus();
    }
}
