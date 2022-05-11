package Console;

public class Order{
    //	ice/hot
    private Menu menu;
    private boolean ice = false;
    private boolean shot = false;
    private boolean syrup = false;
    private int quantity = 1;

    public Order(){

    }

    public void print() {

    }

    public void getMenu(Menu a){
        this.menu = a;
    }
    public void getIce(boolean a){
        this.ice = a;
    }
    public void getShot(boolean a){
        this.shot = a;
    }
    public void getSyrup(boolean a){
        this.syrup = a;
    }
    public  void getQuantity(int a){
        this.quantity = a;
    }
}