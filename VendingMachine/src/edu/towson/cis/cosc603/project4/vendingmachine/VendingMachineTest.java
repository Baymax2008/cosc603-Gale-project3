package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine building6008VendingMachine;
	VendingMachineItem reeseCup, butterfingers, milkyWay, fifthAvenue, payDay;
	
	@Before
	public void setUp() throws Exception {
		building6008VendingMachine = new VendingMachine();
		reeseCup = new VendingMachineItem( "Reese Cup", 0.75);
		butterfingers = new VendingMachineItem( "Butterfingers", 1.00);
		milkyWay = new VendingMachineItem( "Milky Way", 1.25);
		fifthAvenue = new VendingMachineItem( "5th Avenue", 1.50);
		payDay = new VendingMachineItem("Pay Day", 1.75);
	}

	@After
	public void tearDown() throws Exception {
		building6008VendingMachine = null;
		reeseCup = null;
		butterfingers = null;
		milkyWay = null;
		fifthAvenue = null;
		payDay = null;
	}

	@Test
	public final void testAddItemGoodPosition() {
		building6008VendingMachine.addItem(reeseCup, "A");
		assertEquals(reeseCup, building6008VendingMachine.getItem("A"));
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItemBadPostion() {
		building6008VendingMachine.addItem(reeseCup, "E");
		
	}

	@Test(expected = VendingMachineException.class)
	public final void testAddItemDuplicatedPostion() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "A");
	}
	
	@Test
	public final void testAddItemFull() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		assertEquals(reeseCup, building6008VendingMachine.getItem("A"));
		assertEquals(butterfingers, building6008VendingMachine.getItem("B"));
		assertEquals(milkyWay, building6008VendingMachine.getItem("C"));
		assertEquals(fifthAvenue, building6008VendingMachine.getItem("D"));
	}
	
	@Test
	public final void testRemoveItemGood() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		building6008VendingMachine.removeItem("B");
		assertEquals(null, building6008VendingMachine.getItem("B"));
		
	}
	
	@Test
	public final void testRemoveItemGoodReturn() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		VendingMachineItem temp = building6008VendingMachine.removeItem("B");
		
		assertEquals(butterfingers, temp);

		
	}
	
	@Test
	public final void testRemoveItemAddAnother() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.addItem(butterfingers, "B");
		building6008VendingMachine.addItem(milkyWay, "C");
		building6008VendingMachine.addItem(fifthAvenue, "D");
		
		building6008VendingMachine.removeItem("B");
		building6008VendingMachine.addItem(payDay, "B");
		
		assertEquals(payDay, building6008VendingMachine.getItem("B"));
		
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testRemoveItemEnempty() {
		building6008VendingMachine.removeItem("B");
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testRemoveItemInvalid() {
		building6008VendingMachine.removeItem("E");
	}

	@Test
	public final void testInsertMoneyPosAmount() {
		building6008VendingMachine.insertMoney(1.00);
		assertEquals(1.00, building6008VendingMachine.getBalance(), 0.0001);
	}
	
	@Test
	public final void testInsertMoneyPosAmountTwice() {
		building6008VendingMachine.insertMoney(1.00);
		building6008VendingMachine.insertMoney(0.50);
		assertEquals(1.50, building6008VendingMachine.getBalance(), 0.0001);
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testInsertMoneyNegAmount() {
		building6008VendingMachine.insertMoney(-1.00);
	}
	

	@Test
	public final void testGetBalance() {
		building6008VendingMachine.insertMoney(1.00);
		assertEquals(1.00, building6008VendingMachine.getBalance(), 0.0001);
	}

	@Test
	public final void testMakePurchaseGoodReturn() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		boolean temp = building6008VendingMachine.makePurchase("A");
		
		assertEquals(true, temp);
	}
	
	@Test
	public final void testMakePurchaseGoodBalance() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(.750);
		building6008VendingMachine.makePurchase("A");
		
		assertEquals(0.00, building6008VendingMachine.getBalance(), 0.0001);
	}
	
	@Test
	public final void testMakePurchaseBadBalance() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(0.50);
		boolean temp = building6008VendingMachine.makePurchase("A");
		
		assertEquals(false, temp);
	}
	
	@Test
	public final void testMakePurchaseBadSelection() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(0.750);
		boolean temp = building6008VendingMachine.makePurchase("B");
		
		assertEquals(false, temp);
	}

	@Test
	public final void testReturnChangeRightAmount() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(1.750);
		building6008VendingMachine.makePurchase("A");
		double temp = building6008VendingMachine.returnChange();
		
		assertEquals(1.00, temp, .0001);
	}
	
	@Test
	public final void testReturnChangeBalanceSet() {
		building6008VendingMachine.addItem(reeseCup, "A");
		building6008VendingMachine.insertMoney(1.750);
		building6008VendingMachine.makePurchase("A");
		building6008VendingMachine.returnChange();
		
		assertEquals(0.00, building6008VendingMachine.getBalance(), 0.0001);
	}

}
