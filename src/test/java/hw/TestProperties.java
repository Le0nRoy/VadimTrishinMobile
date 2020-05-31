package hw;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestProperties {

    private String nativeTestDataJsonDataPath;
    private String nativeTestDataJsonDataNamePattern;
    private String webTestDataJsonDataPath;
    private String webTestDataJsonDataNamePattern;
}
