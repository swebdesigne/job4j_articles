package ood.isp.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TODOAppTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void whenAddTasksThenPrintOnConsole() {
        TODOApp todoApp = new TODOApp(
                new TreeMap<>(
                        Map.of(
                                "1", new AddMenu(),
                                "2", new ShowMenu(),
                                "3", new Exit()
                        )
                )
        );
        todoApp.add(Menu.ROOT, "Создание задачи", STUB_ACTION);
        todoApp.add(Menu.ROOT, "Настройки планировщика", STUB_ACTION);
        todoApp.add("Настройки планировщика", "Ежедневный запуск задачи", STUB_ACTION);
        todoApp.add("Настройки планировщика", "Запуск задачи через день", STUB_ACTION);
        todoApp.add("Настройки планировщика", "Отложенный ежедневный запуск задачи", STUB_ACTION);
        todoApp.add("Отложенный ежедневный запуск задачи", "Время запуска", STUB_ACTION);
        todoApp.add(Menu.ROOT, "Тестовый запуск задачи", STUB_ACTION);
        todoApp.print(todoApp.getMenu());
        String ln = System.lineSeparator();
        assertEquals(
                "1. Создание задачи" + ln
                + "2. Настройки планировщика" + ln
                + "---- 2.1. Ежедневный запуск задачи" + ln
                + "---- 2.2. Запуск задачи через день" + ln
                + "---- 2.3. Отложенный ежедневный запуск задачи" + ln
                + "-------- 2.3.1. Время запуска" + ln
                + "3. Тестовый запуск задачи" + ln, outputStreamCaptor.toString());
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}