package utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static <T> Object[][] jsonFileParser(Class<T> classOfT, String pathToJsonFile, String jsonDataPattern) {

        JsonElement jsonData = null;
        List<JsonElement> dataSet = new ArrayList<>();
        int numOfDataSet = 1;
        Gson gson = new Gson();
        List<T> testDataEntities = new ArrayList<>();
        Object[][] returnValue;

        try {
            jsonData = new JsonParser().parse(new FileReader(pathToJsonFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        do {
            dataSet.add(jsonData.getAsJsonObject().get(jsonDataPattern + numOfDataSet));
            ++numOfDataSet;
        } while (dataSet.get(numOfDataSet - 2) != null);
        // Subtract 2 because ++ happens first (1)
        // and from begining variable is indented from standard array numerization by one (2)
        dataSet.remove(numOfDataSet - 2);

        for (JsonElement el : dataSet) {
            testDataEntities.add(gson.fromJson(el, classOfT));
        }

        returnValue = new Object[testDataEntities.size()][1];
        for (int i = 0; i < testDataEntities.size(); ++i) {
            returnValue[i][0] = testDataEntities.get(i);
        }
        return returnValue;
    }
}
