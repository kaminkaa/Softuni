package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<code>[A-Z]{2})(?<temperature>\\d+\\.\\d+)(?<weather>[a-zA-Z]+)\\|";
        Pattern pattern = Pattern.compile(regex);
        LinkedHashMap<String, City> cities = new LinkedHashMap<>();
        while (true){
            String input = reader.readLine();
            if (input.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String code = matcher.group("code");
                double temperature = Double.parseDouble(matcher.group("temperature"));
                String weather = matcher.group("weather");
                City city = new City(code, temperature, weather);
                cities.put(code, city);
            }
        }

        cities.values().stream()
                .sorted(Comparator.comparing(City::getAverageTemperature))
                .forEach(city -> {
                    System.out.printf("%s => %.2f => %s%n", city.getCode(),
                            city. getAverageTemperature(), city.getWeatherType());
                });
    }
}
class City{
    private String code;
    private double averageTemperature;
    private String weatherType;

    City(String code, double averageTemperature, String weatherType){
        this.code = code;
        this.averageTemperature = averageTemperature;
        this.weatherType = weatherType;
    }
    public String getCode(){
        return code;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public String getWeatherType() {
        return weatherType;
    }
}
