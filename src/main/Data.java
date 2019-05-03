package main;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Observable;

public class Data extends Observable {
    public Data(){
    }
    public double getRate(String unit) throws IOException, JSONException {
    String  url = "https://api.exchangeratesapi.io/latest";
    URL u = new URL(url);

        BufferedReader b = new BufferedReader(new InputStreamReader(u.openStream()));
        String s = b.readLine();
//        System.out.println(s);

        JSONObject str = new JSONObject(s);
        JSONObject rate = str.getJSONObject("rates");
//        System.out.println(str.getString("date"));
//        System.out.println(rate.getDouble("JPY"));
        return rate.getDouble(unit);

    }

    public void print() throws IOException {
        String  url = "https://api.exchangeratesapi.io/latest";
        URL u = new URL(url);

        BufferedReader b = new BufferedReader(new InputStreamReader(u.openStream()));
        String s = b.readLine();
        System.out.println(s);
        setChanged();
        notifyObservers();

    }

    public Double convert(String amount, String inU, String outU){
        Double a = Double.valueOf(amount);
        Double i = 1.0;
        Double o = 1.0;
        Double ans;
        if(inU.equals("EUR")){
             i = 1.0;
        }
        else {
            try {
                i = getRate(inU);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if(outU.equals("EUR")){
            o = 1.0;
        }
        else {
            try {
                o = getRate(outU);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ans = (a/i)*o;
        return ans;
    }
}
