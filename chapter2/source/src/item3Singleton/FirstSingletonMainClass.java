package item3Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FirstSingletonMainClass {
    
    public static void main(String... args) {
        FirstSingletonClass firstSingletonClass = FirstSingletonClass.INSTANCE;
        firstSingletonClass.setString("무야호~");
        firstSingletonClass = FirstSingletonClass.INSTANCE;
        System.out.println("그만큼 신나신 거지~ " + firstSingletonClass.getString());

        // private 생성자를 reflect 를 통해 접근하기
        FirstSingletonClass isNotAgreedInstance = null;
        
        try {
            // 클래스를 제네릭 와일드카드를 통해 가져오기
            Class<?> targetClass = FirstSingletonClass.class;
            
            // 파라미터가 없고 private 으로 선언된 기본 생성자를 가져오기(NoSuchMethodException 발생 가능(메소드가 없는 경우 예외 던짐))
            Constructor<?> privateConstructor = targetClass.getDeclaredConstructor();
            
            // setAccessible 메서드를 통해 private 등의 접근 제한자로 막힌 메소드의 접근을 허용 - 이 부분이 책에서 설명한 내용
            privateConstructor.setAccessible(true);
            
            // newInstance() 메서드를 통해 Object 를 반환할 때, 명시적 박싱을 통해 원하는 클래스로 형변환
            // InvocationTargetException: invoke 시에 메서드에서 발생한 exception 이 마치 invoke 구문에서 발생한 것처럼 보이기 때문에 InvocationTargetException 자체의 stack trace 만으로 에러를 해결하기 어렵다.
                // 그래서 Wrapping 한 예외 클래스이다.
            // InstantiationException: newInstance() 메서드를 통해 인스턴스 생성 시에, 지정된 객체의 인스턴스를 생성할 수 없는 경우에 throw
            // IllegalAccessException: 허가되지 않은 객체, 메서드, 필드 등에 접근하려 할 경우 발생
            isNotAgreedInstance = (FirstSingletonClass) privateConstructor.newInstance();
            
            // 접근성을 되돌려 코드 무결성을 유지
            privateConstructor.setAccessible(false);
        } catch (NoSuchMethodException noSuchMethodException) {
            // 이건 사실 추천하지 않는 방법이다.
            // 로그에 정확한 예외 발생 위치가 노출되기 때문에 보안에 위협이 될 수 있다.
            noSuchMethodException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

        System.out.println("☆ firstSingletonClass: " + System.identityHashCode(firstSingletonClass));
        System.out.println("☆ isNotAgreedInstance: " + System.identityHashCode(isNotAgreedInstance));
        System.out.println("☆ firstSingletonClass.getString: " + firstSingletonClass.getString());
        System.out.println("☆ isNotAgreedInstance.getString: " + isNotAgreedInstance.getString());
    }
}
