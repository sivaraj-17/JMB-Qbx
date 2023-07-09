package pageObjects;

import org.testng.Assert;

import utils.Q_PM_Init;

public class Q_PM_TicketsObjects extends Q_PM_Init {

    public Q_PM_TicketsObjects formIntegerInputXp(String locator, Integer inputValue) {
        Q_PM_WebElm.xpClear(ticketsProp, locator);
        Q_PM_WebElm.xpSend(ticketsProp, locator, String.valueOf(inputValue));
        return this;
    }
    public Q_PM_TicketsObjects formXp(String locator) {
        Q_PM_WebElm.xp(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xp(ticketsProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_TicketsObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_PM_WebElm.xp(ticketsProp, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_PM_TicketsObjects formInputXp(String locator, String inputValue) {
        Q_PM_WebElm.xpClear(ticketsProp, locator);
        Q_PM_WebElm.xpSend(ticketsProp, locator, inputValue);
        return this;
    }

    public Q_PM_TicketsObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_PM_WebElm.xpClear(ticketsProp, begXp, lineItem, endXP);
        Q_PM_WebElm.xpSend(ticketsProp, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_PM_WebElm.xpRetText(ticketsProp, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetText(ticketsProp, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_PM_WebElm.xpRetText(ticketsProp, begXp, row, midXp, cell, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_PM_WebElm.xpRetTextReplace(ticketsProp, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetTextReplace(ticketsProp, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetTextReplace(ticketsProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_PM_TicketsObjects formReturnText(String locator) {
        Q_PM_WebElm.xpRetText(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpRetText(ticketsProp, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_PM_WebElm.xpRetText(ticketsProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_PM_WebElm.xpRetTextReplace(ticketsProp, locator);
    }

    public Q_PM_TicketsObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpRetTextReplace(ticketsProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_TicketsObjects formReturnAttribute(String locator, String attr) {
        Q_PM_WebElm.xpRetAttr(ticketsProp, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_PM_WebElm.xpRetAttr(ticketsProp, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_PM_WebElm.xpAttribute(ticketsProp, begXp, lineItem, endXp, attr);
    }

    public Q_PM_TicketsObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_PM_WebElm.xpAttribute(ticketsProp, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_PM_TicketsObjects formReturnAttributeReplace(String locator) {
        Q_PM_WebElm.xpReturnAttributeReplace(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_PM_WebElm.xpReturnAttributeReplace(ticketsProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_PM_TicketsObjects formXpDisplayed(String locator) {
        try {
            Q_PM_WebElm.xpDisplayed(ticketsProp, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_PM_TicketsObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpDisplayed(ticketsProp, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_PM_TicketsObjects formXpTab(String locator) {
        Q_PM_WebElm.xpSendTab(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_PM_WebElm.xpSendTab(ticketsProp, begXp, lineItem, endXP);
        return this;
    }

    public Q_PM_TicketsObjects formXpEnter(String locator) {
        Q_PM_WebElm.xpSendEnter(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_PM_WebElm.xpSendEnter(ticketsProp, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_PM_WebElm.xpEnabled(ticketsProp, locator).equals(true);
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpDisplayed(ticketsProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_PM_WebElm.xpSelected(ticketsProp, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_PM_WebElm.xpSelected(ticketsProp, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_PM_WebElm.xpEnabled(ticketsProp, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_PM_WebElm.xpEnabled(ticketsProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_PM_TicketsObjects formXpSelectIndex(String locator, Integer index) {
        Q_PM_WebElm.xpSelectIndex(ticketsProp, locator, index);
        return this;
    }

    public Q_PM_TicketsObjects formXpSelectValue(String locator, String value) {
        Q_PM_WebElm.xpSelectValue(ticketsProp, locator, value);
        return this;
    }

    public Q_PM_TicketsObjects formXpSelectText(String locator, String text) {
        Q_PM_WebElm.xpSelectText(ticketsProp, locator, text);
        return this;
    }

    public Q_PM_TicketsObjects formId(String locator) {
        Q_PM_WebElm.id(ticketsProp, locator);
        return this;
    }

    public Q_PM_TicketsObjects formInputId(String locator, String inputValue) {
        Q_PM_WebElm.idClear(ticketsProp, locator);
        Q_PM_WebElm.idSend(ticketsProp, locator, inputValue);
        return this;
    }

    public Q_PM_TicketsObjects formIdTab(String locator) {
        Q_PM_WebElm.idSendTab(ticketsProp, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_PM_WebElm.idRetText(ticketsProp, locator);
    }

    public static String idStrRet(String locator) {
        return Q_PM_WebElm.idRetText(ticketsProp, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_PM_WebElm.idRetTextRep(ticketsProp, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_PM_WebElm.idAttrRet(ticketsProp, locator, attr);
    }

    public static boolean isIdDisplayed(String locator) {
        return Q_PM_WebElm.idDisplayed(ticketsProp, locator).equals(true);
    }

    public static boolean isIdCheckEnabled(String locator) {
        return Q_PM_WebElm.idEnabled(ticketsProp, locator).equals(true);
    }

    public Q_PM_TicketsObjects formIdSelectIndex(String locator, Integer index) {
        Q_PM_WebElm.idSelectIndex(ticketsProp, locator, index);
        return this;
    }

    public Q_PM_TicketsObjects formIdSelectValue(String locator, String value) {
        Q_PM_WebElm.idSelectValue(ticketsProp, locator, value);
        return this;
    }

    public Q_PM_TicketsObjects formIdSelectText(String locator, String text) {
        Q_PM_WebElm.idSelectText(ticketsProp, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_PM_WebElm.xpCountTableRows(ticketsProp, locator);
        return count;
    }
    
    /**
	 * This method selects the verifies the active Shipping Method
	 * @param shippingMethod
	 */
    public void verifyActiveShippingMethod(String shippingMethod) {
		String value = Q_PM_WebElm.xpRetText(ticketsProp, "chk.activeShippingMethod.xp");
		String[] tempArray = value.split("\n");
		Assert.assertTrue(tempArray[0].contains(shippingMethod), "Verify sipping method '" + tempArray[0] + "' active failed.");
	}


}
