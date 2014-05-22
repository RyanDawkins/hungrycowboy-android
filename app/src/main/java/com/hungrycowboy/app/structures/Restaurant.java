package com.hungrycowboy.app.structures;

/**
 * The restaurant class is a class file to hold the basic structure for all structures that
 * hold this sort of data
 *
 * @author  Ryan Dawkins
 * @since   0.1
 */
public class Restaurant {

    private String name;
    private Address address;
    private FoodMenu[] menus;
    private OpenHours openHours;

    /**
     * Just a blank constructor since there's no necessary data to be added yet..
     */
    public Restaurant() {
    }

    /**
     * Chainable setter method to set the name of the Restaurant object
     * Example of usage:
     *      Restaurant sonic = new Restaurant();
     *      String name = sonic.set_name("Sonic").get_name();
     *
     * @param   name    The name of the Restaurant object, should be the name they advertise
     * @return          Returns a reference to the object for chainability
     */
    public Restaurant set_name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A simple getter method for the private member variable name
     *
     * @return          Returns a string reference to the member variable name
     */
    public String get_name() {
        return this.name;
    }

    /**
     * Chainable setter method to set the address
     *
     * @param   address The legal address of the restaurant
     * @return          Returns a reference to the object
     */
    public Restaurant set_address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Getter for the address member variable
     *
     * @return          Returns the member variable address
     */
    public Address get_address() {
        return this.address;
    }

    /**
     * Chainable setter for the FoodMenu array
     *
     * @param   menus   This should be a collection of menus that can depend
     *                  on the time of day.
     * @return          Returns a reference to the object
     */
    public Restaurant set_menus(FoodMenu[] menus) {
        this.menus = menus;
        return this;
    }

    /**
     * Getter for the menus member variable
     *
     * @return          Returns the members variable reference
     */
    public FoodMenu[] get_menus() {
        return this.menus;
    }

    /**
     * Returns a reference to the open hours array
     *
     * @param   openHours   This array should contain all open hours that the restaurant is open.
     * @return              Returns a reference to the object
     */
    public Restaurant set_open_hours(OpenHours openHours) {
        this.openHours = openHours;
        return this;
    }

    /**
     * Returns reference to all of the open hours the restaurant has
     *
     * @return @param       Returns an array of all open hours
     */
    public OpenHours get_open_hours() {
        return this.openHours;
    }
}
