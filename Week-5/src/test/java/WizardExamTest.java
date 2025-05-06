import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WizardExamTest {

    private HogwartsStudent harry;
    private HogwartsStudent hermione;
    private WizardExam examKnownSpells;
    private WizardExam examUnknownSpells;


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp(){
        harry = new HogwartsStudent("Harry Potter", "Gryffindor", 1);
        harry.learnSpell("Lumos");
        harry.learnSpell("Expelliarmus");

        hermione = new HogwartsStudent("Hermione Granger", "Gryffindor", 1);
        hermione.learnSpell("Wingardium Leviosa");

        List<String> spellsHarryKnows = new ArrayList<>(Arrays.asList("Lumos","Expelliarmus"));
        examKnownSpells = new WizardExam(spellsHarryKnows);

        List<String> spellsHarryDoesNotKnows = new ArrayList<>(Arrays.asList("Lumos","Alohomora"));
        examUnknownSpells = new WizardExam(spellsHarryDoesNotKnows);

        System.setOut(new PrintStream(outContent));
        outContent.reset();

    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    void testPassTrueWhenSpellsKnown(){
        assertTrue(examKnownSpells.pass(harry));
    }

    @Test
    void testPassFalseWhenNotSpellsKnown(){
        assertFalse(examUnknownSpells.pass(harry));
    }

    @Test
    void testPassFalseWhenStudentKnowsNone(){
        assertFalse(examKnownSpells.pass(hermione));
    }

    @Test
    void testEvaluatePassMessage(){
        examKnownSpells.evaluate(harry);
        String consoleOutput = outContent.toString().trim();
        assertEquals("Harry Potter passed the exam.",consoleOutput);
    }

    @Test
    void testEvaluateFailMessage(){
        examUnknownSpells.evaluate(harry);
        String consoleOutput = outContent.toString().trim();
        assertEquals("Harry Potter failed the exam.",consoleOutput);
    }

}
