package pl.ms.rrs;

import pl.ms.rrs.model.Fixtures;
import pl.ms.rrs.services.IScheduleService;
import pl.ms.rrs.services.SpanDiagramScheduleService;

/**
 * Created by Marcin on 2015-09-24.
 */
public class App {

    public static void main(String[] args) {
        IScheduleService scheduleService = new SpanDiagramScheduleService<>();

        Fixtures t4 = scheduleService.schedule(new String[]{"a", "b", "c", "d"});
        System.out.println(t4);

        Fixtures t3 = scheduleService.schedule(new String[]{"a", "b", "c"});
        System.out.println(t3);

        String[] s = new String[20];
        for (int i = 0; i < s.length; i++) {
            s[i] = new String(new char[]{(char) ((int)'a' + i)});
        }
        Fixtures t20 = scheduleService.schedule(s);
        System.out.println(t20);

    }

}
