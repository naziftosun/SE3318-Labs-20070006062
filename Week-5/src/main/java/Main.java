import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Magical demo starting.");
        System.out.println("----------------------");

        HogwartsStudent harry = new HogwartsStudent("Harry Potter","Gryffindor",1);
        HogwartsStudent hermione = new HogwartsStudent("Hermione Granger","Gryffindor",1);
        HogwartsStudent ron = new HogwartsStudent("Ron Weasley","Gryffindor",1);
        HogwartsStudent draco = new HogwartsStudent("Draco Malfoy","Slytherin",1);

        System.out.println(harry.getName() + " learning expelliarmus: " + harry.learnSpell("Expelliarmus"));
        System.out.println(hermione.getName() + " learning wingardium leviosa: " + hermione.learnSpell("Wingardium Leviosa"));
        System.out.println(hermione.getName() + " learning alohomora: " + hermione.learnSpell("Alohomora"));
        System.out.println(ron.getName() + " learning lumos: " + ron.learnSpell("Lumos"));
        System.out.println(ron.getName() + " learning lumos again:" + ron.learnSpell("Lumos"));
        System.out.println(harry.getName() + " learning null spell: " + harry.learnSpell(null));
        System.out.println(hermione.getName() + " knows alohomora: " + hermione.knowsSpell("Alohomora"));
        System.out.println(ron.getName() + " knows wingardium leviosa:" + ron.knowsSpell("Wingardium Leviosa"));

        Spellbook spellbook = new Spellbook();
        System.out.println("All spells:"+ spellbook.getAllSpells());
        System.out.println("Spell at index 2 is "+ spellbook.getSpell(2));

        String prefix1 = "Ex";
        List<String> spellsWithEx = spellbook.getSpellsByPrefix(prefix1);
        System.out.println("Spells starting with '" + prefix1 + "': " + spellsWithEx);
        String prefix2 = "Alo";
        List<String> spellsWithAlo = spellbook.getSpellsByPrefix(prefix2);
        System.out.println("Spells starting with '" + prefix2 + "': " + spellsWithAlo);
        String prefix3 = "";
        List<String> allSpellsCopy = spellbook.getSpellsByPrefix(prefix3);
        System.out.println("Spells starting with empty prefix (count): " + allSpellsCopy.size());

        MagicClassroom classroom = new MagicClassroom();
        classroom.addStudent(harry);
        classroom.addStudent(hermione);
        classroom.addStudent(ron);
        classroom.addStudent(draco);
        classroom.addStudent(null);

        String searchName1 = "Ron Weasley";
        HogwartsStudent foundStudent1 = classroom.findStudent(searchName1);
        if (foundStudent1 != null) {
            System.out.println("Found student by name " + searchName1+": " + foundStudent1.getName());
        } else {
            System.out.println("Student with name" + searchName1 + "not found.");
        }
        String searchName2 = "Luna Lovegood";
        HogwartsStudent foundStudent2 = classroom.findStudent(searchName2);
        if (foundStudent2 != null) {
            System.out.println("Found student by name " + searchName2 + ": " + foundStudent2.getName());
        } else {
            System.out.println("Student with name " + searchName2 + " not found.");
        }

        String searchSpell1 = "Alohomora";
        HogwartsStudent foundStudent3 = classroom.findStudentBySpell(searchSpell1);
        if (foundStudent3 != null) {
            System.out.println("Found student who knows" + searchSpell1 + ": " + foundStudent3.getName());
        } else {
            System.out.println("No student found who knows '" + searchSpell1 + ".");
        }
        String searchSpell2 = "Avada Kedavra";
        HogwartsStudent foundStudent4 = classroom.findStudentBySpell(searchSpell2);
        if (foundStudent4 != null) {
            System.out.println("Found student who knows " + searchSpell2 + ": " + foundStudent4.getName());
        } else {
            System.out.println("No student found who knows" + searchSpell2 + ".");
        }

        List<String> examSpells = new ArrayList<>(Arrays.asList("Lumos", "Wingardium Leviosa"));

        WizardExam charmsExam = new WizardExam(examSpells);
        System.out.println("Exam requires:" + charmsExam.getRequiredSpells());
        charmsExam.evaluate(hermione);
        charmsExam.evaluate(ron);
        charmsExam.evaluate(harry);

        Duel.start(hermione, ron, "Wingardium Leviosa");
        Duel.start(harry, draco, "Expecto Patronum");
        System.out.println(hermione.getName() + " learning expelliarmus: " + hermione.learnSpell("Expelliarmus"));
        Duel.start(harry, hermione, "Expelliarmus");
        Duel.start(harry, null, "Accio");
    }
}
