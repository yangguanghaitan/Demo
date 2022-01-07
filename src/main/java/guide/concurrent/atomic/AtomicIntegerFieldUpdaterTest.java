package guide.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther d
 * @Date 2022/1/8 1:37
 * @Describe 4类原子类:基本类型、数组类型、引用类型、对象的属性修改类型(本例就是)
 **/
public class AtomicIntegerFieldUpdaterTest {

        public static void main(String[] args) {
            AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

            User user = new User("Java", 22);
            System.out.println(a.getAndIncrement(user));// 22
            System.out.println(a.get(user));// 23

    }
}
    class User {
        private String name;
        public volatile int age;

        public User(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

