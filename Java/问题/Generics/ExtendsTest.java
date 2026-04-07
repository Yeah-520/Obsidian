package Generics;
//泛型

import java.util.ArrayList;
import java.util.List;

public class ExtendsTest {
    static void main() {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);

        List<? extends Number> list;
        List<Integer> alist = new ArrayList<>(5);
        alist.add(54);
        list = alist;

        System.out.println(list);
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

}
class PairHelper {
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
