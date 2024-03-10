package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Zikmund"));
        assertFalse(svatky.jeVSeznamu("NeexistujiciJmeno"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("NovySvatek", 1, 1);
        assertTrue(svatky.jeVSeznamu("NovySvatek"));
        assertEquals(MonthDay.of(1, 1), svatky.vratKdyMaSvatek("NovySvatek"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("NovySvatek", 1, Month.JANUARY);
        assertTrue(svatky.jeVSeznamu("NovySvatek"));
        assertEquals(MonthDay.of(1, 1), svatky.vratKdyMaSvatek("NovySvatek"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("NovySvatek", MonthDay.of(1, 1));
        assertTrue(svatky.jeVSeznamu("NovySvatek"));
        assertEquals(MonthDay.of(1, 1), svatky.vratKdyMaSvatek("NovySvatek"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        int originalCount = svatky.getPocetJmen();
        svatky.smazSvatek("Zikmund");
        assertEquals(originalCount - 1, svatky.getPocetJmen());
        assertNull(svatky.vratKdyMaSvatek("Zikmund"));
    }
}
