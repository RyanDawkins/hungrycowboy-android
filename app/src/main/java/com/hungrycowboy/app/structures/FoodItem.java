package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * This class represents a single food item.
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 05/25/2014
 */
public class FoodItem {

    private String name;
    private String description;
    private BigDecimal cost;

    /**
     * Default Constructor
     */
    public FoodItem() {}

    /**
     * Constructor used for foods without description or cost
     * @param name the name of the food
     */
    public FoodItem(String name) {
        this.name = name;
    }

    /**
     * Constructor used for foods without description
     * @param name the name of the food
     * @param cost the cost of the food
     */
    public FoodItem(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * This constructor is used for foods that the price vary or is unknow.
     * @param name the name of the food
     * @param description the description of the food item
     */
    public FoodItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor that takes all the parameters
     * @param name the name of the food
     * @param description the description of the food item
     * @param cost the cost of the food
     */
    public FoodItem(String name, String description, BigDecimal cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
    @Override
    public String toString() {
        return name + "\n" + cost + "\n" + description;
    }
}
