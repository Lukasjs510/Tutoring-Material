import java.util.Scanner;
import java.util.ArrayList;
/*
* This is a server managing program that takes server names and sizes and distributes jobs to each server according to their size relation to other servers.
* @Author Lukas Jimenez-Smith
* @Version November 3, 2018
*/
class Challenge{
    static Scanner scan = new Scanner(System.in);   //Scanner for user input
    static int largestServerSize; 
    static int largestServerIndex;
    static int totalSpace;
    static int jobsFilled;

    public static void main(String[] args){
        largestServerSize = -1; 
        largestServerIndex = -1;
        totalSpace = 0;
        jobsFilled = 0;

        System.out.println("How many servers?");                //Prompts and gets user input for the amount of desired servers
        int amtServers = userPutInt();
        System.out.println();  
        ArrayList<Server> servers = makeServers(amtServers);

        System.out.println("How many jobs?");                   //Promts and gets user input for the amount of jobs to be distributed 
        int jobs = userPutInt();
        scan.close();
        servers = distribute(servers, jobs, amtServers);

        printResults(servers, amtServers, jobs, jobsFilled);
    }

    private static ArrayList<Server> makeServers(int amtServers){
        ArrayList<Server> servers = new ArrayList<Server>();    //List to hold server objects
        for (int i = 0; i < amtServers; i++){                   //This loop gets user input for each servers name and size
            System.out.println("Server " + (i+1) + " name?");
            String name = userPutString();
            System.out.println("Server " + name + " size?");
            int size = userPutInt();

            if(size > largestServerSize){
                largestServerSize = size;
                largestServerIndex = i;
            }

            totalSpace += size;
            System.out.println();
            servers.add(makeServer(name, size));
        }
        return servers;
    }

    private static Server makeServer(String name, int size){
        Server newServer = new Server(name,size);
        return newServer;
    }

    private static ArrayList<Server> distribute(ArrayList<Server> servers, int jobs, int amtServers){
        if (jobs > totalSpace){                                 //Checks if servers have enough space to take the jobs input
            System.err.println("Too many jobs for server set.");
        } else {
            for (int i = 0; i < amtServers; i++){                               //loop 
                Server serv = servers.get(i);
                double ratio = ((double)(serv.getSize())/(double)(totalSpace)); //calculates each servers size ration in relation to the other servers 
                int jobsForServ = (int)(ratio * jobs);                          //Distributes the proportional amount of jobs to each server
                jobsFilled += jobsForServ;
                serv.addJobs(jobsForServ);                                 
            }
            
            int j = 0;
            while (jobsFilled < jobs){
                servers.get(j).addJobs(1);
                j++;
                jobsFilled++;
            }
        }
        return servers;
    }

    private static int userPutInt(){
        int number = scan.nextInt();
        return number;
    }

    private static String userPutString(){
        scan.nextLine();
        String word = scan.nextLine();
        return word;
    }

    private static void printResults(ArrayList<Server> servers, int amtServers, int jobs, int jobsFilled){
        System.out.println("\nAmount of servers: " + amtServers + "\nJobs Assigned: " + jobs + "\nJobs Distributed: " + jobsFilled + "\n");        //Start output print statments
        for (int i = 0; i < amtServers; i++){                                                                   //Print server status for all servers
            System.out.println(servers.get(i).toString());
        }
    }
}