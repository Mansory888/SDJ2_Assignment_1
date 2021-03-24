package model;

import java.text.DecimalFormat;

public class Temperature {
    private String id;
    private double value;
    private DateTime time;

    public Temperature(String id, double value){
        this.id = id;
        this.value = value;
        time = new DateTime();
    }

    public String getId(){return id;}
    public double getValue(){return Double.parseDouble(new DecimalFormat("##.###").format(value));}
    public String getlog(){ return String.format("%s: %.1f (%s)", id, value, time.getTimestamp()); }
    @Override public String toString(){return id +": " + value;}


}
