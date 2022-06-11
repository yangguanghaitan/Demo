package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:33
 * @Describe 面板展示内容:三个观察者即 目前状况(温度，湿度，压强)，气象统计，天气预报需要展示到三块面板中
 **/
public interface DisplayElement {
    void display();
}
