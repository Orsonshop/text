package design;


import java.util.ArrayList;
import java.util.List;

interface  PaymentStrateay{
    boolean pay(float amount);
}
class CreditCartStraTeay implements PaymentStrateay{
    private String cardnumber;
    private String cvv;
    private String name;
    private String dateOfExpiry;

    public CreditCartStraTeay(String cardnumber, String cvv, String name, String dateOfExpiry) {
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.name = name;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean pay(float amount) {
        System.out.println(amount+"paid with credit");
        return true;
    }
}
class WechatStrategy implements PaymentStrateay{
   private  String arCode;

   public  WechatStrategy(String qrcode){
       qrcode=this.arCode;
   }
    @Override
    public boolean pay(float amount) {
        System.out.println(amount+"paid with Wechat");
        return  true;
    }
}
class  Item{
    private  String upcCode;
    private float price;

    public Item(String upcCode, float price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public float getPrice() {
        return price;
    }
}
class  Cart{
    List<Item> items;


    public Cart() {
        this.items=new ArrayList<>();
    }
    public  void addItem(Item item){
        this.items.add(item);
    }
    public  void removeItem(Item item){
        this.items.remove(item);
    }

    public void pay(PaymentStrateay paymentStrateay) {   //传入接口
        if (this.items.size() > 0) {
            float total = calculateTotal();
            boolean issuccess = paymentStrateay.pay(total);

            if (issuccess) {
                this.items.clear();

            } else {
                System.out.println("payment failed");
            }
        }
          else{
                System.out.println("");
            }
        }


    private float calculateTotal() {
        float totalPrice=0f;
        for(Item item:items) {
            totalPrice+=item.getPrice();
        }
        return  totalPrice;
    }
}
public class ShoppingCart{
    public static void main(String[] args) {


        Cart cart = new Cart();

        Item apple = new Item("ipone", 100.2f);
        Item banana = new Item("banana", 23.6f);
        Item noddle = new Item("InstantNoddle", 120f);

        cart.addItem(apple);
        cart.addItem(banana);

        cart.pay(new WechatStrategy("101010101"));
        cart.pay(new CreditCartStraTeay("144444444","2qw","adf","adf" ));
    }
}
