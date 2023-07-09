package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Q_Slv_ResourceUtils {
    public static Properties ticketsProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_Slv_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/sil.tickets.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties newFeaturesProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_Slv_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/sil.newFeatures.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties SLVqProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_Slv_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/SLVq.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getAccountPropertiesAsFile(String path)
    {
        Properties acctProps = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            acctProps.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getCartPropertiesAsFile(String path)
    {
        Properties cartProps = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            cartProps.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartProps;
    }

}