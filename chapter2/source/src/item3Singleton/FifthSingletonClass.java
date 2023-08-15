package item3Singleton;

public class FifthSingletonClass {
    
    
    private volatile static FifthSingletonClass instance;
    
    private FifthSingletonClass() {
        System.out.println("정상적으로 생성되는가");
    }

    // Lazy Initialization. DCL
    public static FifthSingletonClass getInstance() {
        if(instance == null) {
            synchronized(FifthSingletonClass.class) {
                if(instance == null) {
                    instance = new FifthSingletonClass(); 
                }
            }
        }
        return instance;
    }
}
