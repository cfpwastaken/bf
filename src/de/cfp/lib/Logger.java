package de.cfp.lib.lib;

import java.util.Date;

public class Logger {

    public static boolean debug = false;

    public static void log(String text) {
        Date d = new Date();
        System.out.println("[" + d + "] [INFO] " + text);
    }

    public static void warn(String text) {
        Date d = new Date();
        System.out.println("[" + d + "] [WARN] " + text);
    }

    public static void err(String text) {
        Date d = new Date();
        System.err.println("[" + d + "] [ERROR] " + text);
    }

    public static void debug(String text) {
        if(!debug) return;
        Date d = new Date();
        System.out.println("[" + d + "] [DEBUG] " + text);
    }

}
