import java.util.*;
public class week4 {
    public static void main(String[] args) {
        String str = "Before";
        List<String> strings = new ArrayList<>();
        strings.add("before");

        put_CallbyValue(str, "After");
        System.out.println(str);

        put_CallbyReference(strings, "Middle");
        System.out.println(strings);
    }

    public static void put_CallbyValue(String oldStr, String newStr){
        oldStr = newStr;
    }

    public static void put_CallbyReference(List<String> list, String str)
    {
        list.set(list.size()/2, str);
    }
}
