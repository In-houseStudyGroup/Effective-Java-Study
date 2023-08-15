package stringMemory;

/**
 * @see "결론"
 * @see "
 * 가공 메소드(toUpperCase, toLowerCase, String.split(str) 등) 에 의해 인스턴스를 획득한 객체는 Heap에 저장되는 것 같다.
 * 하지만 toUpperCase, toLowerCase 같은 경우 특이점이 발견되었다.
 * 위 두 메소드의 반환으로 획득한 인스턴스의 값이 문자열 풀에 존재하는 데이터일 경우 해당 데이터의 참조(주소값)을 그대로 이용했다는 점.
 * 똑같이 메소드를 이용하지만 String.split(str) 후 String.join("", strArray) 경우는 새로 인스턴스를 획득했다.
 * 이건 String을 뜯는 방법 밖에 없겠다.
 * "
 */
public class StringMemoryMainClass {
    
    public static void main(String... args) {
        String aaa1 = "aaa";
        String aaa2 = "aaa";
        String aaa3 = new String("aaa");
        String aaa4 = new String("aaa");
        String aaa5 = new StringBuilder("aaa")
                .toString();
        String aaa6 = new StringBuilder()
                .append("aaa")
                .toString();

        System.out.println("☆ aaa1: " + System.identityHashCode(aaa1));
        System.out.println("☆ aaa2: " + System.identityHashCode(aaa2));
        System.out.println("☆ aaa3: " + System.identityHashCode(aaa3));
        System.out.println("☆ aaa4: " + System.identityHashCode(aaa4));
        System.out.println("☆ aaa5: " + System.identityHashCode(aaa5));
        System.out.println("☆ aaa6: " + System.identityHashCode(aaa6));
        
        String[] aaa1Array = new String().split(aaa1);
        String aaa7 = String.join("", aaa1Array);
        System.out.println("-------------------------------------------------------------------- 가공 중 --------------------------------------------------------------------");
        System.out.println("☆ aaa1: " + System.identityHashCode(aaa1));
        System.out.println("☆ aaa7: " + System.identityHashCode(aaa7));
        
        String aaa8 = aaa1.toUpperCase().toLowerCase();
        String aaa9 = aaa1.toLowerCase();
        System.out.println("☆ aaa8: " + System.identityHashCode(aaa8));
        System.out.println("☆ aaa9: " + System.identityHashCode(aaa9));
        
        System.out.println("-------------------------------------------------------------------- 가공 중 --------------------------------------------------------------------");
        
        String AAA1 = "AAA";
        String AAA2 = aaa1.toUpperCase();
        String AAA3 = new String("AAA");
        String AAA4 = AAA1.toUpperCase();
        System.out.println("☆ AAA1: " + System.identityHashCode(AAA1));
        System.out.println("☆ AAA2: " + System.identityHashCode(AAA2));
        System.out.println("☆ AAA3: " + System.identityHashCode(AAA3));
        System.out.println("☆ AAA4: " + System.identityHashCode(AAA4));
        
        String aaa10 = AAA1.toLowerCase();
        System.out.println("☆ aaa10: " + System.identityHashCode(aaa10));
    }
}
