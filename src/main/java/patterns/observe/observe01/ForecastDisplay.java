package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:53
 * @Describe  天气预报观察者，根据压强预测天气
 **/
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            System.out.println("天气预报面板："+"压强变大，温度变热");
        } else if (currentPressure == lastPressure) {
            System.out.println("天气预报面板："+"压强不变，温度差不多");
        } else if (currentPressure < lastPressure) {
            System.out.println("天气预报面板："+"压强变小，温度降低了");
        }
    }
}
