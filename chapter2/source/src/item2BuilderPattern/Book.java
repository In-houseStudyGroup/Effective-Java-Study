package item2BuilderPattern;

public class Book {
    // NOT NULL
    private final Long id;              // PK
    private final String title;         // 제목
    private final String author;        // 글쓴이
    private final Long publisher;       // 출판사 PK
    
    // NULL
    private final String content;       // 본문
    private final Long bigType;         // 대분류
    private final Long middleType;      // 중분류
    private final Long smallType;       // 소분류
    private final String isDomestic;    // 국내소설 여부
    private final Integer country;      // 출판국가 PK
    
//    private Book() { }
    
    public Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.content = builder.content;
        this.bigType = builder.bigType;
        this.middleType = builder.middleType;
        this.smallType = builder.smallType;
        this.isDomestic = builder.isDomestic;
        this.country = builder.country;
    }
    
    public void print() {
        System.out.println("☆ id: " + this.id);
        System.out.println("☆ title: " + this.title);
        System.out.println("☆ author: " + this.author);
        System.out.println("☆ publisher: " + this.publisher);
        System.out.println("☆ content: " + this.content);
        System.out.println("☆ bigType: " + this.bigType);
        System.out.println("☆ middleType: " + this.middleType);
        System.out.println("☆ smallType: " + this.smallType);
        System.out.println("☆ isDomestic: " + this.isDomestic);
        System.out.println("☆ country: " + this.country);
    }
    
    public static class Builder {
        // NOT NULL
        private final Long id;              // PK
        private final String title;         // 제목
        private final String author;        // 글쓴이
        private final Long publisher;       // 출판사 PK
        
        // NULL
        private String content;       // 본문
        private String isDomestic;    // 국내소설 여부
        private Long bigType;         // 대분류
        private Long middleType;      // 중분류
        private Long smallType;       // 소분류
        private Integer country;      // 출판국가 PK
        
        public Builder(Long id, String title, String author, Long publisher) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
        }
        
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        
        public Builder isDomestic(String isDomestic) {
            this.isDomestic = isDomestic;
            return this;
        }
        
        public Builder bigType(Long bigType) {
            this.bigType = bigType;
            return this;
        }
        
        public Builder middleType(Long middleType) {
            this.middleType = middleType;
            return this;
        }
        
        public Builder smallType(Long smallType) {
            this.smallType = smallType;
            return this;
        }
        
        public Builder country(Integer country) {
            this.country = country;
            return this;
        }
        
        public Book build() {
            return new Book(this);
        }
    }
}
