package org.example.spring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {

//Проверка не пустой ли файл
    public static  int distributor(List<User>list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt"));
            if (br.readLine() == null) {
                return 1;
            }
            else{
                return 2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     return 0;
    }
//Заброс в файл инфы
    public static void writer(List<User>list) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (User user : list) {
                printWriter.println(user.toString());
            }
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Пользователь добавлен");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static int checkUser(String user) {
        String fileName = "C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt";
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
                for (int i = 0; i < lineList.length ; i++) {
                    if  (lineList[i].contains(searchnick)) {
                        int startIndex =  lineList[i].indexOf(searchnick) + searchnick.length();
                        int endIndex =  lineList[i].indexOf(endCharnick, startIndex);
                        String resultString =  lineList[i].substring(startIndex, endIndex);
                        if(user.equals(resultString)){
                            int startIndexId =  lineList[i].indexOf(searchId) + searchId.length();
                            int endIndexId =  lineList[i].indexOf(endCharId,  startIndexId);
                            int resultStringId =  Integer.parseInt(lineList[i].substring(startIndexId, endIndexId));

                            return resultStringId;
                        }
                        else{
                           System.out.println("Такого пользователя нет.Зарегистрируйтесь заново или проверте ник");
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
    public static int checkId(){
        String line;
        int maxIdNumer = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt"));

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] lineList = line.split(";");
                    String str = "User(id=";
                    String endChar = ",";
                    int intIdNumer = 0;
                    //System.out.println(lineList);
                    for (int i = 0; i < lineList.length ; i++) {
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
        ArrayList<String> lines = new ArrayList<>();
        int maxIdNumer = -1;
        String str="";
        String endChar="";
        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt", "rw");
            while ((line = raf.readLine()) != null) {
                lines.add(line);
            }
            raf.close();
            raf = new RandomAccessFile("C:\\Users\\123\\Desktop\\Новая папка (12)\\Game_menu-Rel\\file23.txt", "rw");
            if(guessTNScore==1){
                str = "rateGN=";
                 endChar = ",";
            }
            else if(guessTNScore==2){
                 str = "rate0X=";
                 endChar = ")";
            }
            boolean foundAndUpdate = false;
            for (int cursorPosition = 0; cursorPosition < lines.size(); cursorPosition++) {
                line = lines.get(cursorPosition);
                String[] lineList = line.split(";");
                for (int i = 0; i < lineList.length; i++) {
                    int startIndex = lineList[i].indexOf(str) + str.length();
                    int endIndex = lineList[i].indexOf(endChar, startIndex);
                    if (startIndex >= 0 && endIndex >= 0 && endIndex > startIndex) {
                        String resultString = lineList[i].substring(startIndex, endIndex);
                        int number = Integer.parseInt(resultString) + 1;
                        System.out.println(nickname+" Вам начислен балл");
                        String modifiedNumber = String.valueOf(number);
                        int lineNumber = userId;
                        String replaceStartPosition =  str + resultString;
                        String replaceStartPosition1 =  str + modifiedNumber;
                        if (cursorPosition == lineNumber) {
                            line = line.replaceFirst(replaceStartPosition, replaceStartPosition1);
                            foundAndUpdate = true;
                            break;
                        }
                    }
                }
                if (foundAndUpdate) {
                    lines.set(cursorPosition, line);
                    break;
                }
            }
            for (String updatedLine : lines) {
                raf.writeBytes(updatedLine + "\n");
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




