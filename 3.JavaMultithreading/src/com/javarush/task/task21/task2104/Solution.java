package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == this)
            return true;
        if (!(n instanceof Solution))
            return false;
        if (n == null || n.getClass() != this.getClass())
            return false;
        Solution s = (Solution) n;
        boolean fCheck = first == s.first || (first != null && first.equals(s.first));
        boolean lCheck = last == s.last || (last != null && last.equals(s.last));
        return fCheck && lCheck;
    }

    public int hashCode() {
        int fHash = 0;
        int sHash = 0;
        if (first != null)
            fHash = first.hashCode();
        if (last != null)
            sHash = last.hashCode();
        return 31 * (fHash + sHash);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
