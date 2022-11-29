import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			String[] fileData = FileReader.getFileData("input.txt");
			int[] intArray = FileReader.getIntArrFromStringArr(fileData[0]);
			int result = getAmountOfComparisonsInShellSort(intArray);

			FileWriter.writeStringToFile("out.txt", "", String.valueOf(result));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int getAmountOfComparisonsInShellSort(int[] array) {
		int h = 1;

		int comparisons = 0;

		/*!!!!!!!!!!!!!!!!!!!!!!!
		* при подстановки формулы для h из задания алгоритм работает не корректно
		!!!!!!!!!!!*/

		while (h <= array.length / 3) {
			h = h * 3 + 1;
		}

		/*!!!!!!!!!!!!!!!!!!!!!!!
		* при подстановки формулы для h из задания алгоритм работает не корректно
		!!!!!!!!!!!*/

		while (h > 0) {
			for (int outer = h; outer < array.length; outer++) {
				int tmp = array[outer];
				int inner = outer;
				comparisons++;

				while (inner > h - 1 && array[inner - h] > tmp) {
					comparisons++;
					array[inner] = array[inner - h];
					inner -= h;
				}

				array[inner] = tmp;
			}

			h = (h - 1) / 3;
		}

		for (int value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
		System.out.println("check out.txt out");
		return comparisons;
	}

	public static double log2(int x) {
		return Math.log(x) / Math.log(2);
	}
}