package com.coremedia.codekata.clock;


/**
 * Implementation for berlin clock interface.
 * provides the berlin clock informations in the following way:
 *
 * #                  The seconds Y or O
 * ####               The 1/5 Day indicator hour 0(R),5(R),10(R),15(R),20(R)
 * ####               The single hour appender  before + x
 * ###########        The 1/12 hour indicator 0(O),5(Y),10(Y),15(R),20(Y),25(Y),30(R),35(Y),40(Y),45(R),50(Y),55(Y)
 * ####               The minutes between (Y)
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
