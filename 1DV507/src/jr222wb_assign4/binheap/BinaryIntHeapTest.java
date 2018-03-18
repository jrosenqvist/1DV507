package jr222wb_assign4.binheap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryIntHeapTest {	

	@Test
	void testInsertAndSizeAndIsEmpty() {
		//Large heap
		BinaryIntHeap bih = new BinaryIntHeap();
		for (int i = 0; i < 100000; i++)
			bih.insert(i);				
		assertEquals(100000, bih.size());
		assertEquals(false, bih.isEmpty());
		
		//Small heap
		BinaryIntHeap bih2 = new BinaryIntHeap();
		assertEquals(true, bih2.isEmpty());
		assertEquals(0, bih2.size());
		bih2.insert(5);
		assertEquals(1, bih2.size());
	}
	
	@Test
	void testPull() {
		BinaryIntHeap bih = new BinaryIntHeap();
		//Fill with vaues 0-99
		for (int i = 0; i < 100000; i++)
			bih.insert(i);
		//Make sure highest value always is pulled
		for (int i = 0; i < bih.size(); i++)
			assertEquals(99999 - i, bih.pullHighest());
		
		//More randomized distribution
		BinaryIntHeap bih2 = new BinaryIntHeap();
		bih2.insert(5);
		bih2.insert(-2);
		bih2.insert(7671);
		bih2.insert(1);
		bih2.insert(-57571);		
		assertEquals(7671, bih2.pullHighest());
		assertEquals(5, bih2.pullHighest());
		assertEquals(1, bih2.pullHighest());
		assertEquals(-2, bih2.pullHighest());
		assertEquals(-57571, bih2.pullHighest());
	}

}
