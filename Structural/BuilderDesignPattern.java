package DesignPatterns.Structural;
// interfaces for  the different individual components of the class and creating objects that are composite of these components
public class BuilderDesignPattern {

    public interface Shape {
        void draw();
    }

    public interface Color {
        void doColor();
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("This is circle");
        }
    }

    public class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("This is square");
        }
    }

    public class RedColor implements Color {

        @Override
        public void doColor() {
            System.out.println("Color it with red");
        }
    }

    public class BlueColor implements Color{

        @Override
        public void doColor() {
            System.out.println("Color it with blue");
        }
    }

    public class ColorShape implements Shape {
        Color color;
        Shape shape;

        public ColorShape(Color color, Shape shape)  {
            this.color = color;
            this.shape = shape;
        }


        @Override
        public void draw() {
            shape.draw();
            color.doColor();
        }
    }

    public void main(String[] args) {
        Shape redCircle = new ColorShape(new RedColor(), new Circle());
        Shape blueSquare = new ColorShape(new BlueColor(), new Square());
        redCircle.draw();
        blueSquare.draw();
    }


}
