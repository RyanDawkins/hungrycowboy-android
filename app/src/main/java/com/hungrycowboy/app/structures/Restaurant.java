package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 5/25/14
 */
public class Restaurant {

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

}
