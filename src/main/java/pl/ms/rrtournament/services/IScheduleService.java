package pl.ms.rrtournament.services;

import pl.ms.rrtournament.model.Tournament;

/**
 * Created by Marcin on 2015-09-18.
 */
public interface IScheduleService {

    Tournament schedule(String[] elements);

}
