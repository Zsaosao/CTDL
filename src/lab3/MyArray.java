package lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {

		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public int recursiveLinearSearchHelper(int index, int target) {
		if (this.array.length == index) {
			return -1;
		}
		if (this.array[index] == target) {
			return index;
		}
		return recursiveLinearSearchHelper(index + 1, target);

	}

	public int recursiveLinearSearch(int target) {
		return this.recursiveLinearSearchHelper(0, target);
	}

	public boolean isDecreasing() {
		for (int i = 0; i < this.array.length - 1; i++) {
			if (this.array[i] == this.array[i + 1]) {
				continue;
			} else if (this.array[i] < this.array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = this.array.length - 1;

		while (right >= left) {
			int mid = (left + right) / 2;
			if (this.array[mid] == target) {
				return mid;
			}
			if (!this.isDecreasing()) {
				if (this.array[mid] < target) {
					left = mid + 1;

				} else {
					right = mid - 1;
				}
			} else {
				if (this.array[mid] < target) {
					right = mid - 1;

				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}

	public int recursiveBinarySearchHelper(int left, int right, int target, boolean isDecreasing) {

		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (this.array[mid] == target) {
			return mid;
		}
		if (!isDecreasing) {
			if (this.array[mid] < target) {
				return recursiveBinarySearchHelper(mid + 1, right, target, isDecreasing);
			} else {
				return recursiveBinarySearchHelper(left, mid - 1, target, isDecreasing);
			}
		} else {
			if (this.array[mid] < target) {
				return recursiveBinarySearchHelper(left, mid - 1, target, isDecreasing);
			} else {
				return recursiveBinarySearchHelper(mid + 1, right, target, isDecreasing);
			}
		}
	}

	public int recursiveBinarySearch(int target) {
		return this.recursiveBinarySearchHelper(0, this.array.length - 1, target, this.isDecreasing());
	}

	public static void main(String[] args) {
		int arr[] = { 10, 9, 8, 8, 7, 6, 3, 2 };
		MyArray myArr = new MyArray(arr);
		System.out.println(myArr.iterativeLinearSearch(10));
		System.out.println(myArr.recursiveLinearSearch(10));
		System.out.println(myArr.iterativeBinarySearch(6));
		System.out.println(myArr.recursiveBinarySearch(2));
	}

}
