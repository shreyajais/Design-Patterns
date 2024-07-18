package DesignPatterns.Structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {

    public interface Component {
        String getName();
        void addComponent(Component component);
        void removeComponent(Component component);
        void printName();
    }

    // leaf class -> file of a folder

    public class LeafComponent implements Component {
        String name;

        public LeafComponent(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void addComponent(Component component) {
            throw new UnsupportedOperationException("Cannot add components");
        }

        @Override
        public void removeComponent(Component component) {
            throw new UnsupportedOperationException("Cannot remove components");
        }

        @Override
        public void printName() {
            System.out.println("name of the file"+ name);
        }
    }

    // Node class -> folder inside a folder
    public class NodeComponent implements Component {

        String name;

        public NodeComponent(String name) {
            this.name = name;
            this.componentList = new ArrayList<>();
        }

        List<Component> componentList;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void addComponent(Component component) {
            componentList.add(component);
        }

        @Override
        public void removeComponent(Component component) {
            componentList.remove(component);
        }

        @Override
        public void printName() {
            System.out.println("name of the folder"+ name);
            for(Component c: this.componentList){
                c.printName();
            }
        }

        public void main(String[] args){
            Component root = new NodeComponent("root");
            Component leaf1 = new LeafComponent("leaf1");
            Component leaf2 = new LeafComponent("leaf2");
            Component node1 = new NodeComponent("node1");
            root.addComponent(leaf1);
            root.addComponent(leaf2);
            root.addComponent(node1);
            node1.addComponent(new LeafComponent("leaf3"));
            root.printName();
        }
    }
}
