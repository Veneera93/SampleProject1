package org.example.practical.libraryManagementSystem;

import java.io.Serializable;

public abstract class ItemType implements Serializable {

    private String title;
    private String author;
    private String serialNumber;
    protected Boolean isBorrowed;

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public ItemType(String title, String author, String serialNumber) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.isBorrowed=false;
    }

    public abstract void borrowedItem(User user);
    public abstract void returnItem(User user);

}
