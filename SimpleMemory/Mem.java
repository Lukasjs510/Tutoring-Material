public class Mem{
	private int value;
	
	public Mem(){ // Generic constructor
		value = 0;
	}
	
	public Mem(int value){ //Custom constructor takes paramater of int called value
		this.value = value;
	}
	
	public void setMem(int value){ //Mutator/Setter prints action and executes
		System.out.println("***Mem <- " + value + "***");
		this.value = value;
		printMem();
	}
	
	public void printMem(){ //Prints mem abstracts getMem() for print value
		int value = getMem();
		System.out.println("***Memory = " + value + "***");
	}
	
	private int getMem(){ //Returns field variable value
		return value;
	}
	
}