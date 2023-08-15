package item6AvoidToGetInstance;

public class MainClass {
    
    public static void main(String... args) {

        String s = new String("bikini");
        Boolean b = new Boolean(true);
        
        double start = System.currentTimeMillis();
        
//        Long sum = 0L;    // takes: 5.997 sec
        long sum = 0L;    // takes: 0.627 sec
        for (long i = 0L; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        
        double end = System.currentTimeMillis();

        System.out.println("☆ sum: " + sum);
        System.out.println("☆ takes: " + ((end - start) / 1000) + " sec");
    }
}
