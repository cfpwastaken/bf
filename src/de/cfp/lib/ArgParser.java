package de.cfp.lib.lib;

import java.util.HashMap;

public class ArgParser {

    private static HashMap<String, String> opts = new HashMap<>();
    private static HashMap<String, Boolean> optsbool = new HashMap<>();
    private static HashMap<String, Integer> optsint = new HashMap<>();

    public static void parse(String[] args) {
        Logger.debug("[ArgParser] Beginning parse");
        Logger.debug("[ArgParser] Args length: " + args.length);
        String argstr = args.toString();
        Logger.debug(argstr);
        for (int i = 0; i < args.length; i++) {
            if(args[i].startsWith("--")) {
                if(args[i + 1].equalsIgnoreCase("false") || args[i + 1].equalsIgnoreCase("true")) {
                    optsbool.put(args[i].substring(2), Boolean.parseBoolean(args[i + 1]));
                } else if(MathUtil.isInteger(args[i + 1])) {
                    optsint.put(args[i].substring(2), Integer.parseInt(args[i + 1]));
                } else {
                    optsbool.put(args[i].substring(2), Boolean.parseBoolean(args[i + 1]));
                }
                opts.put(args[i].substring(2), args[i + 1]);
                i++;
            } else {
                Logger.warn("Parsing warn");
            }
        }
    }

    public static String getString(String key) {
        return opts.getOrDefault(key, "");
    }

    public static boolean getBool(String key) {
        return optsbool.getOrDefault(key, false);
    }

    public static int getInt(String key) {
        return optsint.getOrDefault(key, 0);
    }

}
