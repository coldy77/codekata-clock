package com.coremedia.codekata.clock;


/**
 * Implementation for berlin clock interface.
 */
public class BerlinClockImpl implements BerlinClock {
  private String time;

  @Override
  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public String getBerlinClockTime() {
    return convertToBerlinClockTime(); 
  }
  
  private String convertToBerlinClockTime(){
    StringBuilder sb = new StringBuilder();
    assert (time != null && !time.equals(""));
    String[] timeValues = time.split(":");
    if (timeValues.length != 3) {
      throw new IllegalArgumentException("Time " + time + "is not valid. Use ##:##:##");
    }
 
    BerlinClockModel model = new BerlinClockModel(timeValues[0], timeValues[1], timeValues[2]);

    sb.append(model.getSeconds());
    sb.append("\n");
    sb.append(model.getHours()[0]);
    sb.append("\n");
    sb.append(model.getHours()[1]);
    sb.append("\n");
    sb.append(model.getMinutes()[0]);
    sb.append("\n");
    sb.append(model.getMinutes()[1]);

    return sb.toString();
  }
}
