package base;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Box box = new Box();
        box.add(new Apple());
        box.add(new Apple());
        box.add(new Apple());

        Box box1 = new Box();
        box1.add(new Orange());
        box1.add(new Orange());

        System.out.println(box.Compare(box1));
        box.transferFruits(box1);
      //  box.add(new Orange());
    }
}
