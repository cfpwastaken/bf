package de.cfp.lib.lib;

import java.util.Random;

public class MathUtil {

    public static int random(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}
