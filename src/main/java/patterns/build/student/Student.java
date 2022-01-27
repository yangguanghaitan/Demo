package patterns.build.student;

/**
 * @Auther d
 * @Date 2022/1/28 1:41
 * @Describe
 **/
public class Student {
    private String name;

    private int age;

    private int num;

    private String email;

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num=" + num +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder implements IStudentBuilder<Student> {
        private final Student student;

        public Builder() {
            student = new Student();
        }

        public Builder name(String name){
               student.name=name;
               return this;
        }

        public Builder age(int age){
            student.age=age;
            return this;
        }

        public Builder num(int num){
            student.num=num;
            return this;
        }
        public Builder email(String email){
            student.email=email;
            return this;
        }

        @Override
        public Student build() {
           return this.student;
        }
    }

}
