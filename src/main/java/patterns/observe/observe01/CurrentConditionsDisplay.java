package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:53
 * @Describe  目前状况观察者(温度，湿度，压强)
 **/
public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private float temp;//温度
    private float humidity;//湿度
    private float pressure;//压强

    //需要订阅的主题
    public Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        //订阅主题
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("目前状况面板: "+"温度:"+temp+"--"+"湿度:"+humidity+"--"+"压强:"+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
          this.temp=temp;
          this.humidity=humidity;
          this.pressure=pressure;
          display();
    }
}
