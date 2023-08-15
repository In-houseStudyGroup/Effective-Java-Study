package item7CollectDependency;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACICY = 16;
    
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACICY];
    }
    
    public void push(Object e) {
        elements = ensureCapacity();
        elements[size++] = e;
    }
    
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        
        return result;
    }
    
    private Object[] ensureCapacity() {
//        if (elements.length == size) {
//            elements = Arrays.copyOf(elements, 2 * size + 1);
//        }
        
        int count = elements.length;
        if(elements.length == size) {
            count = 2 * size + 1;
        }
        
        Object[] copy = Arrays.copyOf(elements, count);
        
        return copy;
    }
}
