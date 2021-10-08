package Generics.GenericScale;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Scale<>(13,14).getHeavier());
        System.out.println(new Scale<>("A","Z").getHeavier());
        System.out.println(new Scale<>(100,100).getHeavier());
    }
}
