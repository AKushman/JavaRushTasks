package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution s1 = new Solution();
        s1.innerClasses[0] = s1.new InnerClass();
        s1.innerClasses[1] = s1.new InnerClass();
        Solution s2 = new Solution();
        s2.innerClasses[0] = s1.new InnerClass();
        s2.innerClasses[1] = s1.new InnerClass();
        solutions[0] = s1;
        solutions[1] = s2;
        return solutions;
    }

    public static void main(String[] args) {

    }
}
