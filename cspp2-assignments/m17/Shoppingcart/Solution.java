/**
 * @author: manojbandari.
 */
import java.util.Scanner;
import java.io.BufferedInputStream;

/**
 * Class for item.
 */
class Item {
    /**
     * { var_description }.
     */
    private String productName;
    /**
     * { var_description }.
     */
    private int quantity;
    /**
     * { var_description }.
     */
    private float unitPrice;

    /**
     * Gets the product name.
     *
     * @return     The product name.
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Gets the unit price.
     *
     * @return     The unit price.
     */
    public float getUnitPrice() {
        return unitPrice;
    }
    /**
     * Sets the product name.
     * @param      productName1  The product name
     */
    public void setProductName(final String productName1) {
        this.productName = productName1;
    }
    /**
     * Sets the quanity.
     * @param      quantity1  The quantity
     */
    public void setQuanity(final int quantity1) {
        this.quantity = quantity1;

    }
    /**
     * Constructs the object.
     * @param      productName1  The product name
     * @param      quantity1     The quantity
     * @param      unitPrice1    The unit price
     */
    Item(final String productName1,
        final int quantity1, final  float unitPrice1) {
        this.productName = productName1;
        this.quantity = quantity1;
        this.unitPrice = unitPrice1;
    }

    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getProductName() + " "
               + this.getQuantity() + " " + this.getUnitPrice();

    }
}

/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private final int TEMP = 100;
    /**
     *  catalog size.
     */
    private int catalogSize;
    /**
     * cart size.
     */
    private int cartSize;
    /**
     * { var_description }.
     */
    private Item[] catalog;
    /**
     * { var_description }.
     */
    private Item[] cart;
    /**
     * { var_description }.
     */
    private boolean flag;
    /**
     * { var_description }.
     */
    private float couponcode;

    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new Item[TEMP];
        cart = new Item[TEMP];
        catalogSize = 0;
        cartSize = 0;
        flag = false;
        couponcode = 0.0f;
    }

    /**
     * Adds to catalog.
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        catalog[catalogSize++] = item;
    }

    /**
     * Adds to cartesian.
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getProductName().
                    equals(item.getProductName())) {
                cart[i].setQuanity(cart[i].getQuantity()
                                   + item.getQuantity());
                return;
            }
        }
        cart[cartSize++] = item;
    }

    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalogSize; i++) {
            System.out.println(
                catalog[i].getProductName()
                + " " + catalog[i].getQuantity()
                + " " + catalog[i].getUnitPrice());
        }
    }

    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartSize; i++) {
            System.out.println(cart[i].getProductName()
                               + " " + cart[i].getQuantity());
        }
    }

    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getProductName().equals(item.getProductName())) {
                if (cart[i].getQuantity() == item.getQuantity()) {
                    for (int j = i; j < cartSize; j++) {
                        cart[j] = cart[j + 1];
                    }
                    cartSize--;
                    return;
                }
                cart[i].setQuanity(cart[i].getQuantity() - item.getQuantity());
            }
        }
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public float totalAmount() {
        float sum = 0.0f;
        for (int i = 0; i < cartSize; i++) {
            for (int j = 0; j < catalogSize; j++) {
                if (cart[i].getProductName().equals(catalog[j].getProductName())) {
                    sum = sum + (cart[i].getQuantity() * catalog[j].getUnitPrice());
                }
            }
        }
        return sum;
    }

    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public float getPayableAmount() {
        float totalAmount = totalAmount();
        float discount = totalAmount * couponcode;
        float finalAmount = totalAmount - discount;
        float payableAmount = finalAmount + (finalAmount * 15 / 100);
        return payableAmount;
    }

    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
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
    /**
     * { function_description }.
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cartSize; i++) {
            for (int j = 0; j < catalogSize; j++) {
                if (cart[i].getProductName().
                        equals(catalog[j].getProductName())) {
                    System.out.println(cart[i].getProductName()
                                       + " " + cart[i].getQuantity()
                                       + " " + catalog[j].getUnitPrice());
                }
            }
        }
        //System.out.println("totalAmount: " + totalAmount());
        System.out.println("Total:" + totalAmount());
        float discount = totalAmount() * couponcode;
        System.out.println("Disc%:" + discount);
        float finalAmount = totalAmount() - discount;
        System.out.println("Tax:" + (finalAmount * 15 / 100));
        System.out.println("Payable amount: " + getPayableAmount());
    }

}

/**
 * Class for solution.
 */
class Solution {
    public static void main(final String[] args) {
        ShoppingCart s = new ShoppingCart();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = stdin.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] check = tokens[1].split(",");
                s.addToCatalog(new Item(check[0],
                                        Integer.parseInt(check[1]),
                                        Float.parseFloat(check[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                String[] check1 = tokens[1].split(",");
                s.addToCart(new Item(check1[0],
                                     Integer.parseInt(check1[1]), 0.0f));
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
                s.removeFromCart(new Item(check2[0],
                                          Integer.parseInt(check2[1]), 0.0f));
                break;
            case "coupon":
                s.applyCoupon(tokens[1]);
                break;
            case "print":
                s.printInvoice();
                break;
            default:
                break;
            }
        }
    }
}
