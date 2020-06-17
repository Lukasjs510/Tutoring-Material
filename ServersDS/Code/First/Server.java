/*
* This is a server object class that is used to store a custom set of values following certain rules
* @Author Lukas Jimenez-Smith 
* @Version November 3, 2018
*/
public class Server{
    int size;
    int fill;
    String name;
    
    public Server(String n, int s){
        size = s;
        fill = 0;
        name = n;
    }

    public void addJobs(int amtJobs){
        if (amtJobs > size) {
            System.err.println("Job input larger than server size.");
        } else {
            fill += amtJobs;
        }
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String returnString = "[Name: " + name + " Size: " + size + " Current Fill: " + fill + "]\n";
        return returnString;
    }                                                                                            
}           