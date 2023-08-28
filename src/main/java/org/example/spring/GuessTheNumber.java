package org.example.spring;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    public static void inputNumber(int id, String nickname) {
        boolean inputIsValid = false;

        do {
            System.out.println("Привет " + nickname + " смысл игры угадать цифру из намеченного вами числа");
            System.out.println("Выберите максимальное число из которого вы будете выбирать");
            int digitFortuna = scan.nextInt();

            if (digitFortuna < 2) {
                System.out.println("Вы ввели не верные данные.Введите цифру больше 2");
            } else {
                inputIsValid = true;
                int i = digitN(digitFortuna);
                game(i, digitFortuna, id, nickname);
            }

        } while (!inputIsValid);

    }

    public static int digitN(int N) {
        int i = 0;
        while (true) {
            if (Math.pow(2, i) >= N) {
                return i;
            }
            i++;
        }
    }

    public static void game(int i, int N, int id, String nickname) {
        int attempt = i;
        int num = rand.nextInt(N);
        System.out.println("У вас " + i + "попыток.Удачи");
        try {
            while (0 < attempt) {
                System.out.println("Введите число");
                int digitFortuna = scan.nextInt();
                if (digitFortuna > N || digitFortuna < 0) {
                    System.out.println("Вы ввели не верное число");
                } else {
                    if (attempt > 0) {
                        if (digitFortuna < num) {
                            attempt--;
                            System.out.println("Ваша цифра меньше заданного, у вас осталось " + attempt + " попыток");
                        } else if (digitFortuna > num) {
                            attempt--;
                            System.out.println("Ваша цифра больше заданного, у вас осталось " + attempt + " попыток");
                        } else {
                            System.out.println("Вы победили");
                            int guessTNScore = 1;
                            File.SummCount(id, nickname, guessTNScore);
                            break;
                        }
                    }
                }
                if (attempt == 0) {
                    System.out.println("Вы проиграли, загаданное число было " + num);
                }
            }
        } catch (Exception e) {
            System.out.println("Введите число а не букву");
        }
    }
}

