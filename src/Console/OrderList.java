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
            text.append(orderList.get(i).menu()).append("&nbsp;").append(orderList.get(i).price()).append("<br/>");
        }
        return text + "</html>";
    }
}
