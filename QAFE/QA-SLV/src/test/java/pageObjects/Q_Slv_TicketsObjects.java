package pageObjects;

import org.testng.Assert;

import utils.Q_Slv_Init;

public class Q_Slv_TicketsObjects extends Q_Slv_Init {

    public Q_Slv_TicketsObjects formXp(String locator) {
        Q_Slv_WebElm.xp(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formXp(String begXp, Integer lineItem, String endXp) {
        Q_Slv_WebElm.xp(SLVqProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_Slv_TicketsObjects formXp(String begXp, Integer row, String midXp, Integer column, String endXp) {
        Q_Slv_WebElm.xp(SLVqProp, begXp, row, midXp, column, endXp);
        return this;
    }

    public Q_Slv_TicketsObjects formInputXp(String locator, String inputValue) {
        Q_Slv_WebElm.xpClear(SLVqProp, locator);
        Q_Slv_WebElm.xpSend(SLVqProp, locator, inputValue);
        return this;
    }

    public Q_Slv_TicketsObjects formInputXp(String begXp, Integer lineItem, String endXP, String inputValue) {
        Q_Slv_WebElm.xpClear(SLVqProp, begXp, lineItem, endXP);
        Q_Slv_WebElm.xpSend(SLVqProp, begXp, lineItem, endXP, inputValue);
        return this;
    }

    public static String strXpText(String locator) {
        return Q_Slv_WebElm.xpRetText(SLVqProp, locator);
    }

    public static String strXpText(String begXp, Integer lineItem, String endXp) {
        return Q_Slv_WebElm.xpRetText(SLVqProp, begXp, lineItem, endXp);
    }

    public static String strXpText(String begXp, Integer row, String midXp, Integer cell, String endXp) {
        return Q_Slv_WebElm.xpRetText(SLVqProp, begXp, row, midXp, cell, endXp);
    }

    public static String numberReturn(String locator) {
        return Q_Slv_WebElm.xpRetTextReplace(SLVqProp, locator);
    }

    public static String numberReturn(String begXp, Integer lineItem, String endXp) {
        return Q_Slv_WebElm.xpRetTextReplace(SLVqProp, begXp, lineItem, endXp);
    }

    public static String numberReturn(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_Slv_WebElm.xpRetTextReplace(SLVqProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public Q_Slv_TicketsObjects formReturnText(String locator) {
        Q_Slv_WebElm.xpRetText(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formReturnText(String begXp, Integer lineItem, String endXp) {
        Q_Slv_WebElm.xpRetText(SLVqProp, begXp, lineItem, endXp);
        return this;
    }

    public static String formReturnText(String begXp, Integer recordNumber, String midXp, Integer lineItem, String endXp) {
        return Q_Slv_WebElm.xpRetText(SLVqProp, begXp, recordNumber, midXp, lineItem, endXp);
    }

    public static String formReturnTextReplace(String locator) {
        return Q_Slv_WebElm.xpRetTextReplace(SLVqProp, locator);
    }

    public Q_Slv_TicketsObjects formReturnTextReplace(String begXp, Integer lineItem, String endXp) {
        Q_Slv_WebElm.xpRetTextReplace(SLVqProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_Slv_TicketsObjects formReturnAttribute(String locator, String attr) {
        Q_Slv_WebElm.xpRetAttr(SLVqProp, locator, attr);
        return this;
    }

    public static String attReturn(String locator, String attr) {
        return Q_Slv_WebElm.xpRetAttr(SLVqProp, locator, attr);

    }

    public static String attReturn(String begXp, Integer lineItem, String endXp, String attr) {
        return Q_Slv_WebElm.xpAttribute(SLVqProp, begXp, lineItem, endXp, attr);
    }

    public Q_Slv_TicketsObjects formReturnAttribute(String begXp, Integer lineItem, String endXp, String attr) {
        Q_Slv_WebElm.xpAttribute(SLVqProp, begXp, lineItem, endXp, attr);
        return this;
    }

    public Q_Slv_TicketsObjects formReturnAttributeReplace(String locator) {
        Q_Slv_WebElm.xpReturnAttributeReplace(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formReturnAttributeReplace(String begXp, Integer lineItem, String endXp) {
        Q_Slv_WebElm.xpReturnAttributeReplace(SLVqProp, begXp, lineItem, endXp);
        return this;
    }

    public Q_Slv_TicketsObjects formXpDisplayed(String locator) {
        try {
            Q_Slv_WebElm.xpDisplayed(SLVqProp, locator).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_Slv_TicketsObjects formXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_Slv_WebElm.xpDisplayed(SLVqProp, begXp, lineItem, endXP).equals(true);
        } catch (Throwable ex) {
            System.out.println(ex);
        }
        return this;
    }

    public Q_Slv_TicketsObjects formXpTab(String locator) {
        Q_Slv_WebElm.xpSendTab(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formXpTab(String begXp, Integer lineItem, String endXP) {
        Q_Slv_WebElm.xpSendTab(SLVqProp, begXp, lineItem, endXP);
        return this;
    }

    public Q_Slv_TicketsObjects formXpEnter(String locator) {
        Q_Slv_WebElm.xpSendEnter(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formXpEnter(String begXp, Integer lineItem, String endXP) {
        Q_Slv_WebElm.xpSendEnter(SLVqProp, begXp, lineItem, endXP);
        return this;
    }

    public static boolean isXpDisplayed(String locator) {
        return Q_Slv_WebElm.xpEnabled(SLVqProp, locator).equals(true);
    }

    public static boolean isXpDisplayed(String begXp, Integer lineItem, String endXP) {
        try {
            Q_Slv_WebElm.xpDisplayed(SLVqProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static boolean isXpCheckSelected(String locator) {
        return Q_Slv_WebElm.xpSelected(SLVqProp, locator).equals(true);
    }

    public static boolean isXpCheckSelected(String begXp, Integer lineItem, String endXP) {
        return Q_Slv_WebElm.xpSelected(SLVqProp, begXp, lineItem, endXP).equals(true);
    }

    public static boolean isXpCheckEnabled(String locator) {
        return Q_Slv_WebElm.xpEnabled(SLVqProp, locator).equals(true);
    }

    public static boolean isXpCheckEnabled(String begXp, Integer lineItem, String endXP) {
        try {
            Q_Slv_WebElm.xpEnabled(SLVqProp, begXp, lineItem, endXP).equals(true);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }

    public Q_Slv_TicketsObjects formXpSelectIndex(String locator, Integer index) {
        Q_Slv_WebElm.xpSelectIndex(SLVqProp, locator, index);
        return this;
    }

    public Q_Slv_TicketsObjects formXpSelectValue(String locator, String value) {
        Q_Slv_WebElm.xpSelectValue(SLVqProp, locator, value);
        return this;
    }

    public Q_Slv_TicketsObjects formXpSelectText(String locator, String text) {
        Q_Slv_WebElm.xpSelectText(SLVqProp, locator, text);
        return this;
    }

    public Q_Slv_TicketsObjects formId(String locator) {
        Q_Slv_WebElm.id(SLVqProp, locator);
        return this;
    }

    public Q_Slv_TicketsObjects formInputId(String locator, String inputValue) {
        Q_Slv_WebElm.idClear(SLVqProp, locator);
        Q_Slv_WebElm.idSend(SLVqProp, locator, inputValue);
        return this;
    }

    public Q_Slv_TicketsObjects formIdTab(String locator) {
        Q_Slv_WebElm.idSendTab(SLVqProp, locator);
        return this;
    }

    public static String strIdText(String locator) {
        return Q_Slv_WebElm.idRetText(SLVqProp, locator);
    }

    public static String idStrRet(String locator) {
        return Q_Slv_WebElm.idRetText(SLVqProp, locator);
    }

    public static String idNumberReturn(String locator) {
        return Q_Slv_WebElm.idRetTextRep(SLVqProp, locator);
    }

    public static String idAttRet(String locator, String attr) {
        return Q_Slv_WebElm.idAttrRet(SLVqProp, locator, attr);
    }

    public static boolean isIdDisplayed(String locator) {
        return Q_Slv_WebElm.idDisplayed(SLVqProp, locator).equals(true);
    }

    public static boolean isIdCheckEnabled(String locator) {
        return Q_Slv_WebElm.idEnabled(SLVqProp, locator).equals(true);
    }

    public Q_Slv_TicketsObjects formIdSelectIndex(String locator, Integer index) {
        Q_Slv_WebElm.idSelectIndex(SLVqProp, locator, index);
        return this;
    }

    public Q_Slv_TicketsObjects formIdSelectValue(String locator, String value) {
        Q_Slv_WebElm.idSelectValue(SLVqProp, locator, value);
        return this;
    }

    public Q_Slv_TicketsObjects formIdSelectText(String locator, String text) {
        Q_Slv_WebElm.idSelectText(SLVqProp, locator, text);
        return this;
    }

    public static Integer rowCount(String locator) {
        Integer count = Q_Slv_WebElm.xpCountTableRows(SLVqProp, locator);
        return count;
    }
    
    /**
	 * This method selects the verifies the active Shipping Method
	 * @param shippingMethod
	 */
    public void verifyActiveShippingMethod(String shippingMethod) {
		String value = Q_Slv_WebElm.xpRetText(ticketsProp, "chk.activeShippingMethod.xp");
		String[] tempArray = value.split(".99");
		Assert.assertEquals(tempArray[1].trim().replace("\n", ""), shippingMethod ,"Verify sipping method '" + tempArray[1].trim().replace("\n", "") + "' active failed.");
	}
    
}
