package pl.ms.rrs.services;

import pl.ms.rrs.model.Fixtures;

/**
 * Created by Marcin on 2015-09-18.
 */
public interface IScheduleService<T> {

    Fixtures schedule(T[] elements);

}
