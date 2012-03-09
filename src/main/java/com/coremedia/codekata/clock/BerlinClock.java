package com.coremedia.codekata.clock;

/**
 * Interface for BerlinClock implementations
 */
public interface BerlinClock {
  /**
   * Sets the time in format HH:MM:SS
   * @param time the time in format HH:MM:SS
   */
  void setTime(String time);

  /**
   * provides the berlin clock light as follows:
   *
   * #                  The seconds Y or O
   * ####               The 1/5 Day indicator hour 0(R),5(R),10(R),15(R),20(R)
   * ####               The single hour appender  before + x
   * ###########        The 1/12 hour indicator 0(O),5(Y),10(Y),15(R),20(Y),25(Y),30(R),35(Y),40(Y),45(R),50(Y),55(Y)
   * ####               The minutes between (Y)

   * @return the concatted string with \n divider
   */
  String getBerlinClockTime();

}
