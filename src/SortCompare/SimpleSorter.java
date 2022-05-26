package SortCompare;

import java.lang.management.*;

public class SimpleSorter implements Sorter {

	@Override
	public void insertionSort(String[] data, int firstIndex, int numberToSort) {
		for (int i = firstIndex + 1; i < firstIndex + numberToSort; ++i) {
			String item = data[i];
			int j = i - 1;
			while (j >= 0 && data[j].compareTo(item) > 0) {
				data[j + 1] = data[j];
				j = j - 1;
			}
			data[j + 1] = item;
		}
	}


	@Override
	public void quickSort(String[] data, int firstIndex, int numberToSort) {

		if (15 < numberToSort) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pivot = partition(data, firstIndex, numberToSort);
			quickSort(data, firstIndex, pivot - firstIndex); // Before pi
			quickSort(data, pivot + 1, numberToSort - (pivot - firstIndex) - 1); // After pi
		} else
			insertionSort(data, firstIndex, numberToSort);
	}


	@Override
	public int partition(String[] data, int firstIndex, int numberToPartition) {
		int[] indexes = new int[3];
		for (int i = 0; i < 3; i++) {
			indexes[i] = (int) (Math.random() * numberToPartition) + firstIndex;
		}
		int median;
		if (data[indexes[0]].compareTo(data[indexes[1]]) < 0 && data[indexes[1]].compareTo(data[indexes[2]]) < 0
				|| data[indexes[1]].compareTo(data[indexes[0]]) < 0
						&& data[indexes[2]].compareTo(data[indexes[1]]) < 0) {
			median = indexes[1];
		} else if (data[indexes[0]].compareTo(data[indexes[1]]) > 0 && data[indexes[0]].compareTo(data[indexes[2]]) < 0
				|| data[indexes[0]].compareTo(data[indexes[1]]) < 0
						&& data[indexes[0]].compareTo(data[indexes[2]]) > 0) {
			median = indexes[0];
		} else {
			median = indexes[2];
		}

		String tempy = data[firstIndex];
		data[firstIndex] = data[median];
		data[median] = tempy;

		String pivot = data[firstIndex];
		int tooBigNdx = firstIndex + 1;
		int tooSmallNdx = firstIndex + numberToPartition - 1;
		while (tooBigNdx < tooSmallNdx) {
			while (tooBigNdx < tooSmallNdx && data[tooBigNdx].compareTo(pivot) <= 0) {
				tooBigNdx++;
			}
			while (tooSmallNdx > firstIndex && data[tooSmallNdx].compareTo(pivot) > 0) {
				tooSmallNdx--;
			}
			if (tooBigNdx < tooSmallNdx) {
				String temp = data[tooBigNdx];
				data[tooBigNdx] = data[tooSmallNdx];
				data[tooSmallNdx] = temp;
			}
		}
		if (pivot.compareTo(data[tooSmallNdx]) >= 0) {
			String temp = data[tooSmallNdx];
			data[tooSmallNdx] = data[firstIndex];
			data[firstIndex] = temp;
			return tooSmallNdx;
		} else {
			return firstIndex;
		}

	}


	@Override
	public void mergeSort(String[] data, int firstIndex, int numberToSort) {
		if (numberToSort > 1) {
			int sizeRight;
			int sizeLeft;
			if (numberToSort % 2 != 0) {
				sizeRight = (int) (Math.floor(numberToSort / 2));
				sizeLeft = (int) (Math.floor(numberToSort / 2) + 1);
			} else {
				sizeRight = numberToSort / 2;
				sizeLeft = numberToSort / 2;
			}
			mergeSort(data, firstIndex, sizeLeft);
			mergeSort(data, firstIndex + sizeLeft, sizeRight);
			if ((data[sizeLeft + firstIndex - 1].compareTo(data[sizeLeft + firstIndex]) >= 0)) {
				merge(data, firstIndex, sizeLeft, sizeRight);
			}
		}
	}


	@Override
	public void merge(String[] data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {
		String[] temp = new String[leftSegmentSize + rightSegmentSize];
		int i = firstIndex;
		int j = firstIndex + leftSegmentSize;
		int k = 0;
		while (leftSegmentSize > 0 && rightSegmentSize > 0) {
			if (data[i].compareTo(data[j]) <= 0) {
				temp[k] = data[i];
				i++;
				k++;
				leftSegmentSize--;
			} else {
				temp[k] = data[j];
				j++;
				k++;
				rightSegmentSize--;
			}
		}
		System.arraycopy(data, i, temp, k, leftSegmentSize);
		System.arraycopy(data, j, temp, k, rightSegmentSize);
		System.arraycopy(temp, 0, data, firstIndex, temp.length);

	}

}
