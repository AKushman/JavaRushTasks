package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
        solution.createExpression(2);
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int[] sts = {1, 3, 9, 27, 81, 243, 729, 2187};
        int copy = number;
        StringBuilder builder = new StringBuilder(number + " =");
        List<Integer> troicNumber = new ArrayList<>();
        List<Integer> creationArray = new ArrayList<>();
        while (copy > 0) {
            troicNumber.add(copy % 3);
            copy /= 3;
        }
        for (int i = 0; i < troicNumber.size(); i++) {
            if (troicNumber.get(i) == 2) {
                creationArray.add(-1);
                if (i != troicNumber.size() - 1)
                    troicNumber.set(i + 1, troicNumber.get(i + 1) + 1);
                else creationArray.add(1);
            }
            else if (troicNumber.get(i) == 3) {
                creationArray.add(0);
                if (i != troicNumber.size() - 1)
                    troicNumber.set(i + 1, troicNumber.get(i + 1) + 1);
                else creationArray.add(1);
            }
            else creationArray.add(troicNumber.get(i));
        }
        for (int i = 0; i < creationArray.size(); i++) {
            if (creationArray.get(i) > 0)
                builder.append(" + ");
            if (creationArray.get(i) < 0 )
                builder.append(" - ");
            if (creationArray.get(i) == 0 )
                continue;
            builder.append(sts[i]);
        }
        System.out.println(builder.toString());
    }
}