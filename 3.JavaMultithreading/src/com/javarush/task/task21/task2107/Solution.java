package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            User user = new User(this.age, this.name);
            return user;
        }

        @Override
        public int hashCode() {
            return age * 18;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (o == null || !(o instanceof User) || o.getClass() != this.getClass())
                return false;
            User u = (User) o;
            return age == u.age && (name != null ? name.equals(u.name) : u.name == null);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> pair : this.users.entrySet()) {
            String s = pair.getKey();
            User u = pair.getValue().clone();
            solution.users.put(s, u);
        }
        return solution;
    }
}
