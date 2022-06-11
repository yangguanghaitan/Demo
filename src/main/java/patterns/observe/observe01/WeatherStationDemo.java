package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 18:04
 * @Describe 天气预报，WeatherData天气数据为主题，Observer的三个实现类即目前状况(温度，湿度，压强)，气象统计，
 *          天气预报为观察者，WeatherData数据更新，就会通知三个面板观察者，从而更新面板内容
 **/
public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        //目前状况
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        //天气预报
        ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);
        //气象统计
        StatisticsDisplay statisticsDisplay=new StatisticsDisplay(weatherData);

        System.out.println("数据变更========");
        weatherData.setMeasurements(10,20,30);
        System.out.println("数据变更========");
        weatherData.setMeasurements(100,200,300);
        System.out.println("数据变更========");
        weatherData.setMeasurements(1000,2000,100);
    }
}
