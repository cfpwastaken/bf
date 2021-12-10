package de.cfp.lib.lib;

public class Main {

    public static void main(String[] args) {
        Logger.debug = true;
        ArgParser.parse(args);
        System.out.println(ArgParser.getBool("debug"));
        System.out.println(ArgParser.getString("input"));
        System.out.println(ArgParser.getInt("amount"));
//        String[] arr = {"1", "2", "3"};
//        System.out.println(StringUtil.fromArray(arr, "-"));

//        int[] arr = {1, 2, 3};
//        var lst = ArrUtil.toArrayListInt(arr);
//        lst.add(4);
//        System.out.println(StringUtil.fromArray(ArrUtil.fromArrayListInt(lst), ", "));

//        System.out.println(MathUtil.random(69, 420));

//        jhkfghjfhjhui
    }

}
