import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HogwartsStudentTest {

    private HogwartsStudent student;
    private final String spell1 = "Expelliarmus";
    private final String spell2 = "Lumos";

    @BeforeEach
    void setUp(){
        student = new HogwartsStudent("Test Student","Gryffindor",1);

    }
    @Test
    void learnNewValidSpell(){
        boolean learned = student.learnSpell(spell1);
        assertTrue(learned);
        assertTrue(student.knowsSpell(spell1));
        assertEquals(1,student.getSpellsLearned().size());


    }

    @Test
    void learnNullSpell(){
        boolean learned = student.learnSpell(null);
        assertFalse(learned);
        assertEquals(0,student.getSpellsLearned().size());

    }
    @Test
    void testLearnEmptySpell(){
        boolean learned = student.learnSpell("   ");
        assertFalse(learned);
        assertEquals(0,student.getSpellsLearned().size());
    }
    @Test
    void testLearnAlreadyKnowSpell(){
        student.learnSpell(spell1);
        boolean learnedAgain = student.learnSpell(spell1);
        assertFalse(learnedAgain);
        assertEquals(1,student.getSpellsLearned().size());
    }
    @Test
    void testKnowsSpellReturnsCorrectResult(){
        assertFalse(student.knowsSpell(spell1));
        student.learnSpell(spell1);
        assertTrue(student.knowsSpell(spell1));
        assertFalse(student.knowsSpell(spell2));
        assertFalse(student.knowsSpell(null));
        assertFalse(student.knowsSpell(""));
    }


}
