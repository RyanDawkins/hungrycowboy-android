package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents a single address from a restaurant
 * @author Marcus Gabilheri
 * @author Ryan Dawkins
 * @version 1.0
 * @since 5/24/2014
 */
public class Address {

    private String addressLineOne, addressLineTwo, postalCode, city, state, country, university, building;
    private double latitude, longitude; // For future use with Google Maps integration

    /**
     * Empty constructor
     */
    public Address() {
    }

    /**
     *  Constructor that takes all the parameters
     * @param addressLineOne *required* addresses should have at least this first address
     * @param addressLineTwo *optional* not necessary, can be used to specify special case address
     * @param postalCode the zip code
     * @param city city where the restaurant is located
     * @param state the state where the restaurant is located
     * @param country the country where the restaurant is located
     * @param university *optional* if is inside a university is always good specify
     * @param building *optional* if is inside an university a building must be provided for a better description for the user.
     */
    public Address(String addressLineOne, String addressLineTwo, String postalCode,
                   String city, String state, String country, String university, String building) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.university = university;
        this.building = building;
    }

    /**
     * Constructor that can be used along with Google Maps integration.
     * With the latitude and longitude Google Maps API is able to generate an address
     * @param latitude the latitude point
     * @param longitude the longitude point
     */
    public Address(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    public Address setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    /**
     *
     * @return
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     *
     * @param addressLineTwo
     */
    public Address setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        return this;
    }

    /**
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public Address setState(String state) {
        this.state = state;
        return this;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     *
     * @return
     */
    public String getUniversity() {
        return university;
    }

    /**
     *
     * @param university
     */
    public Address setUniversity(String university) {
        this.university = university;
        return this;
    }

    /**
     *
     * @return
     */
    public String getBuilding() {
        return building;
    }

    /**
     *
     * @param building
     * @return
     */
    public Address setBuilding(String building) {
        this.building = building;
        return this;
    }

    /**
     *
     * @return
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * @return
     */
    public Address setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     *
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * @return
     */
    public Address setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

}
