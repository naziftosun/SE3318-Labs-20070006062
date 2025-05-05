import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HogwartsStudent {

    private String name;
    private String house;
    private int year;

    private List<String> spellsLearned;

    /**
     *Creates a new hogwarts student instance.
     * requires: name is not null and not empty,house is not null,year is positive integer.
     * effects: Initializes a new HogwartsStudent object.
     */
    public HogwartsStudent(String name, String house, int year) {

        Objects.requireNonNull(name, "Student name cannot be null.");
        Objects.requireNonNull(house, "Student house cannot be null.");
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        if (house.trim().isEmpty()) {
            throw new IllegalArgumentException("Student house cannot be empty.");
        }
        if (year <= 0) {

            throw new IllegalArgumentException("Year must be positive.");
        }

        this.name = name;
        this.house = house;
        this.year = year;
        this.spellsLearned = new ArrayList<>();

    }

    /**
     * Returns the name of the student.
     * Effects: Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the house of the student.
     */
    public String getHouse() {
        return house;
    }

    /**
     * Returns the year of the sttudent.
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns a list of spells learned by student.
     * Effects: retuns list the spells the students knows.
     */
    public List<String> getSpellsLearned() {
        return new ArrayList<>(spellsLearned);
    }

    /**
     * Adds a spell to student's list.
     * Requires: the input spell string is not null.
     * Effects: If the spell is valid and student does not already know the spell, the spell is added.
     */
    public boolean learnSpell(String spell) {
        if (spell == null || spell.trim().isEmpty()) {
            return false;
        }
        if (!this.spellsLearned.contains(spell)) {
            this.spellsLearned.add(spell);
            return true;
        }
        return false;
    }

    /**
     * Checks if student knows a spell.
     * Requires: the spell is not null.
     * Effects: returns true if the spell is valid.
     */
    public boolean knowsSpell(String spell) {
        if (spell == null || spell.trim().isEmpty()) {
            return false;
        }
        return this.spellsLearned.contains(spell);

    }

}