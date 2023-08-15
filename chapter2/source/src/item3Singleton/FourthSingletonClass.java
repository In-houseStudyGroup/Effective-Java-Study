package item3Singleton;

public class FourthSingletonClass {
    
    public volatile static FourthSingletonClass INSTANCE = new FourthSingletonClass();
    
    private int number;
    private String string;
    
    
    
    private FourthSingletonClass() {
        System.out.println("이거 실행되면 안되는데 FourthSingletonClass");
    }
    
    public void leaveOffice() {
        System.out.println("☆ leaveOffice");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
