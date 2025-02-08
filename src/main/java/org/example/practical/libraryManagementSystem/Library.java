package org.example.practical.libraryManagementSystem;

import java.util.*;

public class Library {

    List<ItemType> libraryItems = new ArrayList<>();
    List<User> users = new ArrayList<>();
    Map<String, String> borrowedItem = new HashMap<>();

    public void addItem(ItemType libraryItem) {
        libraryItems.add(libraryItem);
    }

    public void addItemList(List<ItemType> libraryItemList) {
        this.libraryItems.addAll(libraryItemList);
    }

    public List<ItemType> getLibraryItems() {
        return libraryItems;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addUserList(List<User> userList) {
        this.users.addAll(userList);
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, String> getBorrowedItems() {
        return borrowedItem;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println(user.getUsername());
                return user;
            }
        }
        return null;
    }

    public void borrowItemByUser(String serialNumber, String username) {

        if (!isValidItem(serialNumber)) {
            System.out.println("Not a valid serial number");
            return;
        }

        if (isItemAlreadyBorrowed(serialNumber)) {
            System.out.println("Item with serial number "+serialNumber+" is already borrowed");
            return;
        }

        if (!isValidUser(username)) {
            System.out.println("User is not valid user");
            return;
        }

        borrowedItem.put(serialNumber, username);
        System.out.println(username + " is successfully borrow the item:" + serialNumber);
    }

    public void addBorrowedItems(Map<String, String> borrowedItems) {
        this.borrowedItem.putAll(borrowedItems);
    }

//    public void borrowItemByUser(ItemType serialNumber, User username) {
    //        User userByUsername = getUserByUsername(user.getUsername());
//        if(Objects.nonNull(userByUsername)) {
//            if (serialNumber.isBorrowed) {
//                System.out.println("This cannot borrow for user");
//            } else {
//                borrowedItem.put(item.getTitle(), user.getUsername());
//                item.borrowedItem(user);
//            }
//        }else{
//            System.out.println("User is not a valid user");
//        }
//}

    public void returnBorrowedItem(String serialNumber) {

        if (borrowedItem.containsKey(serialNumber)) {
            String username = borrowedItem.remove(serialNumber);
            System.out.println(serialNumber + " book is returned by" + username);
        } else {
            System.out.println(serialNumber + " is not exist in borrowed list or not valid number.");
        }
    }

    /**
     * @param serialNumber
     * @return true if valid
     */
    //used stream API, this method body same as getUserByUsername() method
    private boolean isValidItem(String serialNumber) {
        return libraryItems.stream().filter(item -> item.getSerialNumber().equals(serialNumber)).count() == 1;

    }

    /**
     * it return true if user valid
     *
     * @param username
     * @return
     */
    private boolean isValidUser(String username) {

        return users.stream().filter(user -> user.getUsername().equals(username)).count() == 1;

    }

    /**
     * if item already borrowed it return true
     *
     * @param serialNumber
     * @return
     */

    private boolean isItemAlreadyBorrowed(String serialNumber) {
        return borrowedItem.containsKey(serialNumber);
    }


}