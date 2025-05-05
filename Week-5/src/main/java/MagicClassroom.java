import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


public class MagicClassroom {

    private List<HogwartsStudent> students;

    /**
     * Creates a new MagicClassroom.
     * Effects: Initializes an empty list to hold students.
     */
    public MagicClassroom(){
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to magic classroomç
     * Requires: student object is not null.
     * Effects: it is added to the classroom's list.
     */

    public boolean addStudent(HogwartsStudent student){
        if (student != null){
            this.students.add(student);
            return true;
        }
        return false;
    }

    /**
     * Finds the first student with name.
     * Requires: name should not be null.
     * Effects: Searches the student list for a student.
     */
    public HogwartsStudent findStudent(String name){
        if (name == null || name.trim().isEmpty()){
            return null;
        }
        for (HogwartsStudent student : this.students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    /**
     * Finds the first students know the spell.
     * Requires: the spell should not be empty.
     * Effects: searches the student list.
     */
    public HogwartsStudent findStudentBySpell(String spell) {
        if (spell == null || spell.trim().isEmpty()) {
            return null;
        }
        for (HogwartsStudent student : this.students) {
            if (student.knowsSpell(spell)) {
                return student;
            }
        }
        return null;
    }
    public List<HogwartsStudent> getStudentsByHouse(String house) {
        List<HogwartsStudent> result = new ArrayList<>();
        if (house == null || house.trim().isEmpty()) {
            return result;
        }
        for (HogwartsStudent student : this.students){
            if (student.getHouse().equals(house)){
                result.add(student);
            }
        }
        return result;
    }
    public List<HogwartsStudent> getStudentsSortedByHouse() {
        List<HogwartsStudent> sortedList = new ArrayList<>(this.students);
        Collections.sort(sortedList, new Comparator<HogwartsStudent>() {
            @Override
            public int compare(HogwartsStudent s1, HogwartsStudent s2) {
                int houseComparison = s1.getHouse().compareTo(s2.getHouse());
                if (houseComparison != 0) {
                    return houseComparison;
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            }
        });
        return sortedList;
    }



}
