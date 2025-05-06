import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpellbookTest {

    private Spellbook spellbook;

    @BeforeEach
    void setUp(){
        spellbook = new Spellbook();
    }

    @Test
    void testSpellByIndexValid(){
        if (spellbook.getAllSpells().size()>2){
            String spell = spellbook.getSpell(2);
            assertNotNull(spell);
        }
    }

    @Test
    void testSpellByInvalidIndexLow(){
        assertThrows(IndexOutOfBoundsException.class,( )->{
            spellbook.getSpell(-1);

        });
    }

    void testSpellByInvalidIndexHigh(){
        int currentSize = spellbook.getAllSpells().size();
        assertThrows(IndexOutOfBoundsException.class,()->{
            spellbook.getSpell(currentSize);
        });
    }

    void testSpellsByPrefix(){
        List<String> result = spellbook.getSpellsByPrefix("Accio");
        assertNotNull(result);
        if (spellbook.getAllSpells().contains("Accio")){
            assertEquals(1,result.size());
            assertTrue(result.contains("Accio"));
        }else {
            assertTrue(result.isEmpty());
        }
    }

    @Test
    void testSpellsByPrefixPartial() {
        List<String> result = spellbook.getSpellsByPrefix("Ex");
        assertNotNull(result);
        if (result.size() > 0) {
            for(String spell : result) {
                assertTrue(spell.startsWith("Ex"));
            }
        }
    }

    @Test
    void testSpellsByPrefixEmpty() {
        List<String> result = spellbook.getSpellsByPrefix("");
        assertNotNull(result);
        assertEquals(spellbook.getAllSpells().size(), result.size());
    }

    @Test
    void testSpellsByPrefixNoMatching() {
        List<String> result = spellbook.getSpellsByPrefix("NotExistPrefix.");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSpellsByPrefixNull() {
        List<String> result = spellbook.getSpellsByPrefix(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


}
