import java.util.*;
import java.io.*;

class Item {
	private String productName;
	int quantity;
	private float unitPrice;
	public String getProductName() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setQuanity(int quantity) {
		this.quantity = quantity;

	}
	Item(String productName, int quantity, float unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	/*Item(String productName,int quantity) {
		this.productName=productName;
		this.quantity=quantity;
	}*/
	public String toString() {
		return this.getProductName() + " " + this.getQuantity() + " " + this.getUnitPrice();

	}
}
class ShoppingCart {
	int catalogSize;
	int cartSize;
	Item[] catalog;
	Item[] cart;
	boolean flag;
	float couponcode;
	ShoppingCart() {
		catalog = new Item[100];
		cart = new Item[100];
		catalogSize = 0;
		cartSize = 0;
		flag = false;
		couponcode = 0.0f;
	}
	public void addToCatalog(Item item) {
		catalog[catalogSize++] = item;
	}
	public void addToCart(Item item) {
		for (int i = 0; i < cartSize; i++) {
			if (cart[i].getProductName() == item.getProductName()) {
				cart[i].setQuanity(cart[i].getQuantity() + item.getQuantity());
			}
		}
		cart[cartSize++] = item;
	}
	public void showCatalog() {
		for (int i = 0; i < catalogSize; i++) {
			System.out.println(catalog[i].getProductName() + " " + catalog[i].getQuantity() + " " + catalog[i].getUnitPrice());
		}
	}
	public void showCart() {
		for (int i = 0; i < cartSize; i++) {
			System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity());
		}
	}
	public void removeFromCart(Item item) {
		for (int i = 0; i < cartSize; i++) {
			if (cart[i].getProductName().equals(item.getProductName())) {
				cart[i].setQuanity(cart[i].getQuantity() - item.getQuantity());
				if (cart[i].getQuantity() == 0) {
					cart[i] = cart[i + 1];
					cartSize--;
				}
			}
		}
	}
	public float totalAmount() {
		float sum = 0.0f;
		for (int i = 0; i < cartSize; i++) {
			for (int j = 0; j < catalogSize; j++) {
				if (cart[i].getProductName().equals(catalog[j].getProductName()))
					sum = sum + (cart[i].getQuantity() * catalog[j].getUnitPrice());
			}
		}
		return sum;
	}
	public float getPayableAmount() {
		float totalAmount = totalAmount();
		float discount = totalAmount * couponcode;
		float finalAmount = totalAmount - discount;
		float payableAmount = finalAmount + (finalAmount * 15 / 100);
		return payableAmount;
	}
	public void applyCoupon(String coupon) {
		if (flag == false) {
			if (coupon.equals("IND10")) {
				couponcode = 0.1f;
			} else if (coupon.equals("IND20")) {
				couponcode = 0.2f;
			} else if (coupon.equals("IND30")) {
				couponcode = 0.3f;
			} else if (coupon.equals("IND50")) {
				couponcode = 0.5f;
			} else {
				System.out.println("Invalid coupon");
				return;
			}
			flag = true;
		}
	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartSize; i++) {
			for (int j = 0; j < catalogSize; j++) {
				if (cart[i].getProductName().equals(catalog[j].getProductName()))
					System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity() + " " + catalog[j].getUnitPrice());
			}
		}
		System.out.println("totalAmount:" + totalAmount());
		System.out.println("Total:" + totalAmount());
		float discount = totalAmount() * couponcode;
		System.out.println("Disc%:" + discount);
		float finalAmount = totalAmount() - discount;
		System.out.println("Tax:" + (finalAmount * 15 / 100));
		System.out.println("Payable amount:" + getPayableAmount());
	}

}
class Solution {
	public static void main(String[] args) {
		ShoppingCart s = new ShoppingCart();
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int testCases = Integer.parseInt(stdin.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = stdin.nextLine().split(" ");
			switch (tokens[0]) {
			case "Item":
				String[] check = tokens[1].split(",");
				s.addToCatalog(new Item(check[0], Integer.parseInt(check[1]), Float.parseFloat(check[2])));
				break;
			case "catalog":
				s.showCatalog();
				break;
			case "add":
				String[] check1 = tokens[1].split(",");
				s.addToCart(new Item(check1[0], Integer.parseInt(check1[1]), 0.0f));
				break;
			case "show":
				s.showCart();
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + s.totalAmount());
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + s.getPayableAmount());

				break;
			case "remove":
				String[] check2 = tokens[1].split(",");
				s.removeFromCart(new Item(check2[0], Integer.parseInt(check2[1]), 0.0f));
				break;
			case "coupon":
				s.applyCoupon(tokens[1]);
				break;
			case "print":
				s.printInvoice();
				break;
			}
		}
	}
}
