package com.hungrycowboy.app.structures;
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
    public Combo setHours(AvailableHoursParcel hours) {
        this.hours = hours;
        return this;
    }
}
