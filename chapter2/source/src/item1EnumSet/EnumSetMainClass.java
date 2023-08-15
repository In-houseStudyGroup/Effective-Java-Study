package item1EnumSet;

import java.util.EnumSet;

public class EnumSetMainClass {
    
    public enum Week { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY; }
    
    public enum AllCase {
        A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,
        QW,WE,ER,RT,TY,YU,UI,IO,OP,PA,AS,SD,DF,FG,GH,HJ,JK,KL,LZ,ZX,XC,CV,VB,BN,NM,
        QWE,WER,ERT,RTY,TYU,YUI,UIO,IOP,OPA,PAS,SDF,DFG,FGH,GHJ,HJK,JKL,KLZ,LZX,ZXC,XCV,CVB,VBN,BNM;
    }
    
    public static void main(String... args) {
        EnumSet<Week> weekEnumSet = EnumSet.allOf(Week.class);
        System.out.println("☆ weekEnumSet.count: " + Week.values().length);
        System.out.println("☆ weekEnumSet.class: " + weekEnumSet.getClass());

        EnumSet<AllCase> allCaseEnumSet = EnumSet.allOf(AllCase.class);
        System.out.println("☆ allCaseEnumSet.count: " + AllCase.values().length);
        System.out.println("☆ allCaseEnumSet.class: " + allCaseEnumSet.getClass());
    }
    
    public UpperInterface test() {
//        return new LowerClass1();
        return new LowerClass2();
    }
}
