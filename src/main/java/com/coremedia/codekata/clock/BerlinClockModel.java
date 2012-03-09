package com.coremedia.codekata.clock;

/**
 * Modelclass to hold data for berlinclock and calculates the output
 */
public class BerlinClockModel {
  private int hours;
  private int minutes;
  private int seconds;

  public BerlinClockModel(String hours, String minutes, String seconds) {
    this.hours = Integer.parseInt(hours);
    this.minutes = Integer.parseInt(minutes);
    this.seconds = Integer.parseInt(seconds);
    if (this.hours < 0 || this.hours > 24) {
      throw new IllegalArgumentException("hour is invalid. Should be between 0 and 24");
    }
    if (this.hours == 24 && this.minutes != 0 && this.seconds != 0) {
      throw new IllegalArgumentException("hour is invalid. only 24:00:00 is valid with hours 24");
    }
  }

  /**
   * provides the string for the seconds
   * @return a string with Y or O
   */
  public String getSeconds() {
    return seconds%2 == 0 ? "Y" : "O";
  }

  public String[] getHours(){
    int hourTop = hours / 5;
    int rest = hours%5;
    
    StringBuilder hoursTop = new StringBuilder();
    hoursTop.append("OOOO");
    for (int i=0; i < hourTop; i++){
      hoursTop.setCharAt(i, 'R');
    }
    
    StringBuilder hoursBottom = new StringBuilder();
    hoursBottom.append("OOOO");
    for (int i=0; i < rest; i++){
      hoursBottom.setCharAt(i, 'R');
    }
    
    return new String[] {hoursTop.toString(),  hoursBottom.toString()};
  }
  
  public String[] getMinutes(){
    int minuteTop = minutes / 5;
    int rest = minutes % 5;
    StringBuilder minutesTop = new StringBuilder();
    minutesTop.append("OOOOOOOOOOO");
    for (int i = 1; i <= minuteTop; i++) {
      if (i % 3 == 0) {
        minutesTop.setCharAt(i-1, 'R');
      } else {
        minutesTop.setCharAt(i-1, 'Y');
      }
    }
    StringBuilder minutesBottom = new StringBuilder();
    minutesBottom.append("OOOO");
    for (int i = 0; i < rest; i++) {
      minutesBottom.setCharAt(i, 'Y');
    }
    return new String[] {minutesTop.toString() , minutesBottom.toString()};
  }
}
