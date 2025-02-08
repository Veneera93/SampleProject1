package org.example.practical.libraryManagementSystem;

public class Book extends ItemType {
    public Book(String title, String author, String serialNumber) {
        super(title, author, serialNumber);//call parent class constructor
    }

    @Override
    public void borrowedItem(User user) {

        if (isBorrowed){
            System.out.println("This book is already borrowed");
        }else {
            isBorrowed=true;
            System.out.println("This item successfully borrowed by "+user.getUsername());
        }

    }

    @Override
    public void returnItem(User user) {
        if (isBorrowed){
            isBorrowed=false;
            System.out.println("This book is returned by "+user.getUsername());
        }else {
            System.out.println("No books to return");
        }
    }
}
