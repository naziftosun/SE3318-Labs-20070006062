import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MagicClassroomTest {

    private MagicClassroom classroom;
    private HogwartsStudent harry;
    private HogwartsStudent hermione;
    private HogwartsStudent ron;

    @BeforeEach
    void setUp(){
        classroom = new MagicClassroom();
        harry = new HogwartsStudent("Harry Potter","Gryffindor",1);
        hermione = new HogwartsStudent("Hermione Granger","Gryffindor",1);
        ron = new HogwartsStudent("Ron Weasley","Gryffindor",1);

        harry.learnSpell("Expelliarmus");
        hermione.learnSpell("Wingardium Leviosa");
        hermione.learnSpell("Alohomora");


    }

    @Test
    void testAddNullStudent() {
        boolean added = classroom.addStudent(null);
        assertFalse(added);
    }
    @Test
    void testFindStudentByName() {

        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        HogwartsStudent found = classroom.findStudent("Harry Potter");
        assertNotNull(found);
        assertEquals("Harry Potter", found.getName());

    }


    @Test
    void testFindStudentByNameNotExist() {
        classroom.addStudent(harry);
        HogwartsStudent found = classroom.findStudent("Draco Malfoy");
        assertNull(found);

    }
    @Test
    void testFindStudentByNameNullOrEmpty() {
        assertNull(classroom.findStudent(null));
        assertNull(classroom.findStudent(""));
        assertNull(classroom.findStudent("   "));

    }

    @Test
    void testFindStudentBySpell() {
        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        HogwartsStudent found = classroom.findStudentBySpell("Alohomora");
        assertNotNull(found);
        assertEquals("Hermione Granger", found.getName());

    }

    @Test
    void testFindStudentBySpellNotExist() {
        classroom.addStudent(harry);
        HogwartsStudent found = classroom.findStudentBySpell("Avada Kedavra");
        assertNull(found);

    }


    @Test
    void testFindStudentBySpellNullOrEmpty() {
        assertNull(classroom.findStudentBySpell(null));
        assertNull(classroom.findStudentBySpell(""));
        assertNull(classroom.findStudentBySpell("  "));
    }

    @Test
    void testStudentByHouse(){

        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy","Slytherin",1);
        classroom.addStudent(draco);

        List<HogwartsStudent> gryffindors = classroom.getStudentsByHouse("Gryffindor");
        assertEquals(2,gryffindors.size());
        assertTrue(gryffindors.contains(harry));
        assertTrue(gryffindors.contains(hermione));

        List<HogwartsStudent> slytherins = classroom.getStudentsByHouse("Slytherin");
        assertEquals(1,slytherins.size());
        assertTrue(slytherins.contains(draco));

        List<HogwartsStudent> hufflepuffs = classroom.getStudentsByHouse("Hufflepuff");
        assertTrue(hufflepuffs.isEmpty());
    }


    @Test
    void testStudentSortedByHouse(){
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy","Slytherin",1);
        HogwartsStudent cedric = new HogwartsStudent("Cedric Diggory","Hufflepuff",4);

        classroom.addStudent(hermione);
        classroom.addStudent(draco);
        classroom.addStudent(harry);
        classroom.addStudent(cedric);
        classroom.addStudent(ron);

        List<HogwartsStudent> sorted = classroom.getStudentsSortedByHouse();
        assertEquals(5,sorted.size());

        assertEquals("Gryffindor",sorted.get(0).getHouse());
        assertEquals("Harry Potter",sorted.get(0).getName());

        assertEquals("Gryffindor",sorted.get(1).getHouse());
        assertEquals("Hermione Granger",sorted.get(1).getName());

        assertEquals("Gryffindor",sorted.get(2).getHouse());
        assertEquals("Ron Weasley",sorted.get(2).getName());

        assertEquals("Hufflepuff",sorted.get(3).getHouse());
        assertEquals("Cedric Diggory",sorted.get(3).getName());

        assertEquals("Slytherin",sorted.get(4).getHouse());
        assertEquals("Draco Malfoy",sorted.get(4).getName());
    }



}
