package Console;

public class Order{
    //	ice/hot
    private Menu menu = null;
    private boolean ice = false;
    private boolean shot = false;
    private boolean syrup = false;
    private int quantity = 1;

    private boolean caffeine = false;
    public void print() {

    }

    public void getMenu(Menu a){
        menu = a;
    }
    public void getIce(boolean a){
        ice = a;
    }
    public void getShot(boolean a){
        shot = a;
    }
    public void getSyrup(boolean a){
        syrup = a;
    }
    public void getQuantity(int a){
        quantity = a;
    }
    public void setCaffeine(boolean s){caffeine = s;}

    private String toIce(){
        return ice ? "ICE" : "HOT";
    }
    private String toShot(){
        return shot ? "/샷추가" : "";
    }
    private String toSyrup(){
        return syrup ? "/시럽추가" : "";
    }
    @Override
    public String toString(){
        return "<html>&nbsp;"+menu.getName()+"<br/>&nbsp;"+toIce()+toShot()+toSyrup()+"<br/>&nbsp;"+quantity+"잔</html>";
    }

    public int price(){
        return menu.getPrice()*quantity;
    }
    public String menu(){
        return menu.getName();
    }
    public boolean isCaffeine(){return caffeine;}
}