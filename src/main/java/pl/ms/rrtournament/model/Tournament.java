package pl.ms.rrtournament.model;

import org.apache.commons.collections.MapUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-09-18.
 */
public class Tournament {

    private Map<Integer, Round> roundMap;

    private Tournament() {
        roundMap = new LinkedHashMap<>();
    }

    public static Tournament empty() {
        return new Tournament();
    }

    public Round getRound(Integer roundId) {
        if (roundId == null) {
            return Round.empty();
        }
        if (!roundMap.containsKey(roundId)) {
            return Round.empty();
        }
        return roundMap.get(roundId);
    }

    public void addRound(Round r) {
        roundMap.put(roundMap.size() + 1, r);
    }

    public int size() {
        return isEmpty() ? 0 : roundMap.size();
    }

    public boolean isNotEmpty() {
        return MapUtils.isNotEmpty(roundMap);
    }

    public boolean isEmpty() {
        return MapUtils.isEmpty(roundMap);
    }


    @Override
    public String toString() {
        return Arrays.toString(roundMap.entrySet().toArray());
    }
}
