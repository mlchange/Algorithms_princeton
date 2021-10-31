import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        String first = (String) list.get(0);
        list.add(new Integer(123));
        String second = (String) list.get(1);
    }
}
