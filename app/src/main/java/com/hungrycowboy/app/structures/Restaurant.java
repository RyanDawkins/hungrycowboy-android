package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 5/25/14
 */
public class Restaurant implements Parcelable {

    private String name;
    private Address address;
    private ArrayList<FoodItem> foodItems;
    private ArrayList<Combo> combos;
    private AvailableHours openHours;

    /**
     *  Default Constructor
     */
    public Restaurant() {
    }

    /**
     *
     * @param name
     * @param address
     * @param openHours
     */
    public Restaurant(String name, Address address, AvailableHours openHours) {
        this.name = name;
        this.address = address;
        this.openHours = openHours;
    }

    /**
     *
     * @param name
     * @param address
     * @param foodItems
     * @param openHours
     */
    public Restaurant(String name, Address address, ArrayList<FoodItem> foodItems, AvailableHours openHours) {
        this.name = name;
        this.address = address;
        this.foodItems = foodItems;
        this.openHours = openHours;
    }

    /**
     *
     * @param name
     * @param address
     * @param openHours
     * @param combos
     */
    public Restaurant(String name, Address address, AvailableHours openHours, ArrayList<Combo> combos) {
        this.name = name;
        this.address = address;
        this.openHours = openHours;
        this.combos = combos;
    }

    /**
     *
     * @param name
     * @param address
     * @param foodItems
     * @param combos
     * @param openHours
     */
    public Restaurant(String name, Address address, ArrayList<FoodItem> foodItems, ArrayList<Combo> combos, AvailableHours openHours) {
        this.name = name;
        this.address = address;
        this.foodItems = foodItems;
        this.combos = combos;
        this.openHours = openHours;
    }

    /**
     *
     * @param in
     */
    public Restaurant(Parcel in) {
        name = in.readString();
        address = (Address) in.readValue(Address.class.getClassLoader());
        if (in.readByte() == 0x01) {
            foodItems = new ArrayList<FoodItem>();
            in.readList(foodItems, FoodItem.class.getClassLoader());
        } else {
            foodItems = null;
        }
        if (in.readByte() == 0x01) {
            combos = new ArrayList<Combo>();
            in.readList(combos, Combo.class.getClassLoader());
        } else {
            combos = null;
        }
        openHours = (AvailableHours) in.readValue(AvailableHours.class.getClassLoader());
    }

    /**
     *
     */
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * @return
     */
    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * @return
     */
    public Restaurant setAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     *
     * @return
     */
    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     *
     * @param foodItems
     * @return
     */
    public Restaurant setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
        return this;
    }

    /**
     *
     * @return
     */
    public ArrayList<Combo> getCombos() {
        return combos;
    }

    /**
     *
     * @param combos
     * @return
     */
    public Restaurant setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
        return this;
    }

    /**
     *
     * @return
     */
    public AvailableHours getOpenHours() {
        return openHours;
    }

    /**
     *
     * @param openHours
     * @return
     */
    public Restaurant setOpenHours(AvailableHours openHours) {
        this.openHours = openHours;
        return this;
    }

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
        out.writeString(name);
        out.writeValue(address);
        if (foodItems == null) {
            out.writeByte((byte) (0x00));
        } else {
            out.writeByte((byte) (0x01));
            out.writeList(foodItems);
        }
        if (combos == null) {
            out.writeByte((byte) (0x00));
        } else {
            out.writeByte((byte) (0x01));
            out.writeList(combos);
        }
        out.writeValue(openHours);
    }
}
