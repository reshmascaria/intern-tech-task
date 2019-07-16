package shoppingCart;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;




class ShoppingCartClassTest {

	/*
	 * To test whether product is successfully added to cart
	 */
	@Test
	public void isSuccessfullyAddedTest() throws IOException{
		Cart shopping = new Cart();
		int pid= 103;
		assertTrue("error insertion",shopping.addToCartByPid(pid) );
	}
	
	/*
	 * To test whether product is successfully removed from cart
	 * As cart is initially empty, first two products are added and then second product is deleted
	 */
	@Test
	public void isSuccessfullyRemovedTest() throws IOException{
		Cart shopping = new Cart();
		int pid = 101;
		
		assertTrue("insertion error",shopping.addToCartByPid(pid) );

		pid = 102;
		assertTrue("insertion error",shopping.addToCartByPid(pid) );

		assertTrue("deletion error", shopping.removeFromCartByPid(pid));
	}
	
}
