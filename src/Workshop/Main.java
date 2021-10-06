package Workshop;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10 * 10 * 10 * 10 * 10 * 10 ; i++) {
            smartArray.add(i);
        }
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.println(smartArray.get(i));
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
