package com.hungrycowboy.app.adapter.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import com.hungrycowboy.app.structures.Combo;

import java.math.BigDecimal;

/**
 * Created by dawkins on 5/25/14.
 */
public class ComboParcel extends Combo implements Parcelable {


    /**
     * Constructor necessary for the Parcelable implementation.
     * Parcelable allows this object to be passes easily from one activity to another.
     * It might be necessary in the future.
     * @param in the parcelable object.
     */
    @SuppressWarnings("unchecked")
    public ComboParcel(Parcel in) {
        this.setComboAlias(in.readString());
        this.setName(in.readString());
        this.setCost(new BigDecimal(in.readString()));
        this.setComboItems(in.readArrayList(ClassLoader.getSystemClassLoader()));
        this.setHours(((AvailableHoursParcel)in.readParcelable(AvailableHoursParcel.class.getClassLoader())));
    }

    /**
     * This is the method necessary to recreate an object after it has been parceled.
     */
    public static final Parcelable.Creator<Combo> CREATOR
            = new Parcelable.Creator<Combo>() {
        public Combo createFromParcel(Parcel in) {
            return new ComboParcel(in);
        }

        public Combo[] newArray(int size) {
            return new Combo[size];
        }
    };

    /**
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @param out
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(getComboAlias());
        out.writeString(getName());
        out.writeString(getCost().toString());
        out.writeList(getComboItems());
        out.writeParcelable((AvailableHoursParcel)(getHours()), 0);
    }
}
