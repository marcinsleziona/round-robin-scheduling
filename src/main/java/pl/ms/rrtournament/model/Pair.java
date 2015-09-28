package pl.ms.rrtournament.model;

/**
 * Created by Marcin on 2015-09-18.
 */
public class Pair {

    private String element1;
    private String element2;

    public static Pair from(String element1, String element2) {
        Pair p = new Pair();
        p.element1 = element1;
        p.element2 = element2;
        return p;
    }

    public static Pair empty() {
        return new Pair();
    }

    public String getElement1() {
        return element1;
    }

    public String getElement2() {
        return element2;
    }

    public boolean isNotEmpty() {
        return element1 != null || element2 != null;
    }

    public boolean isEmpty() {
        return element1 == null && element2 == null;
    }

    @Override
    public String toString() {
        return element1 + "-" + element2;
    }
}
