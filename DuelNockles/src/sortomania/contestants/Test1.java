package sortomania.contestants;



public class Test1 implements Comparable{

	private int a;
	public Test1(){
		a=(int)(Math.random()*10000);
	}
	public int getA() {
		return a;
	}
	public int compareTo(Object arg0) {
		return this.a-((Test1) arg0).getA();
	}
}