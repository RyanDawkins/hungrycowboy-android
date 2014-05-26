package com.hungrycowboy.app.adapter.parcel;

import android.os.Parcel;
import android.os.Parcelable;

import com.hungrycowboy.app.structures.Address;
import com.hungrycowboy.app.structures.AvailableHours;
import com.hungrycowboy.app.structures.Combo;
import com.hungrycowboy.app.structures.FoodItem;
import com.hungrycowboy.app.structures.Restaurant;

import java.util.ArrayList;

/**
 * Created by dawkins on 5/25/14.
 */
public class RestaurantParcel extends Restaurant implements Parcelable{

    /**
     *
     * @param in
     */
    public RestaurantParcel(Parcel in) {
        this.setName(in.readString());
        this.setAddress((Address) in.readValue(Address.class.getClassLoader()));
        if (in.readByte() == 0x01) {
            this.setFoodItems(new ArrayList<FoodItem>());
            in.readList(this.getFoodItems(), FoodItem.class.getClassLoader());
        } else {
            this.setFoodItems(null);
        }
        if (in.readByte() == 0x01) {
            this.setCombos(new ArrayList<Combo>());
            in.readList(this.getCombos(), Combo.class.getClassLoader());
        } else {
            this.setCombos(null);
        }
        this.setOpenHours((AvailableHours) in.readValue(AvailableHours.class.getClassLoader()));
    }

    /**
     *
     */
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new RestaurantParcel(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
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
        out.writeString(getName());
        out.writeValue(getAddress());
        if (getFoodItems() == null) {
            out.writeByte((byte) (0x00));
        } else {
            out.writeByte((byte) (0x01));
            out.writeList(getFoodItems());
        }
        if (getCombos() == null) {
            out.writeByte((byte) (0x00));
        } else {
            out.writeByte((byte) (0x01));
            out.writeList(getCombos());
        }
        out.writeValue(getOpenHours());
    }

}
