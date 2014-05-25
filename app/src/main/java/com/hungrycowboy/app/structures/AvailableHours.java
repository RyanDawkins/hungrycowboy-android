package com.hungrycowboy.app.structures;

import java.util.GregorianCalendar;

/**
 *
 * The hours that a restaurant will be available
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 05/24/2014
 *
 */
public class AvailableHours {

    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;

    /**
     * Default Empty Constructor
     */
    public AvailableHours() {
    }

    /**
     * Constructor that takes the 2 date times
     * @param dateStart the time when the restaurant opens
     * @param dateEnd the time when the restaurant closes
     */
    public AvailableHours(GregorianCalendar dateStart, GregorianCalendar dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getDateStart() {
        return dateStart;
    }

    /**
     *
     * @param dateStart
     */
    public AvailableHours setDateStart(GregorianCalendar dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    /**
     *
     * @return
     */
    public GregorianCalendar getDateEnd() {
        return dateEnd;
    }

    /**
     *
     * @param dateEnd
     */
    public AvailableHours setDateEnd(GregorianCalendar dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    /**
     * This method is used to check if a Restaurant is open.
     * @return
     *          true if the restaurant is open.
     *          false if it is not.
     */
    public boolean isAvailable() {

        GregorianCalendar currentTime = new GregorianCalendar();

        if(currentTime.getTimeInMillis() > dateStart.getTimeInMillis() && currentTime.getTimeInMillis() < dateEnd.getTimeInMillis()) {
            return  true;
        }

        return false;
    }

    /**
     * Helper function to see how longer a restaurant will be available.
     * @param currentTime the current time in milliseconds
     * @return the available time in milliseconds
     */
    public long timeAvailable(long currentTime) {

        if(isAvailable()) {
            return dateEnd.getTimeInMillis() - currentTime;
        }

        return 0;
    }

}
