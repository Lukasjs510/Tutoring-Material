class WaterBottle {
	final int MAXFILL = 20;
	final int GULP = 3;
	int fill;
	
	public WaterBottle (){
		fill = 0;
	}
	
	public WaterBottle (int fill){
		this.fill = fill;
	}
	
	public void clean(){
		System.out.println("Cleaning Bottle\nScrub...Scrub...Scrub...\nBottle Clean");
		fill = 0;
	}
	
	public void fillWaterBottle(int fill){
		if ((this.fill + fill) > MAXFILL){
			System.out.println("Too much water");
		} else if (fill < 0){
			System.out.println("Cant add negative water");
		} else {
			this.fill += fill;
			System.out.println("Bottle now has " + this.fill + "oz");
		}
	}
	
	public void drink(){
		if ((this.fill - GULP) < 0){
			System.out.println("Not enough water");
		} else {
			System.out.println("Drinking...");
			this.fill -= GULP;
		}
	}
	
	public int getCurrentAmount(){
		System.out.println("Fill = " + this.fill);
		return this.fill;
	}
	
	public boolean equals(WaterBottle comp){
		if (comp.getCurrentAmount() == this.fill){
			return true;
		} else {
			return false;
		}
	}
	
		
}