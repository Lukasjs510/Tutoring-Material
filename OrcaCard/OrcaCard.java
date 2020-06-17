class OrcaCard {
	private final double STAX = .065;
	
	private double balance;
	
	private double totalTax;
	private double totalTrips;
	private int numTrips;
	
	private double tax;
	
	public OrcaCard(){
		balance = 0;
		totalTax = 0;
		totalTrips = 0;
		numTrips = 0;
		tax = STAX;
	}
	
	public double calcTax(double cost){
		return (cost * tax);
	}
	
	public double calcTripTotal(double cost){
		return (cost + calcTax(cost));
	}
	
	public void butTrip(double cost){
		double tripTax = calcTax(cost);
		if (balance < (cost + tripTax)){
			System.out.println("Insufficient Funds: Add additional funds");
		} else {
			double startingBalance = balance;
			double tripTotal = calcTripTotal(cost);
			
			numTrips++;
			totalTax += tripTax;
			totalTrips += cost;
			balance -= tripTotal;
			
			System.out.println("Success!\nRECEIPT\nStarting Balance: " + startingBalance + "$\nTrip Cost Before Tax: " + cost + "$\nTax: " + tripTax + "$\nTrip Total: " + tripTotal + "$\nEnding Balance: " + balance + "$");
		}
	}
	
	public void topUp(double add){
		double startingBalance = balance;
		balance += add;
		System.out.println("Success!\nRECEIPT\nStarting Balance: " + startingBalance + "$\nAmount Added: " + add + "$\nEnding Balance: " + balance + "$");
	}
	
	public void getTotalTax(){
		System.out.println("Total Taxes: " + totalTax + "$ for " + numTrips + " trips.");
	}
	
	public void getTotalTrips(){
		System.out.println("Total Trips: " + totalTrips + "$ for " + numTrips + " trips.");
	}
	
	public void getBalance(){
		System.out.println("Current Balance: " + balance + "$");
	}
	
	
	
}