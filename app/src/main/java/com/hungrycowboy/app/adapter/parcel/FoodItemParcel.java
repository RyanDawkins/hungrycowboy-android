package com.hungrycowboy.app.adapter.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import com.hungrycowboy.app.structures.FoodItem;

import java.math.BigDecimal;

/**
 * Created by dawkins on 5/25/14.
 */
public class FoodItemParcel extends FoodItem implements Parcelable {

    /**
     * Constructor necessary for the Parcelable implementation.
     * Parcelable allows this object to be passes easily from one activity to another.
     * It might be necessary in the future.
     * @param in the parcelable object.
     */
    public FoodItemParcel(Parcel in) {
        this.setName(in.readString());
        this.setDescription(in.readString());
        this.setCost(new BigDecimal(in.readString()));
    }

    /**
     * This is the method necessary to recreate an object after it has been parceled.
     */
    public static final Parcelable.Creator<FoodItem> CREATOR
            = new Parcelable.Creator<FoodItem>() {
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItemParcel(in);
        }

        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
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
     * Method that will create the parcelable object
     * @param out the parcelable object
     * @param flags I have no idea for what this is used.
     */
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(getName());
        out.writeString(getDescription());
        out.writeString(getCost().toString());
    }

}
