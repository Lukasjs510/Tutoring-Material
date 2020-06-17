import java.util.*;
import java.io.*;
/*
* This is a java implementation of an Orca card
* @author Lukas J-S
* @version 1.0
*/
public class OrcaCard{
    double balance;
    int tripsTaken;
    double tripTotal;
    final double tax = 0.065;

    public OrcaCard(double initialBalance){
        balance = initialBalance;
        tripsTaken = 0;
    }

    public void addMoney(double add){
        balance += add;
    }

    public void buyTrip(double tripPrice){
        tripsTaken ++;
        tripPrice = (tripPrice * tax) + tripPrice;
        tripTotal += tripPrice;
        balance -= tripPrice;
    }

    public double getAverageTripCost(){
        return (tripTotal/tripsTaken);
    }

    public String toString(){
        String s = "Card Balance: $" + balance + "\nTrips Taken: " + tripsTaken + "\nAverage Trip Cost: $" + getAverageTripCost();
        return s;
    }
}