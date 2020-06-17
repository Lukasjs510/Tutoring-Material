import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Freezer{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file to be analyzed: ");
        String fileName = input.nextLine();
        try {
            File f = new File(fileName);
            Scanner scan = new Scanner(f);
            System.out.println("Thanks, analyzing data in " + fileName + "!");
            int mins = 0;
            int spikes = 0;
            double totalPower = 0;
            double lastDataPoint = 0;
            double spikeTime = 0;
            double downTime = 0;
            while (scan.hasNextLine()){
                //System.out.println(reading);
                double reading = scan.nextDouble();
                if (reading > 100){
                    totalPower += reading;
                    spikeTime++;
                    if (lastDataPoint < 100){
                        spikes ++;
                    }
                } else {
                    downTime++;
                }
                mins++;
                lastDataPoint = reading;
            }
            totalPower = totalPower / (60 * 1000);
            //(totalPower / 1000) / (mins/60);
            System.out.print("Analyzed " + mins + " minutes of power data:\n" +
                            "The Freezer ran " + spikes + " amount of times, for a total of " + totalPower + " kWh\n" +
                            "The average run lasted " + (spikeTime/spikes) + " minutes\n" +
                            "The average interval between runs was " + (downTime/spikes) + " minutes");

        } catch (FileNotFoundException E){
            System.out.println("File Not Found");
            throw E;
        }
    }
}