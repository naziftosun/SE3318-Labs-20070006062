public class Duel {

    private Duel(){

    }

    /**
     * Simulate a duel between two hogwarts students.
     * Requires: s1,s2 must not be null, spell must nıt be null.
     * Effects: prints the duel setup.winner based on which student knows the spell.
     */
    public static void start(HogwartsStudent s1,HogwartsStudent s2,String spell){
        if (s1 == null || s2 == null || spell == null || spell.trim().isEmpty()) {
            System.out.println("Invalid duel setup.Students and spell cannot be null or empty.");
            return;
        }

        System.out.println("Duel Starting");
        System.out.println(s1.getName() + " vs " + s2.getName());
        System.out.println("Spell: " + spell);
        System.out.println("                ");

        boolean s1Knows = s1.knowsSpell(spell);
        boolean s2Knows = s2.knowsSpell(spell);

        if (s1Knows && s2Knows){
            System.out.println("Result:Both students know the spell.");
        } else if (s1Knows) {
            System.out.println("Result:"+ s1.getName() + "knows the spell and wins.");

        } else if (s2Knows) {
            System.out.println("Result: " + s2.getName() + "knows the spell and wins!");

        } else {
            System.out.println("Result: non of them knows.It's draw.");
        }
        System.out.println("Duel Finished");
        System.out.println();

    }
}
