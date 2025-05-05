
import java.util.List;
import java.util.ArrayList;

public class Spellbook {

    private List<String> allSpells;

    /**
     * Creates a new spellbook.
     * Effects: Initializes the spellbook with list of common spells.
     */
    public Spellbook(){
        this.allSpells = new ArrayList<>();
        this.allSpells.add("Accio");
        this.allSpells.add("Alohomora");
        this.allSpells.add("Expelliarmus");
        this.allSpells.add("Lumos");
        this.allSpells.add("Nox");
        this.allSpells.add("Wingardium Leviosa");
        this.allSpells.add("Expecto Patronum");
    }

    /**
     * Returns a copy of list.
     */
    public List<String> getAllSpells(){
        return new ArrayList<>(this.allSpells);
    }

    /**
     * call the spell at the specific position in spellbookç
     * requires: the index must be not negative and less than the total spellnumber.
     * effects: returns the spell.
     */
    public String getSpell(int i){
        return this.allSpells.get(i);
    }

    /**
     * Finds and returns a list of spells that start with prefix.
     * Requires: prefix is not null.
     * Effects: If the prefix is null, an empty list is returned.
     * -ıf no spells start with prefix is returned.
     * -the list returned is always a new list, modifying is won't change the original spellbook.
     */

    /*
     * Finds all spells in the spellbook that start with the given prefix.
     *
     * Effects: Returns a new list containing all spells from the spellbook
     *          that begin with the specified prefix (case-sensitive).
     *
     */
    public List<String> getSpellsByPrefix(String prefix) {
        if (prefix == null) {
            return new ArrayList<>();
        }
        if (prefix.isEmpty()) {
            return new ArrayList<>(this.allSpells);
        }

        List<String> result = new ArrayList<>();
        for (String spell : this.allSpells) {
            if (spell.startsWith(prefix)) {
                result.add(spell);
            }
        }
        return result;


    }

}
