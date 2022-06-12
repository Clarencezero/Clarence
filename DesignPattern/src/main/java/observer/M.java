package observer;
/**
 * @author Clarence
 * @date 2020-06-02 08:59
 */
public class M {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        TempConditionDisplay tempConditionDisplay = new TempConditionDisplay(weatherData);
        weatherData.setMeasurements(1F, 3F, 4F);
    }
}
