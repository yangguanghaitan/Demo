package basic.collectUse;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther d
 * @Date 2022/7/19 10:10
 * @Describe
 **/
public class CollectUseTest2 {
    @Test
    public void groupByList() {
        Map<Integer, List<Apple>> groupByList = getPersonData().stream().collect(Collectors.groupingBy(Apple::getNum));
        System.out.println("list按属性分组成Map==" + groupByList);
    }


    /**
     * List -> Map
     * 需要注意的是：
     * toMap 如果集合对象有重复的key，会报错Duplicate key ....
     * apple1,apple12的id都为1。
     * 可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
     */
    @Test
    public void listToMap() {
        Map<Integer, Apple> mapList = getPersonData().stream().collect(Collectors.toMap(Apple::getNum, a -> a, (k1, k2) -> k1));
        System.out.println("list转Map==" + mapList);
    }

    @Test
    public void filterList() {
        List<Apple> filterList = getPersonData().stream().filter(apple -> apple.getNum().equals(10)).collect(Collectors.toList());
        System.out.println("从集合中过滤出符合条件的元素==" + filterList);
    }

    @Test
    public void sumByField() {
        BigDecimal sumMoney = getPersonData().stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("将集合中的数据按照某个属性求和==" + sumMoney);
    }

    //查找流中最大值最小值
    @Test
    public void maxAndMinValue() {
        Optional<Apple> appleMax = getPersonData().stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getMoney)));
        appleMax.ifPresent(System.out::println);
        Optional<Apple> appleMin = getPersonData().stream().collect(Collectors.minBy(Comparator.comparing(Apple::getMoney)));
        System.out.println(appleMin.get());
    }


    //1，不重写Object的equals与hashCode，所有属性都一样也无法去重
    //2，指定属性重写Object的equals与hashCode时，按照指定属性去重
    @Test
    public void uniqueByList() {
        List<Apple> uniqueList = getPersonData().stream().distinct().collect(Collectors.toList());
        System.out.println(String.format("集合去重=={%s},集合大小=={%s}", uniqueList,uniqueList.size()));
    }



    public static List<Apple> getPersonData() {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple11 = new Apple(1, "苹果11", new BigDecimal("3.25"), 10);
        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果3", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("9.99"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("100.00"), 40);
        Apple apple4 = new Apple(3, "荔枝", new BigDecimal("100.00"), 40);

        appleList.add(apple1);
        appleList.add(apple11);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
        return appleList;
    }
}

class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return id.equals(apple.id) &&
                name.equals(apple.name) &&
                money.equals(apple.money) &&
                num.equals(apple.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, money, num);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }
}
