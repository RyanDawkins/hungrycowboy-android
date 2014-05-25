package com.hungrycowboy.app.adapter.parcel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class to deal with Parceable objects
 *
 * @author Ryan Dawkins
 */
public class Address extends com.hungrycowboy.app.structures.Address implements Parcelable {

    /**
     * Deeply copies the parent class to the sub class
     * @param parentObj
     */
    public Address(com.hungrycowboy.app.structures.Address parentObj) {
        this.setAddressLineOne(parentObj.getAddressLineOne())
                .setAddressLineTwo(parentObj.getAddressLineTwo())
                .setCity(parentObj.getCity())
                .setState(parentObj.getState())
                .setPostalCode(parentObj.getPostalCode())
                .setCountry(parentObj.getCountry())
                .setUniversity(parentObj.getUniversity())
                .setBuilding(parentObj.getBuilding())
                .setLatitude(parentObj.getLatitude())
                .setLongitude(parentObj.getLongitude());
    }

    /**
     * The order of the parcel in is VERY important.
     * Should ALWAYS be in the same order as the parcel out
     * @param in the parcelable object.
     */
    public Address(Parcel in) {
        this.setAddressLineOne(in.readString())
                .setAddressLineTwo(in.readString())
                .setCity(in.readString())
                .setState(in.readString())
                .setPostalCode(in.readString())
                .setCountry(in.readString())
                .setUniversity(in.readString())
                .setBuilding(in.readString())
                .setLatitude(in.readDouble())
                .setLongitude(in.readDouble());
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

}
