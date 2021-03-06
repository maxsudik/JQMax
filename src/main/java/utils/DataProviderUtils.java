package utils;

import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.*;

public final class DataProviderUtils {
    private DataProviderUtils() {
    }

    @DataProvider(parallel = true)
    public static Iterator<Object[]> getData(Method method) {
        String testName = method.getName();
        List<Map<String, String>> listOfTests = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
        List<Map<String, String>> testsToExecuteList = new ArrayList<>();

        for (int i = 0; i < listOfTests.size(); i++) {
            if (listOfTests.get(i).get("testname").equalsIgnoreCase(testName) && listOfTests.get(i).get("execute").equalsIgnoreCase("yes")) {
                testsToExecuteList.add(listOfTests.get(i));
            }
        }
        Collection<Object[]> dataProvider = new ArrayList<>();
        for (Map<String, String> map : testsToExecuteList) {
            dataProvider.add(new Object[]{map});
        }
        return dataProvider.iterator();
    }
}