import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DuelTest {

    private HogwartsStudent s1;
    private HogwartsStudent s2;
    private final String commonSpell = "Expelliarmus";
    private final String onlySpell = "Lumos";
    private final String unknownSpell = "AvadaKedavra";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp(){
        s1 = new HogwartsStudent("Student One", "Gryffindor", 1);
        s2 = new HogwartsStudent("Student Two", "Slytherin", 1);

        s1.learnSpell(commonSpell);
        s1.learnSpell(onlySpell);
        s2.learnSpell(commonSpell);

        System.setOut(new PrintStream(outContent));
        outContent.reset();

    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testDuelBothKnow(){
        Duel.start(s1, s2, commonSpell);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("Both students know the spell."));
    }

    @Test
    void testDuelS1Know() {
        Duel.start(s1, s2, onlySpell);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains(s1.getName()+"knows the spell and wins."));

    }

    @Test
    void testDuelNoneOfThemKnows(){
        Duel.start(s1, s2, unknownSpell);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("non of them knows.It's draw."));

    }

    @Test
    void testDuelNullStudent1(){
        Duel.start(null, s2, commonSpell);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("Invalid duel setup."));
    }

    @Test
    void testDuelNullSpell(){
        Duel.start(s1, s2, null);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("Invalid duel setup."));

    }

    @Test
    void testDuelWithEmptySpell(){
        Duel.start(s1, s2, "  ");
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("Invalid duel setup."));
    }

}
