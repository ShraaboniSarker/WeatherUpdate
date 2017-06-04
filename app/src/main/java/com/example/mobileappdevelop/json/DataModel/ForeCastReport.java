package com.example.mobileappdevelop.json.DataModel;

import com.example.mobileappdevelop.json.ModelClassForecast.ForeCastList;
import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r3l0ad3d on 4/22/17.
 */

public class ForeCastReport {
    protected String CountryName;
    protected String CityName;
    protected String Date;
    protected String WeatherRepor;
    protected String Temperature;
    protected String TemperatureMax;
    protected String TemperatureMin;
    protected String Pressure;
    protected String Humidity;
    protected String SeeLevel;
    protected String GroundLevel;
    /*protected String SunRise;
    protected String SunSet;*/
    protected String Clouds;
    protected String WeatherReporIcon;
    protected String Wind;
    protected String Direction;
    protected String Rain_3Hour_Report;
    protected String Snow_3Hour_Report;
    protected List<ForeCastReport> reportList = new ArrayList<>();

    public ForeCastReport() {
    }
    public ForeCastReport(WeatherForeCastMain foreCastMain) {
        convert(foreCastMain);
    }

    protected void convert(WeatherForeCastMain foreCastMain) {
        List<ForeCastList> list = new ArrayList<>();
        list.addAll(foreCastMain.getList());
        int list_size = list.size();
        for(int i=0;i<list_size;i++){
            ForeCastList foreCastItem = list.get(i);
            ForeCastReport report = new ForeCastReport();

            report = ConvertToString(foreCastItem);
            report.setCountryName(foreCastMain.getCity().getCountry());
            reportList.add(report);

        }
    }

    protected ForeCastReport ConvertToString(ForeCastList foreCastItem) {
        ForeCastReport report = new ForeCastReport();
        Double check = new Double(0);
        Integer ck = new Integer(0);
        if(foreCastItem.getMain().getTemp()>check){
            report.setTemperature(String.valueOf(foreCastItem.getMain().getTemp()));
        }else{
            report.setTemperature("");
        }
        if(foreCastItem.getMain().getTempMax()>check){
            report.setTemperatureMax(String.valueOf(foreCastItem.getMain().getTempMax()));
        }else{
            report.setTemperatureMax("");
        }
        if(foreCastItem.getMain().getTempMin()>check){
            report.setTemperatureMin(String.valueOf(foreCastItem.getMain().getTempMin()));
        }else{
            report.setTemperatureMin("");
        }
        if(foreCastItem.getMain().getPressure()>check){
            report.setPressure(String.valueOf(foreCastItem.getMain().getPressure()));
        }else {
            report.setPressure("");
        }
        if(foreCastItem.getMain().getHumidity()>ck){
            report.setHumidity(String.valueOf(foreCastItem.getMain().getHumidity()));
        }else {
            report.setHumidity("");
        }
        if(foreCastItem.getMain().getSeaLevel()>check){
            report.setSeeLevel(String.valueOf(foreCastItem.getMain().getSeaLevel()));
        }else {
            report.setSeeLevel("");
        }
        if(foreCastItem.getMain().getGrndLevel()>check){
            report.setGroundLevel(String.valueOf(foreCastItem.getMain().getGrndLevel()));
        }else {
            report.setGroundLevel("");
        }

        report.setRain_3Hour_Report("");


        report.setSnow_3Hour_Report("");

        if(!foreCastItem.getWind().getSpeed().isNaN()){
            report.setWind(String.valueOf(foreCastItem.getWind().getSpeed()));
        }else {
            report.setWind("");
        }
        if(!foreCastItem.getWind().getDeg().isNaN()){
            report.setDirection(String.valueOf(foreCastItem.getWind().getDeg()));
        }else {
            report.setDirection("");
        }
        if(!foreCastItem.getClouds().getAll().equals(0)){
            report.setClouds(String.valueOf(foreCastItem.getClouds().getAll()));
        }

        report.setWeatherRepor(foreCastItem.getWeather().get(0).getDescription());
        report.setWeatherReporIcon(foreCastItem.getWeather().get(0).getIcon());
        report.setDate(foreCastItem.getDtTxt());

        return report;
    }

    protected void setCountryName(String countryName) {
        CountryName = countryName;
    }

    protected void setCityName(String cityName) {
        CityName = cityName;
    }

    protected void setDate(String date) {
        Date = date;
    }

    protected void setWeatherRepor(String weatherRepor) {
        WeatherRepor = weatherRepor;
    }

    protected void setTemperature(String temperature) {
        Temperature = temperature;
    }

    protected void setTemperatureMax(String temperatureMax) {
        TemperatureMax = temperatureMax;
    }

    protected void setTemperatureMin(String temperatureMin) {
        TemperatureMin = temperatureMin;
    }

    protected void setPressure(String pressure) {
        Pressure = pressure;
    }

    protected void setHumidity(String humidity) {
        Humidity = humidity;
    }

    protected void setSeeLevel(String seeLevel) {
        SeeLevel = seeLevel;
    }

    protected void setGroundLevel(String groundLevel) {
        GroundLevel = groundLevel;
    }

    /*protected void setSunRise(String sunRise) {
        SunRise = sunRise;
    }

    protected void setSunSet(String sunSet) {
        SunSet = sunSet;
    }*/

    protected void setClouds(String clouds) {
        Clouds = clouds;
    }

    protected void setWeatherReporIcon(String weatherReporIcon) {
        WeatherReporIcon = weatherReporIcon;
    }

    protected void setWind(String wind) {
        Wind = wind;
    }

    protected void setDirection(String direction) {
        Direction = direction;
    }

    protected void setRain_3Hour_Report(String rain_3Hour_Report) {
        Rain_3Hour_Report = rain_3Hour_Report;
    }

    protected void setSnow_3Hour_Report(String snow_3Hour_Report) {
        Snow_3Hour_Report = snow_3Hour_Report;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getCityName() {
        return CityName;
    }

    public String getDate() {
        return Date;
    }

    public String getWeatherRepor() {
        return WeatherRepor;
    }

    public String getTemperature() {
        return Temperature;
    }

    public String getTemperatureMax() {
        return TemperatureMax;
    }

    public String getTemperatureMin() {
        return TemperatureMin;
    }

    public String getPressure() {
        return Pressure;
    }

    public String getHumidity() {
        return Humidity;
    }

    public String getSeeLevel() {
        return SeeLevel;
    }

    public String getGroundLevel() {
        return GroundLevel;
    }

    public String getClouds() {
        return Clouds;
    }

    public String getWeatherReporIcon() {
        return WeatherReporIcon;
    }

    public String getWind() {
        return Wind;
    }

    public String getDirection() {
        return Direction;
    }

    public String getRain_3Hour_Report() {
        return Rain_3Hour_Report;
    }

    public String getSnow_3Hour_Report() {
        return Snow_3Hour_Report;
    }

    public List<ForeCastReport> getReportList() {
        return reportList;
    }
}
