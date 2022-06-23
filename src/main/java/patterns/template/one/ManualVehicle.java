package patterns.template.one;

/**
 * @Auther d
 * @Date 2022/2/21 10:27
 * @Describe 手动挡车辆
 **/
public class ManualVehicle extends Vehicle{
    @Override
    protected void putIntoGear() {
        System.out.println("手动挡踩离合器挂前进挡位");
    }
}
