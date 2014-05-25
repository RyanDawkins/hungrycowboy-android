package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This data structure contains various food items with it's cost, as well as when it is available.
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 05/24/2014
 */
public class Combo implements Parcelable {

    private String comboAlias, name;
    private ArrayList<FoodItem> comboItems;
    private BigDecimal cost;
    private AvailableHours hours;

    /**
     *
     */
    public Combo() {
    }

    /**
     *
     * @param name
     * @param comboItems
     */
    public Combo(String name, ArrayList<FoodItem> comboItems) {
        this.name = name;
        this.comboItems = comboItems;
    }

    /**
     *
     * @param comboAlias
     * @param name
     * @param comboItems
     * @param hours
     */
    public Combo(String comboAlias, String name, ArrayList<FoodItem> comboItems, AvailableHours hours) {
        this.comboAlias = comboAlias;
        this.name = name;
        this.comboItems = comboItems;
        this.hours = hours;
    }

    /**
     *
     * @param name
     * @param cost
     */
    public Combo(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Constructor necessary for the Parcelable implementation.
     * Parcelable allows this object to be passes easily from one activity to another.
     * It might be necessary in the future.
     * @param in the parcelable object.
     */
    @SuppressWarnings("unchecked")
    public Combo(Parcel in) {
        this.comboAlias = in.readString();
        this.name = in.readString();
        this.cost = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
        this.comboItems = in.readArrayList(FoodItem.class.getClassLoader());
        this.hours = in.readParcelable(AvailableHours.class.getClassLoader());
    }

    /**
     * This is the method necessary to recreate an object after it has been parceled.
     */
    public static final Parcelable.Creator<Combo> CREATOR
            = new Parcelable.Creator<Combo>() {
        public Combo createFromParcel(Parcel in) {
            return new Combo(in);
        }

        public Combo[] newArray(int size) {
            return new Combo[size];
        }
    };

    /**
     *
     * @param comboAlias
     * @param name
     * @param comboItems
     * @param cost
     * @param hours
     */
    public Combo(String comboAlias, String name, ArrayList<FoodItem> comboItems, BigDecimal cost, AvailableHours hours) {
        this.comboAlias = comboAlias;
        this.name = name;
        this.comboItems = comboItems;
        this.cost = cost;
        this.hours = hours;
    }

    /**
     *
     * @return
     */
    public String getComboAlias() {
        return comboAlias;
    }

    /**
     *
     * @param comboAlias
     * @return
     */
    public Combo setComboAlias(String comboAlias) {
        this.comboAlias = comboAlias;
        return this;
    }

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
    public Combo setName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     */
    public ArrayList<FoodItem> getComboItems() {
        return comboItems;
    }

    /**
     *
     * @param comboItems
     * @return
     */
    public Combo setComboItems(ArrayList<FoodItem> comboItems) {
        this.comboItems = comboItems;
        return this;
    }

    /**
     *
     * @return
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     * @return
     */
    public Combo setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    /**
     *
     * @return
     */
    public AvailableHours getHours() {
        return hours;
    }

    /**
     *
     * @param hours
     * @return
     */
    public Combo setHours(AvailableHours hours) {
        this.hours = hours;
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
        out.writeString(getComboAlias());
        out.writeString(getName());
        out.writeValue(getCost());
        out.writeList(getComboItems());
        out.writeParcelable(getHours(), 0);
    }
}
