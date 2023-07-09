package jsonWrappers;

import beans.CreditInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CreditContainer {

    public String cdName;
    public String cdNumber;
    public String monthV;
    public int year;
    public String code;


    public CreditContainer() {
        Gson gson = new Gson();
        // GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("json/cc.json");
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new InputStreamReader(in)), GuestsInfo.class);
        CreditInfo credit = gson.fromJson(new BufferedReader(new InputStreamReader(in)), CreditInfo.class);

        cdName = credit.getCreditInfo().get(0).getCcData().getCdName();
        cdNumber = credit.getCreditInfo().get(0).getCcData().getCdNumber();
        monthV = credit.getCreditInfo().get(0).getCcData().getMonthV();
        year = credit.getCreditInfo().get(0).getCcData().getYear() ;
        code = credit.getCreditInfo().get(0).getCcData().getCode();

    }

    public CreditContainer(int index) throws FileNotFoundException {
        Gson gson = new Gson();
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jsonFiles/cc.json");
        CreditInfo credit = gson.fromJson(new BufferedReader(new InputStreamReader(in)), CreditInfo.class);
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);
        //System.out.println(client.toString());
        cdName = credit.getCreditInfo().get(index).getCcData().getCdName();
        cdNumber = credit.getCreditInfo().get(index).getCcData().getCdNumber();
        monthV = credit.getCreditInfo().get(index).getCcData().getMonthV();
        year = credit.getCreditInfo().get(index).getCcData().getYear() ;
        code =credit.getCreditInfo().get(index).getCcData().getCode();


    }

}
