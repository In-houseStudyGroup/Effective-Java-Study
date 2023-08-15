package item3Singleton;

public class SecondSingletonMainClass {
    
    public static void main(String... args) {
        SecondSingletonClass secondSingletonClass = SecondSingletonClass.getInstance();
        secondSingletonClass.setString("꼬꼬무");
        
        secondSingletonClass = SecondSingletonClass.getInstance();
        System.out.println("☆ string: " + secondSingletonClass.getString());

        System.out.println("☆ secondSingletonClass: " + System.identityHashCode(secondSingletonClass));
        System.out.println("☆ secondSingletonClass.getString: " + secondSingletonClass.getString());
        
        
    }
}
