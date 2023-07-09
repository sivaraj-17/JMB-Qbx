package jsonWrappers;

import beans.UserInfo;
import com.google.gson.Gson;

import java.io.*;

public class UserContainer {
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String user;
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
        user = client.getUserInfo().get(0).getPersonalData().getUser();
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
        user = client.getUserInfo().get(index).getPersonalData().getUser();
        passwd = client.getUserInfo().get(index).getPersonalData().getPasswd();

    }
    public UserContainer(int index,String newPassword) throws IOException {
        Gson gson = new Gson();
        ClassLoader classLoader = UserContainer.class.getClassLoader();
        InputStream in = null;
        in = classLoader.getResourceAsStream("jsonFiles/users.json");
        UserInfo client = gson.fromJson(new InputStreamReader(in), UserInfo.class);
        //UserInfo client = gson.fromJson(new BufferedReader(new FileReader("jsonFiles/users.json")), UserInfo.class);
        //System.out.println(client.toString());
        passwd= client.getUserInfo().get(index).getPersonalData().getPasswd();
        newPassword = client.getUserInfo().get(index).getPersonalData().setPasswd1(newPassword);
        System.out.println("Old Password : "+passwd);
        System.out.println("New Password : "+newPassword);
        String json = gson.toJson(client);
        FileWriter writer = new FileWriter("src/main/resources/jsonFiles/users.json");
        writer.write(json);

        writer.close();

    }
}

