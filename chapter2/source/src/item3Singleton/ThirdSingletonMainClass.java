package item3Singleton;

public class ThirdSingletonMainClass {
    
    public static void main(String... args) {
        FifthSingletonClass fifthSingletonClass = FifthSingletonClass.getInstance();
        
        System.out.println("☆ fifthSingletonClass: " + System.identityHashCode(fifthSingletonClass));
    }
}
