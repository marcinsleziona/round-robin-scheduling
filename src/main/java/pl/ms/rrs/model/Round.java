package pl.ms.rrs.model;

import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-09-18.
 */
public class Round<T> {

    private Map<Integer, Pair> pairMap;

    private Round() {
        pairMap = new LinkedHashMap<>();
    }

    public static <T> Round from(T[] nelements) {
        if (nelements.length % 2 != 0) {
            throw new IllegalStateException("The size must be an even number !");
        }

        Round round = Round.empty();
        for (int i = 0; i < nelements.length / 2; i++) {
            round.pairMap.put(round.pairMap.size() + 1, Pair.from(nelements[i], nelements[nelements.length - 1 - i]));
        }
        return round;
    }

    public static <T> Round from(T element, boolean elementHome, T[] nelements) {
        if (nelements.length % 2 == 0) {
            throw new IllegalStateException("The size must be an odd number !");
        }

        Round round = Round.empty();
        if (elementHome) {
            round.pairMap.put(1, Pair.from(element, nelements[0]));
        } else {
            round.pairMap.put(1, Pair.from(nelements[0], element));
        }

        // rest 1,   2,3,4,5, 2-5, 3-4
        for (int i = 1; i <= nelements.length / 2; i++) {
            round.pairMap.put(round.pairMap.size() + 1, Pair.from(nelements[i], nelements[nelements.length - i]));
        }
        return round;
    }

    public static Round empty() {
        return new Round();
    }

    public Pair getPair(Integer pairId) {
        if (pairId == null) {
            return Pair.empty();
        }
        if (!pairMap.containsKey(pairId)) {
            return Pair.empty();
        }
        return pairMap.get(pairId);
    }

    public int size() {
        return isEmpty() ? 0 : pairMap.size();
    }

    public boolean isNotEmpty() {
        return MapUtils.isNotEmpty(pairMap);
    }

    public boolean isEmpty() {
        return MapUtils.isEmpty(pairMap);
    }

    @Override
    public String toString() {
        return Arrays.toString(pairMap.entrySet().toArray());
    }
}
