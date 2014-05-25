package com.hungrycowboy.app.structures;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents a single address from a restaurant
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 5/24/2014
 */
public class Address implements Parcelable {

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
     * The order of the parcel in is VERY important.
     * Should ALWAYS be in the same order as the parcel out
     * @param in the parcelable object.
     */
    public Address(Parcel in) {
        this.addressLineOne = in.readString();
        this.addressLineTwo = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.postalCode = in.readString();
        this.country = in.readString();
        this.university = in.readString();
        this.building = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    /**
     *
     */
    public static final Parcelable.Creator<Address> CREATOR
            = new Parcelable.Creator<Address>() {
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    /**
     *
     * @return
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
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
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
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
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
    public void setCity(String city) {
        this.city = city;
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
    public void setState(String state) {
        this.state = state;
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
    public void setCountry(String country) {
        this.country = country;
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
    public void setUniversity(String university) {
        this.university = university;
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getAddressLineOne() + "\n" + getAddressLineTwo() + "\n" + getCity() + ", " + getState() + "\n"
                + getPostalCode() + ", " + getCountry();
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
        out.writeString(getAddressLineOne());
        out.writeString(getAddressLineTwo());
        out.writeString(getCity());
        out.writeString(getState());
        out.writeString(getPostalCode());
        out.writeString(getCountry());
        out.writeString(getUniversity());
        out.writeString(getBuilding());
        out.writeDouble(getLatitude());
        out.writeDouble(getLongitude());

    }
}
