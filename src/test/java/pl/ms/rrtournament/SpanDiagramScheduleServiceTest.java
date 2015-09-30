package pl.ms.rrtournament;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ms.rrtournament.model.Pair;
import pl.ms.rrtournament.model.Round;
import pl.ms.rrtournament.model.Tournament;
import pl.ms.rrtournament.services.IScheduleService;
import pl.ms.rrtournament.services.SpanDiagramScheduleService;

/**
 * Created by Marcin on 2015-09-30.
 */
public class SpanDiagramScheduleServiceTest {

    private IScheduleService scheduleService;

    @Before
    public void setUp() {
        scheduleService = new SpanDiagramScheduleService<>();
    }

    @Test
    public void shouldSchedule6Elements() {
        //given
        String[] teams = {"1", "2", "3", "4", "5", "6"};

        //when
        Tournament t = scheduleService.schedule(teams);
        System.out.println(t);

        //then
        Assert.assertNotNull(t);
        Assert.assertTrue(t.isNotEmpty());
        Assert.assertEquals(5, t.size());

        Round round1 = t.getRound(1);
        Assert.assertNotNull(round1);
        Assert.assertTrue(round1.isNotEmpty());
        Pair pair11 = round1.getPair(1);
        Assert.assertEquals("1", pair11.getElement1());
        Assert.assertEquals("6", pair11.getElement2());
        Pair pair12 = round1.getPair(2);
        Assert.assertEquals("2", pair12.getElement1());
        Assert.assertEquals("5", pair12.getElement2());
        Pair pair13 = round1.getPair(3);
        Assert.assertEquals("3", pair13.getElement1());
        Assert.assertEquals("4", pair13.getElement2());

        Round round2 = t.getRound(2);
        Assert.assertNotNull(round2);
        Assert.assertTrue(round2.isNotEmpty());
        Pair pair21 = round2.getPair(1);
        Assert.assertEquals("6", pair21.getElement1());
        Assert.assertEquals("4", pair21.getElement2());
        Pair pair22 = round2.getPair(2);
        Assert.assertEquals("5", pair22.getElement1());
        Assert.assertEquals("3", pair22.getElement2());
        Pair pair23 = round2.getPair(3);
        Assert.assertEquals("1", pair23.getElement1());
        Assert.assertEquals("2", pair23.getElement2());

        Round round3 = t.getRound(3);
        Assert.assertNotNull(round3);
        Assert.assertTrue(round3.isNotEmpty());
        Pair pair31 = round3.getPair(1);
        Assert.assertEquals("2", pair31.getElement1());
        Assert.assertEquals("6", pair31.getElement2());
        Pair pair32 = round3.getPair(2);
        Assert.assertEquals("3", pair32.getElement1());
        Assert.assertEquals("1", pair32.getElement2());
        Pair pair33 = round3.getPair(3);
        Assert.assertEquals("4", pair33.getElement1());
        Assert.assertEquals("5", pair33.getElement2());

        Round round4 = t.getRound(4);
        Assert.assertNotNull(round4);
        Assert.assertTrue(round4.isNotEmpty());
        Pair pair41 = round4.getPair(1);
        Assert.assertEquals("6", pair41.getElement1());
        Assert.assertEquals("5", pair41.getElement2());
        Pair pair42 = round4.getPair(2);
        Assert.assertEquals("1", pair42.getElement1());
        Assert.assertEquals("4", pair42.getElement2());
        Pair pair43 = round4.getPair(3);
        Assert.assertEquals("2", pair43.getElement1());
        Assert.assertEquals("3", pair43.getElement2());

        Round round5 = t.getRound(5);
        Assert.assertNotNull(round5);
        Assert.assertTrue(round5.isNotEmpty());
        Pair pair51 = round5.getPair(1);
        Assert.assertEquals("3", pair51.getElement1());
        Assert.assertEquals("6", pair51.getElement2());
        Pair pair52 = round5.getPair(2);
        Assert.assertEquals("4", pair52.getElement1());
        Assert.assertEquals("2", pair52.getElement2());
        Pair pair53 = round5.getPair(3);
        Assert.assertEquals("5", pair53.getElement1());
        Assert.assertEquals("1", pair53.getElement2());
    }
}
