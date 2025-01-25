package org.example.practical.libraryManagementSystem;

public class Magazine extends ItemType{
    public Magazine(String title, String author, String serialNumber) {
        super(title, author, serialNumber);
    }

    @Override
    public void borrowedItem(User user) {

        if(isBorrowed){
            System.out.println("This magazine is already borrowed.");
        }else {
            isBorrowed=true;
            System.out.println("This magazine successfully borrowed by "+user.getUsername()); //System.out.printf("This magazine successfully borrowed by  %s", user.getUsername());
        }
    }

    @Override
    public void returnItem(User user) {
        if (isBorrowed){
            isBorrowed=false;
            System.out.println("This magazine is returned by "+user.getUsername());
        }else {
            System.out.println("No magazine to return");
        }
    }
}
