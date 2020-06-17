import java.util.*; //Import all of java.util

/*
* This program takes terminal inputs of server names and their sizes separated by ':' and outputs a server name based on the input's distribution ratio.
* Note: Usually only public methods have javadoc comments but I included them for my private methods to improve readability.
* @Author Lukas Jimenez-Smith
* @Version November 6, 2018
*/
class Servers{

    /*
    * This is the main for the Servers class, it takes in user terminal input.
    * @param args, User input from terminal
    */ 
    public static void main(String[] args){
        String selectedServer = pickServer(args);
        System.out.println(selectedServer);
    }

    /*
    * The pickServer (String []) method parses the user input from args and saves the split values of a server name into names and the server size into sizes.
    * This method then passes its newly created arrays to selection (int, String [], int []) to select the server output.
    * @param args, User input from terminal
    * @Return Name of selected server
    */ 
    private static String pickServer(String[] args){
        String[] names = new String[args.length];
        int[] sizes = new int[args.length];
        
        int totalSpace = 0;
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            sizes[i] = Integer.parseInt(s.replaceAll("\\D", ""));
            totalSpace += sizes[i];
            names[i] = s.split("\\:")[0];
        }
        return selection(totalSpace, names, sizes);
    }

    /*
    * The selection method creates a linear sorted version of the two arrays names and sizes to set limits for "random" selection of the server to be distributed to.
    * @param totalSpace, the sum of all server sizes
    * @param names, the list of all server names
    * @param sizes, the list of all server sizes
    * @return Name of selected server
    * @return "Failed", if the algorithm failed to select a server
    */ 
    private static String selection(int totalSpace, String[] names, int[] sizes){
        Random rand = new Random(System.currentTimeMillis());
        int select = rand.nextInt(totalSpace);
        dualQuickSort(0, sizes.length - 1, names, sizes);
        int low = 0;
        int high = sizes[0];
        int hold = 0;

        for (int i = 0; i < sizes.length ; i++){
            if (low <= select && select < high){
                return names[i];
            } else {
                hold = high;
                low = high;
                high += sizes[i+1];
            }
        }
        return "Failed";
    }

    /*
    * This is a quick Sort implementation that keeps two arrays indexed values the same while actively sorting only the integer array.
    * @param first, left bound for starting sort comparisons
    * @param last, right bound for starting sort comparisons
    * @param names, the list of all server names
    * @param sizes, the list of all server sizes
    */ 
 	private static void dualQuickSort(int first, int last, String[] names, int[] sizes) {
        int left = first, right = last;
        int base = sizes[((last-first)/2) + first];

        while(left <= right){
            while(sizes[left] < base) {
                left ++;
            }
            while(sizes[right] > base){
                right --;
            }
            
            if (left <= right) {   
                swap(left, right, names, sizes);
                left ++;
                right --;
            }
        }
        if (first < right) {
            dualQuickSort(first, right, names, sizes);
        }
        if (left < last) {
            dualQuickSort(left, last, names, sizes);
        }
    }
    
    /*
    * This method is used to swap indices and values for the dualQuickSort(int, int, String[], int[]).
    * @param index1, first index to be swapped
    * @param index2, second index to be  swapped
    * @param names, the list of all server names
    * @param sizes, the list of all server sizes
    */ 
    private static void swap(int index1, int index2, String[] names, int[] sizes) {
        int theSwapShop = sizes[index1];
        String theSwapShopString = names[index1];

        sizes[index1] = sizes[index2];
        names[index1] = names[index2];

        sizes[index2] = theSwapShop;
        names[index2] = theSwapShopString;
    }
}