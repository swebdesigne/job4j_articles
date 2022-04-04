package tdd.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateHasKeyWhichMapHaveNo() {
        TGenerator tGenerator = new TGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Петр");
        tGenerator.produce(template, keys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExcessKey() {
        TGenerator tGenerator = new TGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> keys = Map.of("name", "Петр", "subject", "Арсентьев", "not", "not available");
        tGenerator.produce(template, keys);
    }


}
