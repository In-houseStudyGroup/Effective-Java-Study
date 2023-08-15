package item8finalizeAndCleaner;

import java.lang.ref.Cleaner;
public class Office implements AutoCloseable {
    
    private static final Cleaner cleaner = Cleaner.create();
    
    // 청소가 필요한 자원, 절대 Office 를 참조해서는 안 된다.
    private static class State implements Runnable {
        // 쓰레기 개수
        int numJunkPiles;
        
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }
        
        // close 메서드나 cleaner 가 호출한다.
        @Override
        public void run() {
            System.out.println("사무실 청소");
            numJunkPiles = 0;
        }
    }
    
    // 사무실의 상태, cleanable 과 공유한다.
    private final State state;
    
    // cleanable 객체, 수거 대상이 되면 사무실을 청소한다.
    private final Cleaner.Cleanable cleanable;
    
    public Office(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    
    @Override
    public void close() {
        System.out.println("close()");
        cleanable.clean();
    }
}
