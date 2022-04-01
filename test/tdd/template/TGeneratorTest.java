package tdd.template;

import org.junit.Test;

import java.util.Map;

public class TGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateHasKeyWhichMapHaveNo() {
        TGenerator tGenerator = new TGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Петр");
        tGenerator.produce(template, keys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whetMapHasExcessKey() {
        TGenerator tGenerator = new TGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Петр", "subject", "Арсентьев", "not", "not available");
        tGenerator.produce(template, keys);
    }
}
