package org.example.practical.libraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryIO {

    /**
     * Save items to file
     *
     * @param libraryItems
     * @param fileName
     * @throws IOException
     */
    public static void saveItems(List<ItemType> libraryItems, String fileName) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(libraryItems);
        }
    }

    /**
     * Get item list from file
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<ItemType> loadItems(String fileName) throws IOException {

        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<ItemType>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Save users to file
     *
     * @param users
     * @param fileName
     * @throws IOException
     */
    public static void saveUsers(List<User> users, String fileName) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
        }
    }

    /**
     * Get user list from file
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<User> loadUsers(String fileName) throws IOException {

        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<User>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Save borrowed items to file
     *
     * @param borrowedItems
     * @param fileName
     * @throws IOException
     */
    public static void saveBorrowedItems(Map<String, String> borrowedItems, String fileName) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(borrowedItems);
        }
    }

    /**
     * Read borrowed items
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Map<String, String> loadBorrowedItems(String fileName) throws IOException {

        File file = new File(fileName);
        if (!file.exists()) {
            return new HashMap<String, String>();

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object readObject = ois.readObject();
            // Check if the deserialized object is indeed a Map
            if (readObject instanceof Map) {
                return (Map<String, String>) readObject;
            } else {
                System.out.println("Data format mismatch: expected a Map but found " + readObject.getClass());
                return new HashMap<>();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
