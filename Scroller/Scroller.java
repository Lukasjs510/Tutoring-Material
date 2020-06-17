import java.util.Arrays;
class Scroller {
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5};
		int[] newList = scrollRight(list, 1);
		System.out.println(Arrays.toString(newList));
	}
	
	public static int[] scrollRight(int[] list, int shift){
		for (int j = 0; j < shift; j++){
			int last = list[list.length - 1];
			int right = 0;
			int left = 0;
			for (int i = list.length - 1; i >= 0; i--){
				if (i == 0){
					list[i] = last;
				} else {
					left = list[i-1];
					right = list[i];
					list[i] = left;
					left = right;
				}
			}
		}
		return list;
	}
}