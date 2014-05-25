package com.hungrycowboy.app.adapter.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import com.hungrycowboy.app.structures.AvailableHours;

import java.util.GregorianCalendar;

/**
 * Created by dawkins on 5/25/14.
 */
public class AvailableHoursParcel extends AvailableHours implements Parcelable {

    /**
     * Constructor necessary for the Parcelable implementation.
     * Parcelable allows this object to be passes easily from one activity to another.
     * It might be necessary in the future.
     * @param in the parcelable object.
     */
    public AvailableHoursParcel(Parcel in) {
        this.setDateStart((GregorianCalendar) in.readSerializable())
            .setDateEnd((GregorianCalendar) in.readSerializable());
    }

    /**
     * Creator necessary for any parcelable object.
     */
    public static final Parcelable.Creator<AvailableHours> CREATOR
            = new Parcelable.Creator<AvailableHours>() {
        public AvailableHours createFromParcel(Parcel in) {
            return new AvailableHoursParcel(in);
        }

        public AvailableHours[] newArray(int size) {
            return new AvailableHoursParcel[size];
        }
    };

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
