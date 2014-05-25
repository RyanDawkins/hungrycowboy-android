package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.GregorianCalendar;

/**
 *
 * The hours that a restaurant will be available
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 05/24/2014
 *
 */
public class AvailableHours implements Parcelable {

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
     * Constructor necessary for the Parcelable implementation.
     * Parcelable allows this object to be passes easily from one activity to another.
     * It might be necessary in the future.
     * @param in the parcelable object.
     */
    public AvailableHours(Parcel in) {
        this.dateStart = (GregorianCalendar) in.readSerializable();
        this.dateEnd = (GregorianCalendar) in.readSerializable();
    }

    /**
     * Creator necessary for any parcelable object.
     */
    public static final Parcelable.Creator<AvailableHours> CREATOR
            = new Parcelable.Creator<AvailableHours>() {
        public AvailableHours createFromParcel(Parcel in) {
            return new AvailableHours(in);
        }

        public AvailableHours[] newArray(int size) {
            return new AvailableHours[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeSerializable(getDateStart());
        out.writeSerializable(getDateEnd());
    }
}
