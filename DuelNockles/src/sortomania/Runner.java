package sortomania;

import java.util.ArrayList;

import sortomania.contestants.*;

import ui.GUIApplication;

/**
 * Runner takes care of GUI-related functions of the sortomania screen
 * @author bnockles
 *
 */

public abstract class Runner extends GUIApplication{

	public static String fileNote = "Finals";
	
	public static ContestScreen screen;
	private static final int initY = 60; 
	private int y;
	private int x; 
	int[] arr;
	ArrayList<Contestant> participants;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596548043619696133L;

	public Runner() {
		super(1350, 450);
	
	}

	private void randomize(ArrayList a) {
		for(int i = 0; i < a.size(); i++){
			Object o = a.get(i);
			int rand = (int)(Math.random()*a.size());
			a.set(i, a.get(rand));
			a.set(rand, o);
		}
		
	}



	public void runContest(){
		Thread compete = new Thread(screen);
		compete.start();
	}
	


	
	public abstract void populate(ArrayList<Contestant> participants);


	protected void addContestant(ArrayList<Contestant> participants, Contestant c) {

		c.setX(x);
		c.setY(y);
		c.setNumber(participants.size()+1);
		y+=c.getHeight()+10;
		if(y+c.getHeight() > getHeight()){
			y = initY;
			x+= 5+c.getWidth();
		}
		participants.add(c);
		Thread animation = new Thread(c);
		animation.start();
		arr[0] = x;
		arr[1] = y;
	}

	@Override
	public void initScreen() {
		ArrayList<Contestant> participants = new ArrayList<Contestant>();
		x = 40;
		y = initY;
		arr = new int[2];
		arr[0] = x;
		arr[1] = y;
		populate(participants);
		randomize(participants);
		screen = new ContestScreen(getWidth(), getHeight());
		screen.setparticipants(participants);
		setScreen(screen);
	}

}
