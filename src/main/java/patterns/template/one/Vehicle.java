package patterns.template.one;

/**
 * @Auther d
 * @Date 2022/2/21 10:15
 * @Describe 抽象的模板类:车辆，{@link Vehicle#drive()}模板方法
 **/
public abstract class Vehicle {

    public final void drive() {
        //点火
        startTheEngine();
        //挂挡
        putIntoGear();
        //放下手刹
        looseHandBrake();
        //踩油门
        stepOnTheGasAndGo();

    }
    //需要子类根据情况自定义
    protected abstract void putIntoGear();

    private void stepOnTheGasAndGo() {
        System.out.println("车踩油门");
    }

    private void looseHandBrake() {
        System.out.println("车放下手刹");
    }

    private void startTheEngine() {
        System.out.println("车点火");
    }
}
