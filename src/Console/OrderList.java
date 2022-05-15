package Console;

import java.util.ArrayList;

public class OrderList {
    static ArrayList<Order> orderList = new ArrayList<>();
    static public Order od;
    public static void initializeOrder(){
        od = new Order();
    }
    public static void addOrderList(){
        orderList.add(od);
    }

    public static String toStringOrderList(){
        StringBuilder text = new StringBuilder("<html>");
        for(int i=0; i<orderList.size();++i){
            text.append(orderList.get(i).menu()).append("&nbsp;").append(orderList.get(i).price()).append("원").append("<br/>");
        }
        return text + "</html>";
    }
    public static int totalPrice(){
        int total = 0;
        for(int i=0; i<orderList.size();++i){
            total += orderList.get(i).price();
        }
        return total;
    }
}
