package hw;

import hw.DTO.NativeTestDTO;
import hw.DTO.WebMobileTestDTO;
import org.testng.annotations.DataProvider;

import static utils.Parser.jsonFileParser;

public class DataProviders {

    private static String nativeTestDataJsonDataPath;
    private static String nativeTestDataJsonDataNamePattern;
    private static String webTestDataJsonDataPath;
    private static String webTestDataJsonDataNamePattern;

    public static void setNativeTestDataJsonDataPath(String dataPath) {

        DataProviders.nativeTestDataJsonDataPath = dataPath;
    }

    public static void setNativeTestDataJsonDataNamePattern(String namePattern) {

        DataProviders.nativeTestDataJsonDataNamePattern = namePattern;
    }

    public static void setWebTestDataJsonDataPath(String webTestDataJsonDataPath) {

        DataProviders.webTestDataJsonDataPath = webTestDataJsonDataPath;
    }

    public static void setWebTestDataJsonDataNamePattern(String webTestDataJsonDataNamePattern) {

        DataProviders.webTestDataJsonDataNamePattern = webTestDataJsonDataNamePattern;
    }

    @DataProvider
    public Object[][] nativeTestDataProvider() {

        return jsonFileParser(NativeTestDTO.class,
                nativeTestDataJsonDataPath,
                nativeTestDataJsonDataNamePattern);
    }

    @DataProvider
    public Object[][] webTestDataProvider() {

        return jsonFileParser(WebMobileTestDTO.class,
                webTestDataJsonDataPath,
                webTestDataJsonDataNamePattern);
    }

}