package item2BuilderPattern;

public class BuilderPatternMainClass {
    
    enum Numbers { ONE, TWO, THREE };
    enum Alphabet { A, B, C, D, E };
    
    public static void main(String... args) {
        
        BuilderPatternClass1 builderPatternClass1 = new BuilderPatternClass1
                .Builder(12, 8)
                .c(100)
                .d(200)
                .e(300)
                .build();

        builderPatternClass1.print();

        System.out.println("---------------------------------------------");
        
        BuilderPatternClass2 builderPatternClass2 = new BuilderPatternClass2_Extends1
                .Builder(BuilderPatternClass2_Extends1.Numbers.TWO)
                .addElements(BuilderPatternClass2.Elements.A)
                .addElements(BuilderPatternClass2.Elements.C)
                .build();
        
        builderPatternClass2.print();
        
        System.out.println("---------------------------------------------");
        
        builderPatternClass2 = new BuilderPatternClass2_Extends2
                .Builder()
                .addElements(BuilderPatternClass2.Elements.A)
                .addElements(BuilderPatternClass2.Elements.D)
                .isEasy()
                .build();
        
        builderPatternClass2.print();
        
        System.out.println("---------------------------------------------");
        
        Book book = new Book
                .Builder(1L, "이펙티브 자바", "Joshua Bloch", 1L)
                .content("전 구글 개발자가 알려주는 코드를 활용하는 방법")
                .isDomestic("N")
                .bigType(1L)
//                .middleType(1L)
//                .smallType(1L)
                .country(2)
                .build();
        
        book.print();
    }
}
