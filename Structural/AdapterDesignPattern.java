package DesignPatterns.Structural;

public class AdapterDesignPattern {

    public interface Shape {
        public void draw();
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("This is a circle");
        }
    }

    public interface Drawable{
        public void render();
    }

    public class ShapeAdapter implements Drawable {
         public Shape shape;

        public ShapeAdapter(Shape shape) {
            this.shape = shape;
        }

        @Override
        public void render() {
            shape.draw();
        }
    }

    public class LegacyDesign {
        public void draw(Shape shape){
            shape.draw();
        }
    }

    public class ModernDesign {
        public void render(Drawable drawable){
            drawable.render();
        }
    }

    public void main(){
        Circle circle = new Circle();
        Drawable drawable = new ShapeAdapter(circle);

        ModernDesign modernDesign = new ModernDesign();
        modernDesign.render(drawable);


        LegacyDesign legacyDesign = new LegacyDesign();
        legacyDesign.draw(circle);
    }
}
