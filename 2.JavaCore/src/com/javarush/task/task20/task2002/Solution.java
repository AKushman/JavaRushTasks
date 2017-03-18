package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("c:/JAVA/test.txt", null);
            OutputStream outputStream = new FileOutputStream("c:/JAVA/test.txt");
            InputStream inputStream = new FileInputStream("c:/JAVA/test.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User testUser = new User();
            testUser.setFirstName("Ivan");
            testUser.setLastName("Ivanov");
            testUser.setBirthDate(new Date());
            testUser.setCountry(User.Country.RUSSIA);
            testUser.setMale(true);
            javaRush.users.add(testUser);
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User user : users) {
                writer.print(user.getFirstName() + " ");
                writer.print(user.getLastName() + " ");
                writer.print(user.getCountry() + " ");
                writer.print(user.isMale() + " ");
                writer.println(user.getBirthDate() == null ? "null" : user.getBirthDate().getTime());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String userLine = reader.readLine();
            while (true) {
                if (userLine == null || userLine.isEmpty())
                    break;
                String[] userData = userLine.split(" ");
                User user = new User();
                user.setFirstName("null".equals(userData[0]) ? null : userData[0]);
                user.setLastName("null".equals(userData[1]) ? null : userData[1]);
                user.setCountry("null".equals(userData[2]) ? null : User.Country.valueOf(userData[2]));
                user.setMale("true".equals(userData[3]) ? true : false);
                Date date = "null".equals(userData[4]) ? null : new Date(Long.parseLong(userData[4]));

                user.setBirthDate(date);
                users.add(user);
                userLine = reader.readLine();
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
