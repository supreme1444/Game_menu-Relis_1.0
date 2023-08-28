package org.example.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authorization {
    static Scanner scan = new Scanner(System.in);
    static List<User> user = new ArrayList<>();

    public static void begin() throws CustomerException {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Нажмите 1 'Зайти под профилем' или Нажмите 0 что бы 'создать новый.'?");
            int choice = scan.nextInt();
            //Проверка зарегистрированного пользователя.
            if (choice == 1) {
                System.out.println("Введите свой 'nicknames'");
                String nick = scan.next();
                int checkUser = File.checkUser(nick);
                if (checkUser >= 0) {
                    System.out.println("Добро пожаловать " + nick);
                    Game.choice(checkUser, nick);
                }
            }
            if (choice == 0) {
                begin(user);
            } else {
                System.out.println("Такого пользователя нет,войдите заново");
            }

        } catch (Exception e) {
            System.out.println("Вводите цифры.Попробуйте заново.");
        }
        //Регистрация пользователя.

    }

    public static void begin(List<User> list) {
        

            int userId;
            System.out.println("Введите имя и никнейм.");
            int checkId = File.distributor(user);
            if (checkId == 1) { //1 = это пустой список.
                userId = 0;
                list.add(new User(userId, scan.next(), scan.next(), 0, 0));
                System.out.println("Ваш id = " + userId);
                int i = 0;
                String nicknamesSize = list.get(i).nicknames;
                File.writer(list);
                Game.choice(userId, nicknamesSize);
            } else if (checkId == 2) { //2 = это заполненный список.
                userId = File.checkId();
                userId = userId + 1;
                System.out.println("Ваш id номер " + userId);
                list.add(new User(userId, scan.next(), scan.next(), 0, 0));
                System.out.println(list);
                int i = 0;
                String nicknamesSize = list.get(i).nicknames;
                System.out.println(nicknamesSize);
                File.writer(list);
                Game.choice(userId, nicknamesSize);
            }
        }
    }


