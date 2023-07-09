package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Q_PM_ResourceUtils {

    public static Properties getAccountProperties()
    {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/pm.account.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getCartProperties()
    {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/pm.cart.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getCheckoutProperties()
    {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/pm.checkout.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties pmQaProperties()
    {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/pmQa.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties adminProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/admin.properties");
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
    public static Properties ticketsProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/PM.tickets.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties newFeaturesProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = Q_PM_ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/PM.newFeatures.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
}
