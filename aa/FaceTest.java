import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;

public class FaceTest {
    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
//        System.out.println(x==y); // true
//        System.out.println(x==z); // false
//        System.out.println(x.equals(y)); // true
        x.equals(z);
        System.out.println(); // true
//        System.out.println(x);
//        System.out.println(z);
//        Hashtable hashtable=new Hashtable();
//        hashtable.put(null,7);
//        hashtable.put(" ",90);
//        HashMap hashMap=new HashMap();
//        hashMap.put(null,90);
        HashSet hashSet=new HashSet();

    }
}
