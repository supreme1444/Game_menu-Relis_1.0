package org.example.spring;

import java.util.List;
import java.util.Scanner;

public class RPS {
    public static void start(int idNum, String nickname) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выбирайте 1)Камень 2)Ножницы 3)Бумага 4)Выход в меню");
            Player bot = new Player();
            int choise = scanner.nextInt();
            if (choise == 1) {
                Player alex = new Player(Player.VARIANTS.ROCK, nickname);
                System.out.println(bot.whoWin(bot, alex));
                int result = bot.whoWin(bot, alex);
                System.out.println(res(result, idNum, nickname));
            } else if (choise == 2) {
                Player alex = new Player(Player.VARIANTS.SCISSORS, nickname);
                System.out.println(bot.whoWin(bot, alex));
                int result = bot.whoWin(bot, alex);
                System.out.println(res(result, idNum, nickname));
            } else if (choise == 3) {
                Player alex = new Player(Player.VARIANTS.PAPER, nickname);
                System.out.println(bot.whoWin(bot, alex));
                int result = bot.whoWin(bot, alex);
                System.out.println(res(result, idNum, nickname));
            } else if (choise == 4) {
                break;
            } else if (choise > 4 || choise < 0) {
                System.out.println("Введите верное значение");
                break;
            }
        }

    }

    public static int res(int r, int idNum, String nickname) {

        if (r == 1) {
            System.out.println("Ничья");
        }
        if (r == 2) {
            System.out.println("Проиграл");
        }
        if (r == 3) {
            System.out.println("Победа");
            int guessTNScore = 2;
            File.SummCount(idNum, nickname, guessTNScore);
            return 1;
        }
        return 0;
    }
}
