package kata;

public class Kata {

	public static int[] DataReverse(int[] data1) {
		int[] newArray = new int[data1.length];
		int byteNumber = 0;
		for (int i = data1.length / 8; i > 0; i--){
			for (int j = 0; j < 8; j++){
				newArray[(i-1) * 8 + j] = data1[j + byteNumber * 8];
			}
			byteNumber++;
		}
		return newArray;
	}

}
