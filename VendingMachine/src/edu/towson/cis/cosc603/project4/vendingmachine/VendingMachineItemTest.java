package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import edu.towson.cis.cosc603.project4.rectangle.Rectangle;

public class VendingMachineItemTest {
	
	/** Declaring necessary test objects for  */
	VendingMachineItem reeseCup;

	@Before
	public void setUp() throws Exception {
		
		reeseCup = new VendingMachineItem( "Reese Cup", 1.00);
		
	}

	@After
	public void tearDown() throws Exception {
		
		reeseCup = null;
		
	}

	@Test(expected = VendingMachineException.class)
	public final void testVendingMachineItemNegPrice() {
		VendingMachineItem butterFingers = new VendingMachineItem( "Butter Fingers", -1.00);
	}

	@Test
	public final void testVendingMachineItemNormal() {
		String butterFingerName = "Butter Fingers";
		VendingMachineItem butterFingers = new VendingMachineItem( butterFingerName, 1.00);
		assertEquals(butterFingerName, butterFingers.getName());
	}
	
	@Test
	public final void testGetName() {
		assertEquals("Reese Cup", reeseCup.getName());
	}

	@Test
	public final void testGetPrice() {
		assertEquals(1.00, reeseCup.getPrice(),0.001);
	}

}
