import java.util.*;

public class Servers{
    static Scanner scan = new Scanner(System.in);
    static ArrayList servers = new ArrayList<Server>();
    int totalSpace;

    public static void main(String[] args){
        System.out.println("How many servers?");
        int amtServers = userPutInt();
        for (int i = 0; i < amtServers; i++){
            System.out.println("Server " + i + " name?");
            String name = userPutString();
            System.out.println("Server " + name + " size?");
            int size = userPutInt();
            Server newServer = new Server(name,size);
            servers.add(newServer);
        }
        scan.close();
    }

    private static int userPutInt(){
        int number = scan.nextInt();
        return number;
    }

    private static String userPutString(){
        String word = scan.nextLine();
        return word;
    }


    private class Server{
        int size;
        int fill;
        String name;
        public Server(String n, int s){
            size = s;
            fill = 0;
            name = n;
        }

        private void addJobs(int amtJobs){
            for (int x = 0; x < amtJobs ; x ++){
                fill++;
            }
        }

        private String getName(){
            return name;
        }

        private int getSize(){
            return size;
        }
    }
}