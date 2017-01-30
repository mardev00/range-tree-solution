package com.dev.rangetree;

import  org.junit.Assert;

import com.dev.rangetree.RangeTree;

import java.util.List;
import org.junit.*;


public class RangeTreeTest {

	/**
	 * EXAMPLES: If the input = [94133,94133] [94200,94299] [94600,94699]
	 * Then the output should be = [94133,94133] [94200,94299] [94600,94699]
	 * 
	 * If the input = [94133,94133] [94200,94299] [94226,94399] Then the
	 * output should be = [94133,94133] [94200,94399]
	 */
	@Test
	public void testRangesNotOverlapping() {
		RangeTree rt = new RangeTree();

		// TEST CASE 1
		String[] range1 = { "94133", "94133" };
		String[] range2 = { "94200", "94299" };
		String[] range3 = { "94600", "94699" };
		String[][] testArray1 = new String[3][2];
		testArray1[0] = range1;
		testArray1[1] = range2;
		testArray1[2] = range3;

		
		List<String> flatRanges = rt.processRanges(testArray1);
		System.out.println("-------------------------------------------------------");
		System.out.println("OUTPUT TEST CASE 1: ");
		StringBuilder rangeBuilder = new StringBuilder();
		for (String range : flatRanges) {
			rangeBuilder.append(range);
			System.out.print(range);
		}
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		Assert.assertEquals("[94133,94133] [94200,94299] [94600,94699]", rangeBuilder.toString().trim());
		
	}
	
	@Test
	public void testOverlappingRanges() {
		RangeTree rt = new RangeTree();



		// TEST CASE 2
		String[] range4 = { "94133", "94133" };
		String[] range5 = { "94200", "94299" };
		String[] range6 = { "94200", "94399" };

		String[][] testArray2 = new String[3][2];
		testArray2[0] = range4;
		testArray2[1] = range5;
		testArray2[2] = range6;


		List<String> flatRanges2 = rt.processRanges(testArray2);
		System.out.println("-------------------------------------------------------");
		System.out.println("OUTPUT TEST CASE 2: ");
		System.out.println("-------------------------------------------------------");
		StringBuilder rangeBuilder = new StringBuilder();
		for (String range : flatRanges2) {
			rangeBuilder.append(range);
			System.out.print(range);
		}
		System.out.println(rangeBuilder.toString());
		Assert.assertEquals("[94133,94133] [94200,94299]", rangeBuilder.toString().trim());
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		
	}
	
	@Test
	public void testOverlappingRanges2() {
		RangeTree rt = new RangeTree();


		// TEST CASE 3
		String[] range4 = { "98500","98540" };
		String[] range5 = { "98520","98560" };
		String[] range6 = { "98621","98635" };

		String[][] testArray2 = new String[3][2];
		testArray2[0] = range4;
		testArray2[1] = range5;
		testArray2[2] = range6;


		List<String> flatRanges2 = rt.processRanges(testArray2);
		System.out.println("-------------------------------------------------------");
		System.out.println("OUTPUT TEST CASE 2: ");
		System.out.println("-------------------------------------------------------");
		StringBuilder rangeBuilder = new StringBuilder();
		for (String range : flatRanges2) {
			rangeBuilder.append(range);
			System.out.print(range);
		}
		System.out.println(rangeBuilder.toString());
		Assert.assertEquals("[98500,98560] [98621,98635]", rangeBuilder.toString().trim());
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		
	}
}
