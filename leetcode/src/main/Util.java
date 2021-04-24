package src.main;

public class Util {
    public static void print(String msg,Object... params) {
        String replace = msg.replace("{}", "%s");
        System.out.println(String.format(replace, params));
    }
}
