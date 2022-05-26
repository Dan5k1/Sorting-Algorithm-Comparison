package SortCompare;

public interface Sorter {


	public void insertionSort(String[] data, int firstIndex, int numberToSort);


	public void quickSort(String[] data, int firstIndex, int numberToSort);


	public int partition(String[] data, int firstIndex, int numberToPartition);


	public void mergeSort(String[] data, int firstIndex, int numberToSort);

	// merge for use with mergesort.
	public void merge(String[] data, int firstIndex, int leftSegmentSize, int rightSegmentSize);

}
