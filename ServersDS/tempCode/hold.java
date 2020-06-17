import java.util.Scanner;
import java.util.ArrayList;
/*
* This is a server managing program that takes server names and sizes and distributes jobs to each server according to their size relation to other servers.
* @Author Lukas Jimenez-Smith
* @Version November 3, 2018
*/
class Challenge{
    static Scanner scan = new Scanner(System.in);   //Scanner for user input

    public static void main(String[] args){
        ArrayList<Server> servers = new ArrayList<Server>();    //List to hold server objects
        int totalSpace = 0;
        int jobsFilled = 0;
        int jobs = 0;

        System.out.println("How many servers?");                //Prompts and gets user input for the amount of desired servers
        int amtServers = userPutInt();
        System.out.println();

        int largestServerSize = -1; 
        int largestServerIndex = -1;


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

        System.out.println("How many jobs?");                   //Promts and gets user input for the amount of jobs to be distributed 
        jobs = userPutInt();

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

            if (jobsFilled < jobs){
                int dif = (jobs - jobsFilled);
                servers.get(largestServerIndex).addJobs(dif);
                jobsFilled += dif;
            }

            System.out.println("\nAmount of servers: " + amtServers + "\nJobs: " + jobs + "\nJobs Distributed: " + jobsFilled + "\n");        //Start output print statments
            for (int i = 0; i < amtServers; i++){                                                                   //Print server status for all servers
                System.out.println(servers.get(i).toString());
            }
        }
        scan.close();
    }

    private static void distribute(ArrayList<Server> servers){}

    private static Server makeServer(String name, int size){
        Server newServer = new Server(name,size);
        return newServer;
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
}