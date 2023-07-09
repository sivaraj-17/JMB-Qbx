package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceUtils {

    public static Properties getAdminProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/beJMBQ.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
//    public static Properties getOrderProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.order.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getShippingProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.shipping.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getReceiptsProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.receipts.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getBBProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.buyback.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getProductProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.products.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getCheckoutProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.checkout.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getSettingsProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.settings.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getOnHoldProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.onHold.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
//    public static Properties getCustomerProperties() {
//        Properties acctProps = new Properties();
//        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.customer.properties");
//        try {
//            acctProps.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return acctProps;
//    }
    public static Properties getSanityProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.sanity.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getTicketsProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/JMBE.tickets.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
    public static Properties getNewFeaturesProperties() {
        Properties acctProps = new Properties();
        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("elementProperties/newFeatures.properties");
        try {
            acctProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acctProps;
    }
}
