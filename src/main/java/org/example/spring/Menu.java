package org.example.spring;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать");
        try {
            Authorization.begin();
        } catch (CustomerException e) {
            throw new RuntimeException(e);
        }
        int idNum;
        //idNum = Authorization.begin(user);
        //Game.choice(idNum, user);


    }
}








