package utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils() {
    }

    /**
     * This method is used in pom to change xPath with a wildcard to the xPath with text
     *
     * @param xPath
     * @param text
     * @return formatted Xpath; Example: //a[text()='%s'] --> //a[text()='text']
     */
    public static String getXpath(String xPath, String text) {
        return String.format(xPath, text);
    }

    /**
     * This method is used in pom to change xPath with a wildcard to the xPath with text
     *
     * @param xPath
     * @param text1
     * @param text2
     * @return formatted Xpath; Example: //div[text()=’%s’]/parent::a[text()=’%s’] --> //div[text()=’text1’]/parent::a[text()=’text2’]
     */
    public static String getXpath(String xPath, String text1, String text2) {
        return String.format(xPath, text1, text2);
    }
}
