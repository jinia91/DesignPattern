# Prototype이란?
## 프로토타입 패턴 정의, Intend
![image](https://blog.kakaocdn.net/dn/bgSUMa/btqz257xbWW/DCd1Y1FefPrD1QbqPAehk1/img.gif)

> 생성할 객체를 클래스에 의존시키지 않고 기존 객체를 original로 두고 복사하여 생성 하는 패턴

## 왜 필요한가?  Pros
- 현재 존재하는 객체의 상태와 비슷한 객체가 필요한데 해당 객체 생성 비용이 많이 들때, 프로토타입 패턴이 정의되었으면 손쉽게 만들수 있다.
- 해당객체가 복사되는 경우가 많을경우 유용하다.
- 구현 클래스 타입에 대해 명확히 알지 못해도 생성 가능하다.(상위 인터페이스에서 clone()도 가능)
- 생성 클래스가 불필요하다.

## 문제점은? Cons
- 순환참조가 있는 복잡한 객체나 깊은 복사가 필요한 객체들의 복사 코드 구현이 까다로울 수 있다.

# 구현방법

## Java Clonable 인터페이스 구현

### Article(protoTpye 대상)
    public class Article implements Cloneable {
    
        private Long id;
        private String title;
        private String content;
        private Long hit;
        private List<String> list = new ArrayList<>();
    
        public Article() {
        }
    
        public Article(Long id, String title, String content, Long hit, List<String> list) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.hit = hit;
            this.list = list;
        }
    
        // clonable.clone() deep copy로 구현
        @Override
        public Article clone() {
            try {
                Article clone = (Article) super.clone();
                ArrayList<String> cloneList = new ArrayList<>(this.list);
                clone.list = cloneList;
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    
        ... 
    }

### 설명

![img.png](../img/prototype.png)

자바는 최상위 Object가 protected 접근제한자로 clone() 메서드를 가지고있다.

이 메서드를 단순히 public 으로 구현하면 `CloneNotSupportedException` 이 발생하며, clone 메서드를 구현했으며 사용 가능하다는 의미에서 Cloneable 인터페이스를 붙여줘야한다.


### Kotlin의 경우!

코틀린은 data class가 기본적인 얕은복사 clone()를 copy()로 제공하고 있다. 따라서 copy() 바로 사용가능하다.

다만 깊은 복사가 필요한경우는 직접 오버라이딩해주어야한다.

안전한 copy를 위해 데이터 클래스 정의시엔 copy를 재정의해줌이 바람직하다.

**클라이언트 코드**

        Article article = new Article();
        Article clone = article.clone();

# 다른 패턴과의 관계
- 추상 팩토리 클래스들은 팩터리 메서드들의 집합을 기반으로 하는경우가 많지만 프로토타입을 사용해 **프로토타입 레지스트리**나 추상팩토리를 만들수도 있다.
- 복잡한 방식으로 객체를 만들었을때 해당 객체의 생성과정을 다시 거칠필요가 없으므로 데코레이터, 복합체 패턴이나 커맨드패턴 재생성등에 유용하다.
- 프로토타입패턴이 메멘토 패턴의 더 간단한 대안이 될 수 있다.

# 실무에서 어떻게 사용되는지? 실제 사용된 사례

- Cloneable을 구현한 다양한 케이스

# References

- [https://refactoring.guru/design-patterns/prototype](https://refactoring.guru/design-patterns/prototype)
- [위키백과 - 프로토타입 패턴](https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85_%ED%8C%A8%ED%84%B4)
- [백기선, 코드로 학습하는 GoF의 디자인 패턴](https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard)
