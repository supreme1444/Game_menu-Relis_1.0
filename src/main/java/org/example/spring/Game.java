package org.example.spring;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static void choice(int idNum, String nickname) {
        //Выбор игры
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("В какую игру " + nickname + " вы хотите поиграть?");
            System.out.println("1) Камень, Ножницы, Бумага 2)Угадай число 3)(Пока не реализовано)морской бой 4)Выход");
            int choice = scanner.nextInt();
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                if (choice == 1) {
                    RPS.start(idNum, nickname);
                }
                if (choice == 2) {
                    GuessTheNumber.inputNumber(idNum, nickname);
                }
                //Еще не готово.
//                if (choice == 3) {
//                    RPS.start(idNum, user, nickname);
//                }
                if (choice == 4) {
                    System.out.println("До новой игры");
                    break;

                }
            } else {
                System.out.println("Повторить ввод");
            }
        }
    }
}

