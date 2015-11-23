package pl.ms.rrs.services;

import pl.ms.rrs.model.Tournament;

/**
 * Created by Marcin on 2015-09-18.
 */
public interface IScheduleService<T> {

    Tournament schedule(T[] elements);

}
