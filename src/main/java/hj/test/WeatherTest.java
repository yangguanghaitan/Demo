package hj.test;

import hj.*;

import java.util.List;

public class WeatherTest {
    public static void main(String[] args) {
        ObjectFactory objectFactory=new ObjectFactory();
        WeatherWS weatherWS=new WeatherWS();
        WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();


        ArrayOfString weather = weatherWSSoap.getWeather("1851","");
        System.out.println("shandong: "+weather.getString());
        System.out.println("---11111获得支持的城市/地区名称和与之对应的ID-------");
        ArrayOfString supportCityString = weatherWSSoap.getSupportCityString("3119");
        List<String> string1 = supportCityString.getString();
        System.out.println(string1);

        /*System.out.println("---11111获得支持的城市/地区名称和与之对应的ID-------");
        GetSupportCityDatasetResponse.GetSupportCityDatasetResult sd = weatherWSSoap.getSupportCityDataset("3119");
        System.out.println(sd.getAny());*/

        System.out.println("---22222获得国外国家名称和与之对应的ID--------");
        ArrayOfString regionCountry = weatherWSSoap.getRegionCountry();
        System.out.println(regionCountry.getString());
        System.out.println("------------3333获得中国省份、直辖市、地区和与之对应的ID--------------");
        ArrayOfString regionProvince = weatherWSSoap.getRegionProvince();
        List<String> string = regionProvince.getString();
        System.out.println(string);
       /* WeatherWSHttpGet weatherWSHttpGet = weatherWS.getWeatherWSHttpGet();
        ArrayOfString regionProvince = weatherWSHttpGet.getRegionProvince();
        List<String> string = regionProvince.getString();
        System.out.println(string);*/
    }
}
