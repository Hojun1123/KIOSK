package Console;

public class ClassControl {
    Manager<Menu> menuList = new Manager<>();
    Manager<Menu> coffee = new Manager<>();
    Manager<Menu> latte = new Manager<>();
    Manager<Menu> smoothie = new Manager<>();
    Manager<Menu> tea = new Manager<>();


    public ClassControl() {
        coffee.readAll("txtfile//coffee.txt", () -> new Menu());
        latte.readAll("txtfile//latte.txt", () -> new Menu());
        smoothie.readAll("txtfile//smoothie.txt", () -> new Menu());
        tea.readAll("txtfile//tea.txt", () -> new Menu());
    }

    public void setMenuList(String menu) {
        if(menuList != null)
            menuList = null;
        switch (menu) {
            case "coffee" -> menuList = coffee;
            case "latte" -> menuList = latte;
            case "smoothie" -> menuList = smoothie;
            case "tea" -> menuList = tea;
            default -> throw new IllegalStateException("Unexpected value: " + menu);
        }
    }


    public Manager<Menu> getMenuList() {
        return menuList;
    }

}
