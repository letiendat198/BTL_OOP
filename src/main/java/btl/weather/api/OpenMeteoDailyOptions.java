package btl.weather.api;

public class OpenMeteoDailyOptions extends OpenMeteoSubOptions{
    public OpenMeteoDailyOptions(){
        super.options.append("&daily=");
    }
}
