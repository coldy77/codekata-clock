package com.coremedia.codekata.clock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BerlinClockTest {
  
  private final String time;
  private final String expectedResult;
  
  public BerlinClockTest(String time, String expectedResult) {
    this.time = time;
    this.expectedResult = expectedResult;
  }
  
  @Test
  public void testBerlinClock() throws Exception {
    BerlinClock clock = new BerlinClockImpl();
    clock.setTime(time);
    String berlinClockResult = clock.getBerlinClockTime();
    assertEquals(expectedResult, berlinClockResult);
  }

  @Parameterized.Parameters
  public static List<Object[]> data() {
    final Object[][] objects = {
            {"00:00:00", "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO"},
            {"00:00:01", "O\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO"},
            {"00:05:00", "Y\nOOOO\nOOOO\nYOOOOOOOOOO\nOOOO"},
            {"05:15:00", "Y\nROOO\nOOOO\nYYROOOOOOOO\nOOOO"},
            {"05:00:00", "Y\nROOO\nOOOO\nOOOOOOOOOOO\nOOOO"},
            {"13:17:01", "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO"},
            {"23:59:59", "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY"},
            {"24:00:00", "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO"}
    };
    return asList(objects);
  } 
}
