package de.cfp.lib.lib;

public class StringUtil {

    public static String fromArray(String[] arr, String sep) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1)
                str += arr[i];
            else
                str += arr[i] + sep;
        }

        return str;
    }

    public static String fromArray(int[] arr, String sep) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1)
                str += arr[i];
            else
                str += arr[i] + sep;
        }

        return str;
    }

}
