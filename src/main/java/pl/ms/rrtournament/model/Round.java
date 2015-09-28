package pl.ms.rrtournament.model;

import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-09-18.
 */
public class Round {

    private Map<Integer, Pair> pairMap;

    private Round() {
        pairMap = new LinkedHashMap<>();
    }

    public static Round from(String[] nelements) {
        if (nelements.length % 2 != 0) {
            throw new IllegalStateException("The size must be an even number !");
        }

        Round round = Round.empty();
        for (int i = 0; i < nelements.length / 2; i++) {
            round.pairMap.put(round.pairMap.size() + 1, Pair.from(nelements[i], nelements[nelements.length - 1 - i]));
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
