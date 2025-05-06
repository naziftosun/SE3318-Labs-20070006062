Eldoria Game(Week 6 Lab)
This project developed for week 6 laboratory of the SE3318.

*Character(abstract class): the base class for all characters in the game.It has name and level attributes.
*Hero(class): Inherits from 'character'.Represents playable hero characters.Implements the 'speak()'method.
*Enemy(class):Inherits from'Character'.Represents enemy character.Implements 'speak()'method.
*Questable(ınterface):Interface for character can accept quests.Implements 'acceptQuest()'method.
*QuestBoard(class):assign quests to 'Questable'characters.
*BattleManager(class):Simulate a battle between 'Hero' and 'Enemy'.

Sample Output
Eldoria Game Demo
Characters speaks.
For glory! My name is Aragornand ı am level 10.
I am lord of the shadows Orc CaptainYou are done.My level is 8.
Aragorncannot accept.
Battle:Aragorn vs Orc Captain
Hero defeats and wins.
Battle finished
Game End
