package hw;

import hw.DTO.NativeTestDTO;
import org.testng.annotations.DataProvider;

import static utils.Parser.jsonFileParser;

public class DataProviders {

    private static String nativeTestDataJsonDataPath;
    private static String nativeTestDataJsonDataNamePattern;

    public static void setNativeTestDataJsonDataPath(String dataPath) {

        DataProviders.nativeTestDataJsonDataPath = dataPath;
    }

    public static void setNativeTestDataJsonDataNamePattern(String namePattern) {

        DataProviders.nativeTestDataJsonDataNamePattern = namePattern;
    }

    @DataProvider
    public Object[][] nativeTestDataProvider() {

        return jsonFileParser(NativeTestDTO.class,
                nativeTestDataJsonDataPath,
                nativeTestDataJsonDataNamePattern);
    }

}