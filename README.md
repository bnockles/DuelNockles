# DuelNockles

SIMPLE INSTRUCTIONS
The following instructions describe the simplest steps to implementing the competition in a classroom with the least amount of work. To customize the sorting tasks or the GUI, jump to the ADVANCED INSTRUCTIONS (below.)
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


ADVANCED INSTRUCTIONS
Sprite Sheets
Sprite sheets are found in the "resources" source folder. To load new ones, add a sprite sheet to the folder and identify a row of images that you wish to import. Each contestant has three image sets: resting, hitting, and hurting. For a "row" you must identify the x-, y- coordinate of the first image of the set, the width and height (in pixels) of each image in the set (each image must be uniform width and height) and the number of images in the set. Therefore, for each set, you have 5 numbers. Altogether, this makes 15 numbers. These numbers populate the array that defines the Sprite in the addFrames method of the Contestant class.

Custom Tasks
The data for each task is created in the DataSets class. At runtime, Sort-o-mania constructs all of the data that will be used by the contestants (both sorted and unsorted arrays) DataSets is also full of utility methods for identifying the median, comparing two arrays, etc. To make your own sorting task, you had best create the necessary data in DataSets as well as a method to compare whether the contestant's sorted array matches the desired result.

In CompetitionRunner, find the run() method. If you read this code, you can see it just runs each task in sequence (a task is a sorting task and a number that is merely nominal, i.e. "Task 1", "Task 2", etc) Each task is paired with a method in the CompetitionRunner class. The method (suitable named test1, test2, etc...) grab the necessary data from ds (the instance of DataSets) and pass it to c (the Contestant currently performing the task) You will have to create a corresponding abstract method in the Contestant class for your students to implement. You can use the utility methods in DataSets to verify if the sort was performed correctly, then call afterEffects to apply the effects of a correct/incorrect sort.


