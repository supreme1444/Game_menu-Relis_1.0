package org.example.spring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {

    //Проверка не пустой ли файл
    public static int distributor(List<User> list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("player_base.txt"));
            if (br.readLine() == null) {
                return 1;
            } else {
                return 2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Заброс в файл инфы
    public static void writer(List<User> list) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("player_base.txt",true), "UTF-8"))) {
            writer.write(list.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Проверка на есть ли user в базе.
    public static int checkUser(String user) {
        String fileName = "player_base.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] lineList = line.split(";");
                String searchnick = "nicknames=";
                String endCharnick = ",";
                String searchId = "User(id=";
                String endCharId = ",";
                for (int i = 0; i < lineList.length; i++) {
                    if (lineList[i].contains(searchnick)) {
                        int startIndex = lineList[i].indexOf(searchnick) + searchnick.length();
                        int endIndex = lineList[i].indexOf(endCharnick, startIndex);
                        String resultString = lineList[i].substring(startIndex, endIndex);
                        if (user.equals(resultString)) {
                            int startIndexId = lineList[i].indexOf(searchId) + searchId.length();
                            int endIndexId = lineList[i].indexOf(endCharId, startIndexId);
                            int resultStringId = Integer.parseInt(lineList[i].substring(startIndexId, endIndexId));

                            return resultStringId;
                        }
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return -1;
    }

    //Присваивание id
    public static int checkId() {
        String line;
        int maxIdNumer = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("player_base.txt"));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] lineList = line.split(";");
                String str = "User(id=";
                String endChar = ",";
                int intIdNumer = 0;
                //System.out.println(lineList);
                for (int i = 0; i < lineList.length; i++) {
                    int startIndex = lineList[i].indexOf(str) + str.length();
                    int endIndex = lineList[i].indexOf(endChar, startIndex);
                    if (startIndex >= 0 && endIndex >= 0 && endIndex > startIndex) {
                        String resultString = lineList[i].substring(startIndex, endIndex);
                        intIdNumer = Integer.parseInt(resultString);

                        if (intIdNumer > maxIdNumer) {
                            maxIdNumer = intIdNumer;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxIdNumer;
    }

    //Начисление баллов
   public static void SummCount(int userId, String nickname, int guessTNScore) {
        String line;
        List<String> lines = new ArrayList<>();
        String str = "";
        String endChar = "";

        Path filePath = Paths.get("player_base.txt");

        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (guessTNScore) {
            case 1:
                str = "rateGN=";
                endChar = ",";
                break;
            case 2:
                str = "rate0X=";
                endChar = ")";
                break;
        }

        boolean foundAndUpdate = false;

        for (int cursorPosition = 0; cursorPosition < lines.size(); cursorPosition++) {
            line = lines.get(cursorPosition);

            if (cursorPosition == userId) {
                int startIndex = line.indexOf(str) + str.length();
                int endIndex = line.indexOf(endChar, startIndex);

                if (startIndex >= 0 && endIndex >= 0 && endIndex > startIndex) {
                    String resultString = line.substring(startIndex, endIndex);
                    int number = Integer.parseInt(resultString) + 1;

                    String modifiedNumber = String.valueOf(number);
                    String replaceStartPosition = str + resultString;
                    String replaceStartPosition1 = str + modifiedNumber;

                    line = line.replaceFirst(replaceStartPosition, replaceStartPosition1);
                    foundAndUpdate = true;
                }
                lines.set(cursorPosition, line);

                if (foundAndUpdate) {
                    break;
                }
            }
        }

        System.out.println(nickname + " Вам начислен балл");

        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




