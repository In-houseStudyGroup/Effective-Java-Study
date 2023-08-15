package item2BuilderPattern;

import java.util.Objects;

public class BuilderPatternClass2_Extends1 extends BuilderPatternClass2 {
    
    public enum Numbers { ONE, TWO, THREE }
    private final Numbers numbers;
    
    private BuilderPatternClass2_Extends1(Builder builder) {
        super(builder);
        numbers = builder.numbers;
    }
    
    public static class Builder extends BuilderPatternClass2.Builder <Builder> {
        
        private final Numbers numbers;
        
        public Builder(Numbers numbers) {
            this.numbers = Objects.requireNonNull(numbers);
        }
        
        @Override
        public BuilderPatternClass2_Extends1 build() {
            return new BuilderPatternClass2_Extends1(this);
        }
        
        @Override
        protected Builder self() { return this; }
    }
    
    public void print() {
        System.out.println("이건 1");
        super.print();
        System.out.println("☆ numbers: " + numbers);
    }
}
