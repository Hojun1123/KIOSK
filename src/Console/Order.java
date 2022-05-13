package Console;

public class Order{
    //	ice/hot
    private String menu = "";
    private boolean ice = false;
    private boolean shot = false;
    private boolean syrup = false;
    private int quantity = 1;

    public void print() {

    }

    public void getMenu(String a){
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
        return "<html>"+menu+"<br/>옵션 : "+toIce()+toShot()+toSyrup()+"<br/>"+quantity+"잔</html>";
    }
}