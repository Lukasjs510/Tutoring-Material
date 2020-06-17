import java.util.*;
/*
*
*
*/
class Servers{
    static int totalSpace; 
    public static void main(String[] args){
        String selectedServer = pickServer(args);
        System.out.println(selectedServer);
    }

    private static String pickServer(String[] args){
        String[] names = new String[args.length];
        int[] sizes = new int[args.length];

        for (int i = 0; i < args.length; i++){
            String s = args[i];
            sizes[i] = Integer.parseInt(s.replaceAll("\\D", ""));
            totalSpace += sizes[i];
            names[i] = s.split("\\:")[0];
        }
        return selection(names, sizes);
    }

    private static String selection(String[] names, int[] sizes){
        Random rand = new Random(System.currentTimeMillis());

        String[] prob = new String[totalSpace];
        
        int hold = 0;
        for (int i = 0; i < names.length; i++){
            for (int j = hold; j < hold + sizes[i]; j++){
                prob[j] = names[i];
            }
            hold += sizes[i];
        }

        return prob[rand.nextInt(totalSpace)];
    }
}