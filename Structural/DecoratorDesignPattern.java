package DesignPatterns.Structural;

public class DecoratorDesignPattern {
    public interface Pizza {
        public String getName();
        public String getDescription();
        public Double getPrice();
    }

    public abstract class BasePizza implements Pizza {
        private String name;
        private String description;
        private Double price;

        public BasePizza(String name, String description, Double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public Double getPrice() {
            return price;
        }
    }

    public class HawaiianPizza extends BasePizza {
        public HawaiianPizza() {
            super("Hawaiian Pizza", "Hawaiian Pizza (tomato sauce, mozzarella cheese, ham, pineapple)", 10.00);
        }
    }
    public class MargheritaPizza extends BasePizza {
        public MargheritaPizza() {
            super("Margherita Pizza", "Margherita Pizza (tomato sauce, mozzarella cheese)", 8.00);
        }
    }

    public abstract class CheeseDecorator implements Pizza {
        Pizza pizza;
        String cheeseType;
        double extraPrice;

        public CheeseDecorator(Pizza pizza, String cheeseType, double extraPrice) {
            this.pizza = pizza;
            this.cheeseType = cheeseType;
            this.extraPrice = extraPrice;
        }
        @Override
        public String getName() {
            return pizza.getName() + cheeseType;
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + cheeseType;
        }

        @Override
        public Double getPrice() {
            return pizza.getPrice() + extraPrice;
        }
    }

    public class GoatCheeseDecorator extends CheeseDecorator{

        public GoatCheeseDecorator(Pizza pizza) {
            super(pizza, "Goat Cheese", 2);
        }
    }

    public class MozerellaCheeseDecorator extends CheeseDecorator{

        public MozerellaCheeseDecorator(Pizza pizza) {
            super(pizza, "Mozerella Cheese", 5);
        }
    }

    public abstract class ToppingsDecorator implements Pizza {
        private Pizza pizza;
        private String ingredient;
        private Double price;

        public ToppingsDecorator(Pizza pizza, String ingredient, Double price) {
            this.pizza = pizza;
            this.ingredient = ingredient;
            this.price = price;
        }

        @Override
        public String getName() {
            return pizza.getName() + ingredient;
        }

        @Override
        public String getDescription() {
            return pizza.getName() + ingredient;
        }

        @Override
        public Double getPrice() {
            return pizza.getPrice()+ price;
        }
    }

    public class TomatoesToppings extends ToppingsDecorator {

        public TomatoesToppings(Pizza pizza) {
            super(pizza, "Tomato", 2.0);
        }
    }

    public class OlivesToppings extends ToppingsDecorator {

        public OlivesToppings(Pizza pizza) {
            super(pizza, "Olives", 3.0);
        }
    }

    public  void main(String[] args){
        Pizza hawaiianWithCheese = new GoatCheeseDecorator(new HawaiianPizza());
        Pizza margheritaWithMozerellaWithTomatoes = new TomatoesToppings(new MozerellaCheeseDecorator(new MargheritaPizza()));
    }


}
