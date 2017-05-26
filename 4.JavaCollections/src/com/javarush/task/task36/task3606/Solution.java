package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File file = new File(packageName);
        String wayToFile = packageName.substring(packageName.indexOf("/com/") + 1).replaceAll("/", ".") + ".";
        String[] fileNames = file.list();
        for (String name : fileNames) {
           if (name.endsWith(".class"))
                hiddenClasses.add(Class.forName(wayToFile + name.replaceAll(".class", "")));
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            for (Class cls : hiddenClasses) {
                if (cls.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    Constructor cnst = cls.getDeclaredConstructor();
                    cnst.setAccessible(true);
                    return (HiddenClass) cnst.newInstance();
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}

