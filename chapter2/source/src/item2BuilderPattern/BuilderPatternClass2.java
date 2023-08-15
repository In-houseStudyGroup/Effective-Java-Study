package item2BuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class BuilderPatternClass2 {
    
    public enum Elements { A, B, C, D, E }
    final Set<Elements> elements;
    
    BuilderPatternClass2(Builder<?> builder) {
        // EnumSet 은 Cloneable 클래스를 구현하여 clone() 메소드가 구현되어 있다.
        elements = builder.elements.clone();
    }
    
    // 재귀적 타입 한정: 본인을 상속하는 제네릭 타입
    abstract static class Builder <T extends Builder<T>> {
        EnumSet<Elements> elements = EnumSet.noneOf(Elements.class);
        
        public T addElements(Elements elements) {
            this.elements.add(Objects.requireNonNull(elements));
            return self();
        }
        
        abstract BuilderPatternClass2 build();
        
        // 하위 클래스는 이 메서드를 재정의(Overriding) 하여
        // "this" 를 반환하도록 해야 한다.
        protected abstract T self();
    }
    
    public void print() {
        System.out.println("☆ elements: " + elements);
    }
}
