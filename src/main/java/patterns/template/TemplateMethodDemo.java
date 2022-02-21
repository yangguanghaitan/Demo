package patterns.template;

/**
 * @Auther d
 * @Date 2022/2/21 10:29
 * @Describe 模板方法设计模式
 **/
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Vehicle autoVehicle = new AutoVehicle();
        autoVehicle.drive();
        System.out.println("##################");
        ManualVehicle manualVehicle = new ManualVehicle();
        manualVehicle.drive();
    }
}
