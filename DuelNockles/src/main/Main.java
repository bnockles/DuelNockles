package main;

import java.util.ArrayList;

import sortomania.Contestant;
import sortomania.Runner;
import sortomania.contestants.*;
/**
 * 
 * @author bnockles
 * Instructions:
 *  The following instructions describe the simplest steps to implementing the competition in a classroom with the least amount of work. To customize the sorting tasks or the GUI, jump to the ADVANCED INSTRUCTIONS (below.)
1. Introduce the competition and the sorting tasks to students:
  a. Students will pair up to write code for a contestant in a sorting competition. The contestant will be entered into an elimination round where contestants with faster, more accurate algorithms will move up in the ranks. Grades will be based on the accuracy of the sorts while extra credit will be award to students based on the number of rounds they can complete.
  b. The tasks are as follows:
      - sort a randomized int array of length 10,000 and return the median
      - sort a String array of length 10,000 (random Strings) and return the index of a given String in the array
      - sort a int arry of length 10,000 that is already mostly sorted and return the median
      - sort a 2D int arr of 1,000 x 1,000: sort each array in the 2D array, sort each row according to its median, return the median of the medians
      - sort a Comparable array of length 10,000 and return the index of a given Comparable in the array
      
2. Post the abstract class 'Contestant' and instruct students to extend the class, writing a body for all SEVEN methods. (Two methods are for the purposes of the GUI: one returns the team Color (from java.awt.Color) and another returns the String describing the location of the sprite sheet. In the Contestant class, there are eight choices that are pre-loaded with the GUI: KEN, RYU, CHUN_LI, DEE_JAY, BLANKA, E_HONDA, FEI_LONG, and CAMMY.) 

SPECIAL NOTE:
In my class, I created a repository that had all of teh necessary code except the CompetitionRunner.java, Generic.java, and DataSets.java. I taught students how to fork my repository and how to write a pull request when they were finished. This is a very easy way to distribute and collect code, though it requires a working knowledge of Github.

3. Students should get at least two days to research sorting algorithms and code their class. In my class, I told them they would not be marked down for copying code found online because the competition is more of a "RESEARCH project". I did tell students that anyone who uses Arrays.sort would be disqualified.

4. Collect student code. (See Special Note in #2) Outside of class, put all of the student code in one project. In src.main.Main, find the populate() method. In this method body, you must call addContestant(Contestant c) for each sample of Student work. Consider the example:

	public void populate() {

		//PERIOD 4
		addContestant(new SamJenny());
		addContestant(new MimiJessiSort());
		addContestant(new AlexAndErik());
		addContestant(new SidBen());
  .
  .
  .
  }

Note: The GUI automatically handles the positioning of the contestants. If you have an odd number of contestants, the odd-contestant-out will be removed from the first battle and added to the following round. 

5. Before presentint the competition to the class, run the code (via Main.java) in advance! The competition catches runtime errors thrown by contestants and penalizes the Contestant but infinite recursion can sometimes cause the competition to never end. In my classroom, I found who those students were first and when I showed the class, I explained where the errors were coming from and why some contestants would have to be removed in order for the competition to proceed.

6. Bring the completed package to class, connect your computer to a projector and show the competition to the students. They really get into it! At the end of the competition, the program saves a CSV in the project folder that contains all the results info.

 */

public class Main extends Runner {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772845448237830589L;

	public Main() {
		super();
	}

	public static void main(String[] args) {
		Runner competition = new Main();
		competition.setVisible(true);
		Thread go = new Thread(competition);
		go.start();
		competition.runContest();
	}

	@Override
	/**
	 * Change the body of this method to add your students' contestants to the ArrayList "participants"
	 * @param participants the instances of Contestant that will compete
	 */
	public void populate() {

		//PERIOD 4-5
		addContestant(new SamJenny());
		addContestant(new MimiJessiSort());
		addContestant(new AlexAndErik());
//		addContestant(new SidBen());
		addContestant(new TylerCarsonSort());
//		addContestant(new YonathanDavid());
//		addContestant(new NabeelAmanatSort());
//		addContestant(new JasonDavid());
		addContestant(new JaneVictorContestant());
//		addContestant(new ZhehaoRemington());
//		addContestant(new DanSteven());
		addContestant(new GarrettRicky());
//		addContestant(new AndrewKevin());
//		addContestant(new FahadDavidSorter());
//		addContestant(new JustinSunny());
		//ALL OF THE ABOVE STUDENTS SUBMITTED BY THE DEADLINE
//		
//		addContestant(new DerekDavid());//caught on task 2
//		addContestant(new DimitrisAlexakos());//errors in 3 and 4
//		addContestant(new JasTristan());//stuck in task 2
//		addContestant(new VincentNRaymond());//does not get through task 2
//		addContestant(new JessicaJi());//cannot complete task 4
//		addContestant(new AliceDanielSort());//accurate but slow
//		addContestant(new JohnsonWeiContestant());
//		addContestant(new BenjaminDardia());//erros in task 4
//		addContestant(new VickieAreej());
//		addContestant(new LordAchillesContestant());
//		addContestant(new DoubleJasons());
//		addContestant(new TheoDevinBeepBoop());
//		addContestant(new AbidAbedContestant());//fast but creates a recursive error somewhere
//		addContestant(new AnnieJoannaSort());
//		addContestant(new MarkWilliam());
//		addContestant(new KevinStephContestant());
//		addContestant(new EthanDavidContestant());//gets stuck on task 2
//		addContestant(new DanielE());
		//ALL OF THE ABOVE STUDENTS SUBMITTED 9-10 BY THE DEADLINE
		
	}

}
