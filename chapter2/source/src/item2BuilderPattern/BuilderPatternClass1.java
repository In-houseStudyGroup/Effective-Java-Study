package item2BuilderPattern;

public class BuilderPatternClass1 {
    // 필수
    private final int a;
    private final int b;
    // 선택
    private final int c;
    private final int d;
    private final int e;

    private BuilderPatternClass1(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    public void print() {
        System.out.println("☆ a: " + a);
        System.out.println("☆ b: " + b);
        System.out.println("☆ c: " + c);
        System.out.println("☆ d: " + d);
        System.out.println("☆ e: " + e);
    }

    public static class Builder {
        // 필수
        private final int a;
        private final int b;

        // 선택
        private int c;
        private int d;
        private int e;

        public Builder(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Builder c(int c) {
            this.c = c;
            return this;
        }

        public Builder d(int d) {
            this.d = d;
            return this;
        }

        public Builder e(int e) {
            this.e = e;
            return this;
        }

        public BuilderPatternClass1 build() {
            return new BuilderPatternClass1(this);
        }
    }
}
