package main;

import java.util.ArrayList;

import sortomania.Contestant;
import sortomania.Runner;
import sortomania.contestants.*;
/**
 * 
 * @author bnockles
 * Instructions:
 *  1. Tell students 
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
	public void populate(ArrayList<Contestant> participants) {

		//PERIOD 4-5
//		addContestant(participants, new SamJenny());
//		addContestant(participants, new MimiJessiSort());
//		addContestant(participants, new AlexAndErik());
//		addContestant(participants, new SidBen());
//		addContestant(participants, new TylerCarsonSort());
//		addContestant(participants, new YonathanDavid());
//		addContestant(participants, new NabeelAmanatSort());
//		addContestant(participants, new JasonDavid());
		addContestant(participants, new JaneVictorContestant());
//		addContestant(participants, new ZhehaoRemington());
//		addContestant(participants, new DanSteven());
		addContestant(participants, new GarrettRicky());
//		addContestant(participants, new AndrewKevin());
//		addContestant(participants, new FahadDavidSorter());
//		addContestant(participants, new JustinSunny());
		//ALL OF THE ABOVE STUDENTS SUBMITTED BY THE DEADLINE
//		
//		addContestant(participants, new DerekDavid());//caught on task 2
//		addContestant(participants, new DimitrisAlexakos());//errors in 3 and 4
//		addContestant(participants, new JasTristan());//stuck in task 2
//		addContestant(participants, new VincentNRaymond());//does not get through task 2
//		addContestant(participants, new JessicaJi());//cannot complete task 4
//		addContestant(participants, new AliceDanielSort());//accurate but slow
//		addContestant(participants, new JohnsonWeiContestant());
//		addContestant(participants, new BenjaminDardia());//erros in task 4
//		addContestant(participants, new VickieAreej());
//		addContestant(participants, new LordAchillesContestant());
//		addContestant(participants, new DoubleJasons());
//		addContestant(participants, new TheoDevinBeepBoop());
//		addContestant(participants, new AbidAbedContestant());//fast but creates a recursive error somewhere
//		addContestant(participants, new AnnieJoannaSort());
//		addContestant(participants, new MarkWilliam());
//		addContestant(participants, new KevinStephContestant());
//		addContestant(participants, new EthanDavidContestant());//gets stuck on task 2
//		addContestant(participants, new DanielE());
		//ALL OF THE ABOVE STUDENTS SUBMITTED 9-10 BY THE DEADLINE
		
	}

}
