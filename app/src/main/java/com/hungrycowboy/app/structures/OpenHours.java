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
public class OpenHours {

    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;

    /**
     * Default Empty Constructor
     */
    public OpenHours() {
    }

    /**
     * Constructor that takes the 2 date times
     * @param dateStart the time when the restaurant opens
     * @param dateEnd the time when the restaurant closes
     */
    public OpenHours(GregorianCalendar dateStart, GregorianCalendar dateEnd) {
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
    public void setDateStart(GregorianCalendar dateStart) {
        this.dateStart = dateStart;
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
    public void setDateEnd(GregorianCalendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * This method is used to check if a Restaurant is open.
     * @return
     *          true if the restaurant is open.
     *          false if it is not.
     */
    public boolean canUse() {

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

        if(canUse()) {
            return dateEnd.getTimeInMillis() - currentTime;
        }

        return 0;
    }

}
