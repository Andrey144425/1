package base;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    T startFruit;

    public Box(){}

    public Box(T startFruit) {
        this.startFruit = startFruit;
    }

    double getWeight(){
        if (startFruit == null)
            return 0;

        int weight = 0;
        Fruit f = startFruit;
        while (f.next != null){
            weight += f.weight;
            f = f.next;
        }
        return weight;
    }

    int size(){
        if (startFruit == null)
            return 0;

        int size = 0;
        Fruit f = startFruit;
        while (f.next != null){
            size++;
            f = f.next;
        }
        return size;
    }

    void add(T item){
        if (startFruit == null) {
            startFruit = item;
            return;
        }

        if (item instanceof Orange && startFruit instanceof Apple ||
        item instanceof Apple && startFruit instanceof Orange){
            throw new IllegalArgumentException("added element isnt of the same type as those in" +
                    " the box!");
        }

        Fruit f = startFruit;
        while (f.next != null)
            f = f.next;
        f.next = item;
    }

    void remove(int index){
        if (index >= size() || index < 0)
            return;

        int start = 0;
        Fruit f = startFruit;
        while (start != index-1){
            f = f.next;
            start++;
        }
        f.next = f.next.next;
    }

    void remove(T item){
        Fruit f = startFruit;
        while (f.next != item){
            f = f.next;
        }
        f.next = f.next.next;
    }

    T get(int index){
        if (index < 0 || index >= size())
            return null;

        int start = 0;
        T f = startFruit;
        while (start != index){
            f = (T) f.next;
            start++;
        }
       return f;
    }

    void clear(){
        startFruit = null;
    }

    void transferFruits(Box<T> toTransfer){
        if ((toTransfer.get(0) instanceof Orange && startFruit instanceof Apple) ||
                (toTransfer.get(0) instanceof Apple && startFruit instanceof Orange))
            throw new IllegalArgumentException("wrong types of boxes!");

        Fruit f = startFruit;
        while (f.next != null)
            f = f.next;

        Fruit f1 = toTransfer.startFruit;
        while (f1.next != null){
            f.next = f1;
            f1 = f1.next;
            f = f.next;
        }
        toTransfer.clear();
    }


    public boolean Compare(Object obj) {
        Box toCompare = (Box) obj;
        return toCompare.getWeight() == getWeight();
    }
}
