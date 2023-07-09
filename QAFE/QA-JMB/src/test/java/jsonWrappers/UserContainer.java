package jsonWrappers;

import beans.UserInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserContainer {
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String userEmail;
    public String passwd;



    public UserContainer() {
        Gson gson = new Gson();
        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jsonFiles/users.json");
        UserInfo client = gson.fromJson(new BufferedReader(new InputStreamReader(in)), UserInfo.class);
        id = client.getUserInfo().get(0).getPersonalData().getId();
        firstName =client.getUserInfo().get(0).getPersonalData().getFirstName();
        lastName =client.getUserInfo().get(0).getPersonalData().getLastName();
        phoneNumber = client.getUserInfo().get(0).getPersonalData().getPhoneNumber();
        userEmail = client.getUserInfo().get(0).getPersonalData().getUser();
        passwd = client.getUserInfo().get(0).getPersonalData().getPasswd();



    }

    public UserContainer(int index) {
        Gson gson = new Gson();
        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = null;
        in = classLoader.getResourceAsStream("jsonFiles/users.json");
        UserInfo client = gson.fromJson(new InputStreamReader(in), UserInfo.class);
        //UserInfo client = gson.fromJson(new BufferedReader(new FileReader("jsonFiles/users.json")), UserInfo.class);
        //System.out.println(client.toString());
        id = client.getUserInfo().get(index).getPersonalData().getId();
        firstName =client.getUserInfo().get(index).getPersonalData().getFirstName();
        lastName =client.getUserInfo().get(index).getPersonalData().getLastName();
        phoneNumber = client.getUserInfo().get(index).getPersonalData().getPhoneNumber();
        userEmail = client.getUserInfo().get(index).getPersonalData().getUser();
        passwd = client.getUserInfo().get(index).getPersonalData().getPasswd();

    }

}

