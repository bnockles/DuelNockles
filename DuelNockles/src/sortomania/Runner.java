package sortomania;

import java.util.ArrayList;
import sortomania.contestants.*;

import ui.GUIApplication;

public class Runner extends GUIApplication{

	public static String fileNote = "Sample";
	
	static ContestScreen screen;
	private int initY;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596548043619696133L;

	public Runner() {
		super(1200, 800);
		
	}

	private void randomize(ArrayList a) {
		for(int i = 0; i < a.size(); i++){
			Object o = a.get(i);
			int rand = (int)(Math.random()*a.size());
			a.set(i, a.get(rand));
			a.set(rand, o);
		}
		
	}

	public static void main(String[] args) {
		Runner competition = new Runner();
		competition.setVisible(true);
		Thread go = new Thread(competition);
		go.start();

		competition.runContest();
	}

	public void runContest(){
		Thread compete = new Thread(screen);
		compete.start();
	}
	


	
	void populate(ArrayList<Contestant> participants){
		int x = 40; 
		initY = 60;
		int y = initY; 
		int[] arr = {x,y};
		//PERIOD 4-5
		arr = addContestant(arr[0],arr[1],participants, new SamJenny());
		arr = addContestant(arr[0],arr[1],participants, new MimiJessiSort());
		
	}

	private int[] addContestant(int x, int y, ArrayList<Contestant> participants, Contestant c) {

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
		int[] arr = {x,y};
		return arr;
	}

	@Override
	public void initScreen() {
		ArrayList<Contestant> participants = new ArrayList<Contestant>();
		populate(participants);
		randomize(participants);
		screen = new ContestScreen(getWidth(), getHeight());
		screen.setparticipants(participants);
		setScreen(screen);
	}

}
