package pl.ms.rrtournament;

import pl.ms.rrtournament.model.Tournament;
import pl.ms.rrtournament.services.IScheduleService;
import pl.ms.rrtournament.services.StandardScheduleService;

/**
 * Created by Marcin on 2015-09-24.
 */
public class App {

    public static void main(String[] args) {
        IScheduleService scheduleService = new StandardScheduleService();

        Tournament t4 = scheduleService.schedule(new String[]{"a", "b", "c", "d"});
        System.out.println(t4);

        Tournament t3 = scheduleService.schedule(new String[]{"a", "b", "c"});
        System.out.println(t3);

        String[] s = new String[20];
        for (int i = 0; i < s.length; i++) {
            s[i] = new String(new char[]{(char) ((int)'a' + i)});
        }
        Tournament t32 = scheduleService.schedule(s);
        System.out.println(t32);

    }

}
