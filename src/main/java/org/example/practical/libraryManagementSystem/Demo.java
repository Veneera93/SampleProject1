package org.example.practical.libraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static final String LIBRARY_ITEM_FILE = "libItems.lms";
    private static final String USERS_FILE = "users.lms";
    private static final String BORROWED_ITEM_FILE = "borrowedItems.lms";
    static BufferedReader br;
    static Library library;

    public static void main(String[] args) throws IOException {
        library = new Library();

        System.out.println("Load Library Items");
//        List<ItemType> libraryItems = LibraryIO.loadItems(LIBRARY_ITEM_FILE);
        library.addItemList(LibraryIO.loadItems(LIBRARY_ITEM_FILE));
        library.getLibraryItems().forEach(itemType -> {
            System.out.println("Title: " + itemType.getTitle() + " - Serial Number: " + itemType.getSerialNumber());
        });
        System.out.println(" ----------------------------------------");

        System.out.println("Load Users");
        library.addUserList(LibraryIO.loadUsers(USERS_FILE));
        library.getUsers().forEach(user -> {
            System.out.println(user.getUsername());
        });

        System.out.println(" ----------------------------------------");

        System.out.println("Load Borrowed Items");
        library.addBorrowedItems(LibraryIO.loadBorrowedItems(BORROWED_ITEM_FILE));// Load borrowed items into the library
        library.getBorrowedItems().forEach((serialNumber, username) -> {// Iterate over the borrowed items map
            System.out.println("Item " + serialNumber + " is borrowed by " + username);
        });

        System.out.println(" ----------------------------------------");


        br = new BufferedReader((new InputStreamReader((System.in))));
        boolean exit = false;

        while (!exit) {

            System.out.println("Choose an option");
            System.out.println("1. Create an user");
            System.out.println("2. Create an item");
            System.out.println("3. Borrow an item");
            System.out.println("4. Return an item");
            System.out.println("5. Exit");


            //use switch case
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createItem();
                    break;
                case 3:
                    borrowItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter number between 1 to 5");

            }

        }
    }

    private static void returnItem() throws IOException {
        System.out.println("Give Serial Number of the Item to return");
        String serialNumber = br.readLine();

        library.returnBorrowedItem(serialNumber);
        LibraryIO.saveBorrowedItems(library.getBorrowedItems(), BORROWED_ITEM_FILE);
    }

    private static void borrowItem() throws IOException {
        System.out.println("Give Serial Number of the Item");
        String serialNumber = br.readLine();
        System.out.println("Give username");
        String username = br.readLine();

        library.borrowItemByUser(serialNumber, username);
        LibraryIO.saveBorrowedItems(library.getBorrowedItems(), BORROWED_ITEM_FILE);
    }

    private static void createItem() throws IOException {
        System.out.println("Give Title of the Item");
        String title = br.readLine();
        System.out.println("Give Author of the Item");
        String author = br.readLine();
        System.out.println("Give Serial Number of the Item");
        String serialNumber = br.readLine();
        library.addItem(new Book(title, author, serialNumber));
        LibraryIO.saveItems(library.getLibraryItems(), LIBRARY_ITEM_FILE);
    }

    public static void createUser() throws IOException {
        System.out.println("What is the username");
        String username = br.readLine();
        System.out.println("What is the NIC");
        String nic = br.readLine();
        library.addUser(new User(username, nic));
        LibraryIO.saveUsers(library.getUsers(), USERS_FILE);

    }
}


//        ItemType book1 = new Book("Book1", "1", "Serial1");
//        library.addItem(book1);
//        List<ItemType> libraryItems = library.getLibraryItems();
//
//        for (ItemType item : libraryItems) {
//            System.out.println(item.getTitle());
//        }
//
//        User user1 = new User("Jack", "715243");
//        library.addUser(user1);
/// /        User user2 = new User("B", "NIC");
/// /        book1.borrowedItem(user1);
/// /        book1.borrowedItem(user2);
/// /
/// /        book1.returnItem(user1);
/// /        book1.returnItem(user2);
//
//        library.borrowItemByUser(book1.getSerialNumber(), user1.getUsername());
//        library.returnBorrowedItem(book1.getSerialNumber());

//
//    }
//}

//        library.borrowItemByUser(book1,user1);


//        book1.borrowedItem(user2);
//


//        User user1=new User("A","NIC");
//        User user2=new User("B","NIC");
//        User user3=new User("C","NIC");
//        library.addUser(user1);
//        library.addUser(user2);
//        library.addUser(user3);
//        List<User> users = library.getUsers();
//
//        for (User user: users){
//            System.out.println(user.getUsername());
//        }
//
//        System.out.println("===============Read========================");
//
//        User b = library.getUserByUsername("B");
//        System.out.println(b.getUsername());
//
//        System.out.println("===============Delete========================");
//
//        users.remove(b);
//        for (User user: users){
//            System.out.println(user.getUsername());
//        }
//
//        System.out.println("=============Update==========================");
//
//        User c = library.getUserByUsername("C");
//        System.out.println(c.getUsername());
//        c.setUsername("CC");
//        System.out.println(c.getUsername());
//
//        for (User user: users){
//            System.out.println(user.getUsername());
//        }
