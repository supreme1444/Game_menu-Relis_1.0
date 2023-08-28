package org.example.spring;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать");
        try {
            Authorization.begin();
        } catch (CustomerException e) {
            throw new RuntimeException(e);
        }
    }
}








