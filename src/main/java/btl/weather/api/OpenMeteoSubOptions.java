package btl.weather.api;

public class OpenMeteoSubOptions {
    protected StringBuilder options = new StringBuilder();

    public void addParam(String param){
        options.append(param + ",");
    }

    public void addParams(String[] params){
        for(String param: params){
            options.append(param + ",");
        }
    }

    public String toString(){
        return options.toString();
    }
}
