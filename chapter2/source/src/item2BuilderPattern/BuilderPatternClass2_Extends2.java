package item2BuilderPattern;

public class BuilderPatternClass2_Extends2 extends BuilderPatternClass2 {
    
    private final boolean isEasy;
    
    private BuilderPatternClass2_Extends2(Builder builder) {
        super(builder);
        this.isEasy = builder.isEasy;
    }
    
    public static class Builder extends BuilderPatternClass2.Builder <Builder> {
        
        private boolean isEasy = false;         // 기본값
        
        public Builder isEasy() {
            isEasy = true;
            return this;
        }
        
        @Override
        public BuilderPatternClass2_Extends2 build() {
            return new BuilderPatternClass2_Extends2(this);
        }
        
        @Override
        protected Builder self() { return this; }
    }
    
    public void print() {
        System.out.println("이건 2");
        super.print();
        System.out.println("☆ isEasy: " + isEasy);
    }
}
