package patterns.template;

/**
 * @Auther d
 * @Date 2022/2/21 10:25
 * @Describe 自动挡车辆
 **/
public class AutoVehicle  extends Vehicle{
    @Override
    protected void putIntoGear() {
        System.out.println("自动挡挂前进挡位");
    }
}
