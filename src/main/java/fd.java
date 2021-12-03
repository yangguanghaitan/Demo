import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class fd {
    public static void main(String[] args) {
//        final List< String> list=new ArrayList();
//        list.add("as");
//        list.add("as");
//        list.add("as");
//        list.add("as");
//        PrintStream out = System.out;
//        list.forEach(System.out::println);
//        Vector vector=new Vector();
//        vector.add("sd");
//        Object[] objects = {54, 78};
//        vector.copyInto(objects);
//        System.out.println(Arrays.toString(objects));
       /* ConcurrentMap concurrentMap=new ConcurrentHashMap();
        Object o = concurrentMap.putIfAbsent("aa", "6");
        System.out.println(o);
        Object o1 = concurrentMap.putIfAbsent("aa", "asdds");
        System.out.println(o1);

        Executor executor= Executors.newSingleThreadExecutor();
        ExecutorService executorService = null;
        executor=executorService;*/
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    Integer sum(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.summingInt(Integer::intValue));
    }

}
