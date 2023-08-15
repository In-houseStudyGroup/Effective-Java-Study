package item7CollectDependency;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MainClass {
    
    public static void main(String... args) {
        
        // 스택 구현
        Stack stack = new Stack();
        stack.push(new StringBuilder("와우"));
        stack.push(new StringBuilder("우와"));
        stack.push(new StringBuilder("우유"));
        stack.push(new StringBuilder("유우"));
        
        String str = (String) stack.pop().toString();
        System.out.println("☆ str: " + str);

        WeakHashMap<String, String> map1 = new WeakHashMap<>();
        Map<String, String> map2 = new HashMap<>();
        
        String key1 = "리터럴1";                           // 이건 weak reference 의 영향을 받지 않는다.
        String key2 = new String("new 연산자");
        
        map1.put(key1, "100");
        map1.put(key2, "200");
        
        map2.put(key1, "100");
        map2.put(key2, "200");                              // 여기서 put으로 key2의 참조가 다시 생긴다.
                                                            // 즉, 다른 객체에 다시 참조를 건다면 WeakHashMap 의 참조도 잃지 않고 유지된다.
        
        key1 = null;
        key2 = null;
        
        System.gc();

        System.out.println("map1: " + map1);
        System.out.println("map2: " + map2);
    }
}
