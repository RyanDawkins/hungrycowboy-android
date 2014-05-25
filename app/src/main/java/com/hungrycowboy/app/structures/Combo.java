package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.hungrycowboy.app.adapter.parcel.AvailableHoursParcel;

/**
 * This data structure contains various food items with it's cost, as well as when it is available.
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 05/24/2014
 */
public class Combo {

    private String comboAlias, name;
    private ArrayList<FoodItem> comboItems;
    private BigDecimal cost;
    private AvailableHoursParcel hours;

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
    public Combo(String comboAlias, String name, ArrayList<FoodItem> comboItems, AvailableHoursParcel hours) {
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
     *
     * @param comboAlias
     * @param name
     * @param comboItems
     * @param cost
     * @param hours
     */
    public Combo(String comboAlias, String name, ArrayList<FoodItem> comboItems, BigDecimal cost, AvailableHoursParcel hours) {
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
     */
    public void setComboAlias(String comboAlias) {
        this.comboAlias = comboAlias;
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
     */
    public void setName(String name) {
        this.name = name;
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
     */
    public void setComboItems(ArrayList<FoodItem> comboItems) {
        this.comboItems = comboItems;
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
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     *
     * @return
     */
    public AvailableHoursParcel getHours() {
        return hours;
    }

    /**
     *
     * @param hours
     */
    public void setHours(AvailableHoursParcel hours) {
        this.hours = hours;
    }
}
