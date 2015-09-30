package pl.ms.rrtournament.services;

import pl.ms.rrtournament.model.Round;
import pl.ms.rrtournament.model.Tournament;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Marcin on 2015-09-18.
 */
public class SpanDiagramScheduleService<T> implements IScheduleService<T> {

    /**
     * https://fr.wikipedia.org/wiki/Table_de_Berger,
     *
     * Round Robin Schedule Span Diagram, taken from https://en.wikipedia.org/wiki/Round-robin_tournament#cite_note-17
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

        T centerElement = nelements[nelements.length-1];
        T[] restnelements = (T[]) Array.newInstance(class_, elements.length-1);
        System.arraycopy(nelements, 0, restnelements, 0, nelements.length-1);


        for (int idx = 0; idx < restnelements.length ; idx++) {
            // create round
            Round r = Round.from(centerElement, (t.size()+1)%2==0, restnelements); //6 and 1,2,3,4,5
            t.addRound(r);

            // rotate n/2 times, 1,2,3,4,5 -> 4,5,1,2,3
            for (int rot = 0; rot < restnelements.length / 2; rot++) {
                T temp = restnelements[restnelements.length - 1];
                for (int i = restnelements.length - 1; i > 0; i--) {
                    restnelements[i] = restnelements[i - 1];
                }
                restnelements[0] = temp;
            }
        }

        return t;
    }

}

