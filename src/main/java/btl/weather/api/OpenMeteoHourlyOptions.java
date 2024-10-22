package btl.weather.api;

import java.net.URI;

public class OpenMeteoHourlyOptions extends OpenMeteoSubOptions{
    public OpenMeteoHourlyOptions(){
        super.options.append("&daily=");
    }
}
