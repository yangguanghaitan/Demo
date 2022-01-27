package patterns.build.student;

/**
 * @Auther d
 * @Date 2022/1/28 1:59
 * @Describe build模式构建一个学生
 **/
public class StudentBuild {
    public static void main(String[] args) {
        Student student = new Student.Builder().age(12).email("888@qq.com").num(78).name("小明").build();
        System.out.println(student);
    }
}
