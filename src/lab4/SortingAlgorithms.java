package lab4;

public class SortingAlgorithms {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					minIndex = j;
					min = array[j];
				}
			}

			int temp = array[i];
			array[i] = min;
			array[minIndex] = temp;
		}
	}

	public static void bubbleSort(int[] array) {
		boolean swap = true;
		for (int i = array.length - 1; i > 0 && swap; i--) {
			swap = false;
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swap = true;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void mergeSort(int[] array) {
		if (array.length < 2)
			return;
		int mid = array.length / 2;
		int left[] = new int[mid];
		int right[] = new int[array.length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = 0; i < array.length - mid; i++) {
			right[i] = array[mid + i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);
	}

	private static void merge(int[] left, int[] right, int[] array) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			array[k++] = left[i++];
		}
		while (j < right.length) {
			array[k++] = right[j++];
		}
	}

	private static int getPivot_Random(int[] array) {
		return array[(int) (Math.random() * array.length)];
	}

	private static int getPivot_Last(int[] array) {
		return array[array.length - 1];
	}

	private static int getPivot_First(int[] array) {
		return array[0];
	}

	private static int getPivot_MedianOfThree(int[] array) {
		int length = array.length;
		int mid = length / 2;

		int first = array[0];
		int middle = array[mid];
		int last = array[length - 1];

		if ((first <= middle && middle <= last) || (last <= middle && middle <= first)) {
			return middle;
		} else if ((middle <= first && first <= last) || (last <= first && first <= middle)) {
			return first;
		} else {
			return last;
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(array, low, high);
			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = getPivot_First(array);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

}