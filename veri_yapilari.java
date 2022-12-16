import java.util.Arrays;
public class MinHeap
//02195076051 ABDULKADİR YAYAN     
{
	private final int[] Heap;
	private int index;
	private final int size;

	public MinHeap(int size) {
		this.size = size;
		this.index = 0;
		Heap = new int[size];
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int solCocuk(int i) {
		return (i * 2) + 1;
	}

	private int sagCocuk(int i) {
		return (i * 2) + 2;
	}

	private boolean isLeaf(int i) {
		return sagCocuk(i) >= size || solCocuk(i) >= size;
	}

	public void insert(int element) {
		if (index >= size) {
			return;
		}
		Heap[index] = element;
		int current = index;

		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		index++;
	}

	 
	public int remove() { 
		int popped = Heap[0];
		Heap[0] = Heap[--index];
		minHeapify(0);
		return popped;
	}
 
	private void minHeapify(int i) { 
		if (!isLeaf(i)) {
			if (Heap[i] > Heap[solCocuk(i)] ||
                  Heap[i] > Heap[sagCocuk(i)]) {
				if (Heap[solCocuk(i)] < Heap[sagCocuk(i)]) {
					swap(i, solCocuk(i));
					minHeapify(solCocuk(i));
				} else {
					swap(i, sagCocuk(i));
					minHeapify(sagCocuk(i));
				}
			}
		}
	}
 
	public void minHeap() {
		for (int i = (index - 1 / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}
 
	public void printHeap() {
		for (int i = 0; i < (index / 2); i++) {
			System.out.print("ebeveyn : " + Heap[i]);
			if (solCocuk(i) < index)
				System.out.print(" Sol : " + Heap[solCocuk(i)]);
			if (sagCocuk(i) < index)
				System.out.print(" Sag :" + Heap[sagCocuk(i)]);
			System.out.println();
		}
	} 
	private void swap(int x, int y) {
		int tmp;
		tmp = Heap[x];
		Heap[x] = Heap[y];
		Heap[y] = tmp;
	}
	public static void main(String[] arg)
      {
	    MinHeap minHeap = new MinHeap(7);
	    minHeap.insert(3);
	    minHeap.insert(13);
	    minHeap.insert(7);
          minHeap.insert(16);
	    minHeap.insert(21);
	    minHeap.insert(12);
	    minHeap.insert(9);
	    minHeap.minHeap();

	   System.out.println("Minumum yigin : " + Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	   System.out.println("\nMinumum deger : " + minHeap.remove());
	   System.out.println("\nMinumum deger:"+ Arrays.toString(minHeap.Heap));
	   minHeap.printHeap();
	}
}
