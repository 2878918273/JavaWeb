package books.test;

import books.pojo.Cart;
import books.pojo.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wx
 * @create 2023-05-24 18:04
 */
public class CartTest {
//    Cart cart = new Cart();



    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(2,"仙剑1",1,20,20));
        cart.addItem(new CartItem(3,"遮天",1,40,40));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));

        System.out.println(cart);


    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(2,"仙剑1",1,20,20));
        cart.addItem(new CartItem(3,"遮天",1,40,40));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(2,"仙剑1",1,20,20));
        cart.addItem(new CartItem(3,"遮天",1,40,40));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(2,"仙剑1",1,20,20));
        cart.addItem(new CartItem(3,"遮天",1,40,40));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));

        cart.clear();
        System.out.println(cart);

        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        cart.addItem(new CartItem(1,"仙逆",1,50,50));
        System.out.println(cart);

        cart.updateCount(1,10);
        System.out.println(cart);

    }
}