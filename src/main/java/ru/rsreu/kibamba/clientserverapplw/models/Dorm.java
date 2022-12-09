package ru.rsreu.kibamba.clientserverapplw.models;

public class Dorm {
    private int id;
    private String address;
    private int numberLivingRooms;

    public Dorm(int id, String address, int numberLivingRooms){
        this.id = id;
        this.address = address;
        this.numberLivingRooms = numberLivingRooms;
    }
    public Dorm(){}

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberLivingRooms() {
        return numberLivingRooms;
    }

    public void setNumberLivingRooms(int numberLivingRooms) {
        this.numberLivingRooms = numberLivingRooms;
    }

    public int getId() {
        return id;
    }

}
