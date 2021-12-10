package de.cfp.lib.lib;

import java.util.ArrayList;

public class ArrUtil {

    public static ArrayList<Integer> toArrayListInt(int[] arr) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            lst.add(arr[i]);
        }

        return lst;
    }

    public static int[] fromArrayListInt(ArrayList<Integer> lst) {
        int[] arr = new int[lst.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }

        return arr;
    }

}
