package jsonWrappers;

import beans.InvalidPasswordInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InvalidPasswordContainer
{
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public String passwd;
    public String confPassword;


    public InvalidPasswordContainer() {
        Gson gson = new Gson();
        // GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/password.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("json/invalidPassword.json");
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new InputStreamReader(in)), GuestsInfo.class);
        InvalidPasswordInfo password = gson.fromJson(new BufferedReader(new InputStreamReader(in)), InvalidPasswordInfo.class);

        firstName = password.getPasswordInfo().get(0).getPassData().getFirstName();
        lastName = password.getPasswordInfo().get(0).getPassData().getLastName();
        phoneNumber = password.getPasswordInfo().get(0).getPassData().getPhoneNumber();
        email = password.getPasswordInfo().get(0).getPassData().getEmail();
        passwd = password.getPasswordInfo().get(0).getPassData().getPassd();
        confPassword = password.getPasswordInfo().get(0).getPassData().getconfPasswd();

    }

    public InvalidPasswordContainer(int index) throws FileNotFoundException {
        Gson gson = new Gson();
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/password.json")), GuestsInfo.class);

        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jsonFiles/invalidPassword.json");
        InvalidPasswordInfo password = gson.fromJson(new BufferedReader(new InputStreamReader(in)), InvalidPasswordInfo.class);
        //GuestsInfo guests = gson.fromJson(new BufferedReader(new FileReader("json/password.json")), GuestsInfo.class);
        //System.out.println(password.toString());

        firstName = password.getPasswordInfo().get(index).getPassData().getFirstName();
        lastName = password.getPasswordInfo().get(index).getPassData().getLastName();
        phoneNumber = password.getPasswordInfo().get(index).getPassData().getPhoneNumber();
        email = password.getPasswordInfo().get(index).getPassData().getEmail();
        passwd = password.getPasswordInfo().get(index).getPassData().getPassd();
        confPassword = password.getPasswordInfo().get(index).getPassData().getconfPasswd();

    }

}
