package patterns.observe.observe01;

/**
 * @Auther d
 * @Date 2022/6/11 17:53
 * @Describe  气象统计观察者
 **/
public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	public void display() {
		System.out.println("平均/最高/最低 温度 = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
