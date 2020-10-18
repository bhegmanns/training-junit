package de.hegmanns.training.junit5.breakpuzzles.break001;

/**
 *
 */
public class LoveWithStringApp {
    static String firstString = "hello world";
    static String hello = "hello";
    static String space = " ";
    static String world = "world";

    static String helloSpaceWorld = hello + space + world;
    static String helloSpaceWorldDirect = "hello" + " " + "world";

    public static void main(String[] args) {


        System.out.println("check (1)  : " + check01());
        System.out.println("check (2)  : " + check02());
        System.out.println("check (3)  : " + check03());
        System.out.println("check (4)  : " + check04());
        System.out.println("check (5)  : " + check05());
        System.out.println("check (6)  : " + check06());
        System.out.println("check (7)  : " + check07());
        System.out.println("check (8)  : " + check08());
        System.out.println("check (9)  : " + check09());
        System.out.println("check (10) : " + check10());
    }

    public static boolean check01() {
        return firstString == helloSpaceWorld;
    }

    public static boolean check02() {
        return firstString == hello + space + world;
    }

    public static boolean check03() {
        return firstString == "hello world";
    }

    public static boolean check04() {
        return firstString == "hello" + " " + "world";
    }

    public static boolean check05() {
        return firstString == helloSpaceWorldDirect;
    }

    public static boolean check06() {
        return "hello world" == "hello" + " " + "world";
    }

    public static boolean check07() {
        return "hello world" == helloSpaceWorldDirect;
    }

    public static boolean check08() {
        return "hello world" == helloSpaceWorld;
    }

    public static boolean check09() {
        return "hello " + "world" == firstString;
    }

    public static boolean check10() {
        return "hello " + "world" == helloSpaceWorld;
    }
}
