package jsonWrappers;

import beans.AddressInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddressContainer {


    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String street;
    public String city;
    public String zipcode;
    public String state;


    public AddressContainer() {
        Gson gson = new Gson();
        // GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("json/shipAddress.json");
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new InputStreamReader(in)), GuestsInfo.class);
        AddressInfo address = gson.fromJson(new BufferedReader(new InputStreamReader(in)), AddressInfo.class);

        firstName = address.getAddressInfo().get(0).getAddrData().getFirstName();
        lastName = address.getAddressInfo().get(0).getAddrData().getLastName();
        phoneNumber = address.getAddressInfo().get(0).getAddrData().getPhoneNumber();
        street = address.getAddressInfo().get(0).getAddrData().getStreet();
        city = address.getAddressInfo().get(0).getAddrData().getCity();
        zipcode = address.getAddressInfo().get(0).getAddrData().getZipcode();
        state = address.getAddressInfo().get(0).getAddrData().getState();
    }

    public AddressContainer(int index) throws FileNotFoundException {
        Gson gson = new Gson();
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jsonFiles/shipAddress.json");
        AddressInfo address = gson.fromJson(new BufferedReader(new InputStreamReader(in)), AddressInfo.class);
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/address.json")), GuestsInfo.class);
        //System.out.println(address.toString());

        firstName = address.getAddressInfo().get(index).getAddrData().getFirstName();
        lastName = address.getAddressInfo().get(index).getAddrData().getLastName();
        phoneNumber = address.getAddressInfo().get(index).getAddrData().getPhoneNumber();
        street = address.getAddressInfo().get(index).getAddrData().getStreet();
        city = address.getAddressInfo().get(index).getAddrData().getCity();
        zipcode = address.getAddressInfo().get(index).getAddrData().getZipcode();
        state = address.getAddressInfo().get(index).getAddrData().getState();
    }
}
