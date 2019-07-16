package shoppingCart;

import java.util.*;


class Product {  
	int productID, productPrice;  
	String productName;    
	public Product(int productID, String productName, int productPrice) {  
		this.productID = productID; 
		this.productName = productName; 
		this.productPrice = productPrice;   
	}  
	
	/*
	 * @return productID
	 */
	public int getPid() {
		return productID;
	}
	
	/*
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
	    }
		return true;
	}
}  

/*
 *Class to store product details. Five products are available in the store
 */

class Products{
	final List<Product> products = new ArrayList<Product>();
	
	public Products(){
		//Creating Products  
	    Product p1 = new Product(101,"iphone7",749);  
	    Product p2 = new Product(102,"iphone 7 plus", 929);  
	    Product p3 = new Product(103,"iphone 8", 979);
	    Product p4 = new Product(104,"iphone XR", 1229);
	    Product p5 = new Product(105,"iphone XS", 1629);
	    
	    //Adding Product to list  
	    products.add(p1);  
	    products.add(p2);  
	    products.add(p3); 
	    products.add(p4);
	    products.add(p5);
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
}

class User{
	String userID, userName;
	int cartID;
	
	public User (String userID, String userName, int cartID) {
		this.userID = userID;
		this.userName = userName;
		this.cartID = cartID;
	}
	
	/*
	 * @return username
	 */
	public String getUserName() {
		return userName;
	}
	
	/*
	 * @return cartID
	 */
	
	public Integer getCartID() {
		return cartID;
	}
}


/*
 * Class to store user details. Three users are present in the store.
 * Each user has userId, username and cartID
 */
class Users{
	final List<User> users = new ArrayList<User>();
	
	public Users(){
		//Creating users
		User u1 = new User("jsmith", "John Smith", 1001);
		User u2 = new User("lmason", "Lily Mason", 1002);
		User u3 = new User("fhills", "Frank Hills", 1003);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
	}
	
	public List<User> getUsers(){
		return users;
	}	
}


/*
 * Cart class to store cart details. 
 */

class Cart{
	List<Product> cartItems = new ArrayList<Product>();
	
	public Boolean addToCartByPid(int pid) {
		Product product = getProductByPid(pid);
		Boolean resultFinal = addToCart(product);
		return resultFinal;
	}
	
	public Product getProductByPid(int pid) {
		Product product = null;
		List<Product> products  = new Products().getProducts();
		for(Product prod: products) {
			if(prod.getPid() == pid) {
				product = prod;
				break;
			}
		}
		return product;
		
	}
	
	public Boolean addToCart(Product product) {
		boolean result = cartItems.add(product);
		return result;
	}
	
	public Boolean removeFromCartByPid(int pid) {
		Product prod = getProductByPid(pid);
		Boolean removeResult = cartItems.remove(prod);
		System.out.println("Successfully deleted");
		return removeResult;
	}
	
	public void printCartItems() {
		System.out.println("\nYour cart contains following items");
		for(Product prod: cartItems) {
			System.out.println(prod.getPid()+"\t"+prod.getProductName());
		}
	}
}



public class ShoppingCartClass {  
	
    List<User> users = new Users().getUsers();
    
    int flag =0, cartID = 0;
    String userName;
    private int ch = 0; 
    Cart cart = new Cart();
	Scanner scanner = new Scanner (System.in);

    public void InitialOut() {
    	System.out.println("Enter userId : ");
		String user = scanner.nextLine();
		
		/*
		 * User is identified based on user Id and welcome message is displayed
		 */
		for(User u:users) {
			if(user.equals(u.userID)) {
				flag = 1;
				userName = u.userName;
				cartID = u.cartID; 
				break;
			}
			else
				continue;
		}
		if(flag == 1) {
			System.out.println("Welcome " + userName);
	    	System.out.println("\nOur shop contains the following products");
			DisplayAllProducts();	
	   	    initialMenu();
			
    	}
    	else
    		System.out.println("Invalid user");

    }
    
    public void DisplayAllProducts() {
    	// Entire products in the shop is displayed
		List<Product> products = new Products().getProducts(); 
 	    //Traversing list of products in store
  	    System.out.println("PRODUCT ID \t PRODUCT NAME \t\t PRICE" );
   	    for(Product p:products){  
   	    	System.out.println(p.productID+"\t\t "+p.productName+"\t\t "+p.productPrice);  
   	    }
    }
    
    /*
     * Initially, only product can be added to cart, as cart is empty
     */
    public void initialMenu() {
    	System.out.println("\n1. Add to Cart");
		System.out.println("0.Exit");
    	do {
    		getUserOption();
    		
    		switch (ch) {
	    		case 0:
	    			System.exit(0);
	    			break;
	    			
	    		case 1:
	    			addProductToCart();
	    			displayCart();
	    			break;
	    		default:
	    			break;
    		}
    	}while (ch != 0);
    }
    
    public void menu() {
    	System.out.println("\n1. Display all Products");
    	System.out.println("2. Add to Cart");
    	System.out.println("3. Remove from Cart");
    	System.out.println("0. Exit");
    	
    	do {
    		getUserOption();
    		
    		switch(ch) {
	    		case 0:
	    			System.exit(0);
	    			break;
	    		case 1:
	    			DisplayAllProducts();
	    			initialMenu();
	    			break;
	    		case 2:
	    			addProductToCart();
	    			displayCart();
	    			break;
	    		case 3: 
	    			removeFromCart();
	    			displayCart();
	    			break;
	    		default:
	    			break;
    		}
    	}while(ch != 0);
    }
    
    /*
     * Product is added based on product ID
     */
    
    public void addProductToCart() {
    	System.out.println("Enter Product ID to add");
    	int pid = getUserOption();
    	cart.addToCartByPid(pid);
    }
    
    /*
     * Product from cart is removed based on product ID
     */
    public void removeFromCart() {
    	System.out.println("Enter Product ID to remove");
    	int pid = getUserOption();
    	cart.removeFromCartByPid(pid);
    	
    }
    
    /*
     * Products in cart are displayed
     */
    public void displayCart() {
    	cart.printCartItems();
    	menu();
    }
    
    /*
     * Scans user input
     */
    public int getUserOption() throws NumberFormatException {
		ch = scanner.nextInt();		
    	return ch;  	
    }
    
    /*
     * Initally user is checked and all products are displayed
     */
	public static void main(String[] args) {  
		ShoppingCartClass shop = new ShoppingCartClass();
		shop.InitialOut();

	}  
	
}  
