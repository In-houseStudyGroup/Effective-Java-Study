package item8finalizeAndCleaner;

public class MainClass {
    
    public static void main(String... args) {
        try(Office office = new Office(10)) {
            System.out.println("office.toString(): " + office.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------");
        
        // 일반 try-catch 를 이용하면 Runnable 을 구현한 state 의 run 이 동작하지 않는다.
        // 이는 AutoCloseable 를 구현한 취지에 맞지 않는 행동이기 때문이다.
        Office office = new Office(10);
        
        try {
            System.out.println("office.toString(): " + office.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            office.close();
        }
    }
}
