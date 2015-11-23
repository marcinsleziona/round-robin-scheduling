package pl.ms.rrs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ms.rrs.model.Pair;
import pl.ms.rrs.model.Round;
import pl.ms.rrs.model.Tournament;
import pl.ms.rrs.services.IScheduleService;
import pl.ms.rrs.services.StandardScheduleService;

/**
 * Created by Marcin on 2015-09-18.
 */
public class StandardScheduleServiceTest {

    private IScheduleService scheduleService;

    @Before
    public void setUp() {
        scheduleService = new StandardScheduleService();
    }

    @Test
    public void shouldSchedule2Elements() {
        //given
        String[] teams = {"a", "b"};

        //when
        Tournament t = scheduleService.schedule(teams);
        System.out.println(t);

        //then
        Assert.assertNotNull(t);
        Assert.assertTrue(t.isNotEmpty());
        Assert.assertEquals(1, t.size());

        Round round1 = t.getRound(1);
        Assert.assertNotNull(round1);
        Assert.assertTrue(round1.isNotEmpty());

        Pair pair1 = round1.getPair(1);
        Assert.assertEquals("a", pair1.getElement1());
        Assert.assertEquals("b", pair1.getElement2());
    }

    @Test
    public void shouldSchedule3Elements() {
        //given
        String[] teams = {"a", "b", "c"};

        //when
        Tournament t = scheduleService.schedule(teams);
        System.out.println(t);

        //then
        Assert.assertNotNull(t);
        Assert.assertTrue(t.isNotEmpty());
        Assert.assertEquals(3, t.size());

        Round round1 = t.getRound(1);
        Assert.assertNotNull(round1);
        Assert.assertTrue(round1.isNotEmpty());
        Pair pair11 = round1.getPair(1);
        Assert.assertEquals("a", pair11.getElement1());
        Assert.assertNull(pair11.getElement2());
        Pair pair12 = round1.getPair(2);
        Assert.assertEquals("b", pair12.getElement1());
        Assert.assertEquals("c", pair12.getElement2());

        Round round2 = t.getRound(2);
        Assert.assertNotNull(round2);
        Assert.assertTrue(round2.isNotEmpty());
        Pair pair21 = round2.getPair(1);
        Assert.assertEquals("a", pair21.getElement1());
        Assert.assertEquals("c", pair21.getElement2());
        Pair pair22 = round2.getPair(2);
        Assert.assertNull(pair22.getElement1());
        Assert.assertEquals("b", pair22.getElement2());

        Round round3 = t.getRound(3);
        Assert.assertNotNull(round3);
        Assert.assertTrue(round3.isNotEmpty());
        Pair pair31 = round3.getPair(1);
        Assert.assertEquals("a", pair31.getElement1());
        Assert.assertEquals("b", pair31.getElement2());
        Pair pair32 = round3.getPair(2);
        Assert.assertEquals("c", pair32.getElement1());
        Assert.assertNull(pair32.getElement2());
    }

    @Test
    public void shouldSchedule6Elements() {
        //given
        String[] teams = {"a", "b", "c", "d", "e", "f"};

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
        Assert.assertEquals("a", pair11.getElement1());
        Assert.assertEquals("f", pair11.getElement2());

        Round round2 = t.getRound(2);
        Assert.assertNotNull(round2);
        Assert.assertTrue(round2.isNotEmpty());
        Pair pair21 = round2.getPair(1);
        Assert.assertEquals("a", pair21.getElement1());
        Assert.assertEquals("e", pair21.getElement2());

        Round round3 = t.getRound(3);
        Assert.assertNotNull(round3);
        Assert.assertTrue(round3.isNotEmpty());
        Pair pair31 = round3.getPair(1);
        Assert.assertEquals("a", pair31.getElement1());
        Assert.assertEquals("d", pair31.getElement2());
        Pair pair32 = round3.getPair(2);
        Assert.assertEquals("e", pair32.getElement1());
        Assert.assertEquals("c", pair32.getElement2());
        Pair pair33 = round3.getPair(3);
        Assert.assertEquals("f", pair33.getElement1());
        Assert.assertEquals("b", pair33.getElement2());

        Round round4 = t.getRound(4);
        Assert.assertNotNull(round4);
        Assert.assertTrue(round4.isNotEmpty());
        Pair pair41 = round4.getPair(1);
        Assert.assertEquals("a", pair41.getElement1());
        Assert.assertEquals("c", pair41.getElement2());

        Round round5 = t.getRound(5);
        Assert.assertNotNull(round5);
        Assert.assertTrue(round5.isNotEmpty());
        Pair pair51 = round5.getPair(1);
        Assert.assertEquals("a", pair51.getElement1());
        Assert.assertEquals("b", pair51.getElement2());
    }
}
