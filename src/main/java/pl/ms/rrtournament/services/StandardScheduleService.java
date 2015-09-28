package pl.ms.rrtournament.services;

import pl.ms.rrtournament.model.Round;
import pl.ms.rrtournament.model.Tournament;

import java.lang.reflect.Array;

/**
 * Created by Marcin on 2015-09-18.
 */
public class StandardScheduleService<T> implements IScheduleService<T> {

    /**
     * Scheduling algorithm
     * <p>
     * If n is the number of competitors, a pure round robin tournament requires  n/2(n-1) games.
     * If n is even, then in each of (n-1) rounds, n/2 games can be run concurrently, provided there exist sufficient resources (e.g. courts for a tennis tournament).
     * If n is odd, there will be n rounds, each with (n-1)/2 games, and one competitor having no game in that round.
     * <p>
     * The standard algorithm for round-robins is to assign each competitor a number, and pair them off in the first round …
     * Round 1. (1 plays 14, 2 plays 13, ... )
     * 1  2  3  4  5  6  7
     * 14 13 12 11 10 9  8
     * <p>
     * then fix one of the competitors in the first or last column of the table (number one in this example) and rotate the others clockwise one position
     * <p>
     * Round 2. (1 plays 13, 14 plays 12, ... )
     * 1  14 2  3  4  5  6
     * 13 12 11 10 9  8  7
     * <p>
     * Round 3. (1 plays 12, 13 plays 11, ... )
     * 1  13 14 2  3  4  5
     * 12 11 10 9  8  7  6
     * <p>
     * until you end up almost back at the initial position
     * <p>
     * Round 13. (1 plays 2, 3 plays 14, ... )
     * 1  3  4  5  6  7  8
     * 2 14  13 12 11 10 9
     * <p>
     * <p>
     * If there are an odd number of competitors, a dummy competitor can be added, whose scheduled opponent in a given round does not play and has a bye.
     * The schedule can therefore be computed as though the dummy were an ordinary player, either fixed or rotating.
     * Instead of rotating one position, any number relatively prime to  will generate a complete schedule.
     * <p>
     * The upper and lower rows can indicate home/away in sports, white/black in chess, etc.; to ensure fairness,
     * this must alternate between rounds since competitor 1 is always on the first row.
     * If, say, competitors 3 and 8 were unable to fulfil their fixture in the third round,
     * it would need to be rescheduled outside the other rounds,
     * since both competitors would already be facing other opponents in those rounds.
     * <p>
     * More complex scheduling constraints may require more complex algorithms.
     * This schedule is applied in chess and draughts tournaments of rapid games, where players physically move round a table.
     * In France this is called the Carousel-Berger system (Système Rutch-Berger).
     */
    @Override
    public Tournament schedule(T[] elements) {
        Tournament t = Tournament.empty();
        if (elements == null) {
            return t;
        }
        if (elements.length == 0) {
            return t;
        }

        // create new array to compensate odd length
        Class<T> class_ = (Class<T>) elements[0].getClass();
        T[] nelements;
        if (elements.length % 2 == 0) {
            //nelements = new String[elements.length];
            nelements = (T[]) Array.newInstance(class_, elements.length);
            System.arraycopy(elements, 0, nelements, 0, elements.length);
        } else {
            //nelements = new String[elements.length + 1];
            nelements = (T[]) Array.newInstance(class_, elements.length+1);
            System.arraycopy(elements, 0, nelements, 0, elements.length);
        }

        for (int idx = 0; idx < nelements.length - 1; idx++) {
            // create round
            Round r = Round.from(nelements);
            t.addRound(r);

            // fill nelements 1,2,3,4,5,6 -> 1,6,2,3,4,5
            T temp = nelements[nelements.length-1];
            for (int i = nelements.length-1; i > 1; i--) {
                nelements[i] = nelements[i - 1];
            }
            nelements[1] = temp;
        }

        return t;
    }

}

