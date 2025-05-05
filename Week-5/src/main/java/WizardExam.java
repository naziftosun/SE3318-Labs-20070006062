import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class WizardExam {

    private List<String> requiredSpells;

    /**
     * Creates a new wizardexam instance.
     * Requires: requiredspells is not null.
     * Effects: initializes the exam with list of spells.
     */
    public WizardExam(List<String> requiredSpells){
        Objects.requireNonNull(requiredSpells, "The list can not be null.");
        if (requiredSpells.isEmpty()){
            throw new IllegalArgumentException("There should be one spell at least.");
        }
        this.requiredSpells = new ArrayList<>(requiredSpells);

    }

    /**
     * Returns a list of spells.
     * Effects: returns a new list containing the required spells.
     */
    public List<String> getRequiredSpells(){
        return new ArrayList<>(this.requiredSpells);
    }

    /**
     * Checks if a student knows all spells.
     * Requires: students is not null.
     * Effects: returns true if the student knows every spell in exam.
     */
    public boolean pass(HogwartsStudent student) {
        if (student == null) {
            return false;
        }

        for (String requiredSpell : this.requiredSpells) {
            if (!student.knowsSpell(requiredSpell)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluate prformance of student.
     * Requires: student should not be null.
     * Effects: checks if the student passed the exam.
     */
    public void evaluate(HogwartsStudent student) {
        if (student == null) {
            System.out.println("Evaluation cannot be null.");
            return;
        }

        boolean didPass = this.pass(student);

        if (didPass) {
            System.out.println(student.getName() + " passed the exam.");
        } else {
            System.out.println(student.getName() + " failed the exam.");
        }
    }

}
