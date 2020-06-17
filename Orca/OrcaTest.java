/*
* Test class for OrcaCard.java
* @Author Lukas J-S
* @Version 1.0
*/ 
public class OrcaTest{
    public static void main(String[] args){
        // Create a new card with a balance of $20.50
        System.out.println("Creating a new ORCA Card:");
        OrcaCard oc = new OrcaCard(20.50);
        System.out.println(oc.toString());
        System.out.println("\nBuying a $10 ticket: ");
        oc.buyTrip(10.00);
        System.out.println(oc.toString());
        System.out.println("\nAdding $10 back to my card: ");
        oc.addMoney(10.00);
        System.out.println(oc.toString());
        System.out.println("\nBuying a $5 ticket: ");
        oc.buyTrip(5.00);
        System.out.println(oc.toString());
        System.out.println("\nWhat’s the average cost per trip so far?");
        double avg = oc.getAverageTripCost();
        System.out.println("$" + avg);
    }
}