# Singleton 패턴이란?
## 싱글톤 정의, Intend
> Singleton이란 한번에 하나의 사건이 일어난다, 하나의 패만 보여준다라는 뜻이며, SW공학, OOP에서 싱글톤은 해당 객체가 단 하나임을 보장한다는 의미를 뜻한다. 싱글톤 패턴은 이러한 싱글톤을 보장하는 패턴을 가리킨다.

![image](https://www.baeldung.com/wp-content/uploads/2023/02/singleton_design_pattern3.png)

## 왜 필요한가? Pros

객체를 생성하는 것은 비용이 드는 행위다. 기본적인 연산, 객체가 생성되는 힙 영역의 메모리, 그리고 소요 시간까지.

하지만 어플리케이션을 구성하는데 있어서 객체가 단 하나만 있어도 되는 경우는 꽤 많으며 객체가 싱글톤임을 보장한다면 위에서 말한 많은 비용을 줄일 수 있게 된다.

또한 싱글턴 객체는 전역에서 접근가능한(global) 객체이므로, 해당 객체에 상태(field)가 존재하면 이를 공유하기 매우 편해진다.


## 문제점은? Cons

하지만 동시성 문제등을 고려할때, 공유 상태를 유지(stateful)하는 설계는 바람직하지 못하다.

즉 싱글톤객체를 설계할 때는 무상태(stateless)를 지향하여 설계해야만 한다.

여기서 무상태란

- 싱글톤 객체는 특정 클라이언트에 의존적인 필드가 있으면 안된다.
- 특정 클라이언트가 값을 변경할 수 있는 필드가 있어서는 안된다.
- 가급적 읽기만 가능해야 한다.

만약 싱글톤 객체가 공유필드를 갖고있고, 이를 수정가능할경우 멀티쓰레드 환경에서 동시성 문제가 발생할 확률이 높다.

또한 일반적으로 기본 생성자를 private으로 닫아두게 되는데, 이러면 상속이 불가능해진다.

# 구현방법

### Sol.1 가장 간단한 구현 패턴

    /**
     * 기본적인 싱글턴 패턴
     */
    public class Singleton1 {
    
        private static Singleton1 singleton1Instance;
    
        private Singleton1() {
        }
    
        public static Singleton1 getInstance() {
            if(singleton1Instance == null){
                singleton1Instance = new Singleton1();
            }
            return singleton1Instance;
        }
    }

- 기본 생성자를 private으로 접근제한하고, static 팩터리 메서드 방식으로 객체 생성을 구현한다.
- 이때 객체를 static으로 클래스에 참조시켜 global한 접근을 허용하게하고, null체킹을 통해 객체 중복생성을 방지한다.

**문제점**

- 멀티쓰레드 환경에서 최초 생성 요청시 동시성 문제가 발생할 수 있다.

      public static synchronized Singleton1 getInstance() {
                if(singleton1Instance == null){
                    singleton1Instance = new Singleton1();
                }

- `synchronized` 구문 추가시 동시성문제를 해결할 수는 있지만 모든 `getInstance()` 호출마다 동기화처리를 하기때문에 성능 저하가 불가피하다.

### sol.2 즉시 초기화 싱글턴
    public class Singleton2 {
    
        private final static Singleton2 singleton1Instance;
    
        private Singleton2() {
        }
    
        public static Singleton2 getInstance() {
            return singleton1Instance;
        }
    }

- 어플리케이션이 구동되는 클래스 로드 시점에서 객체 초기화를 하는 방식
- 최초에 이미 객체를 생성하고 참조주소만 반환하기때문에, 동시성 문제에서 해방된다.

**문제점**

- 객체를 호출하는 시점이 아니라 어플리케이션이 구동되는 시점부터 객체를 생성하기 때문에, 메모리의 불필요한 낭비로 볼 수도 있다.

### sol.3 지연 초기화 - 이중검사 관용구를 사용한 싱글턴패턴

        public class Singleton3 {
        
            private static volatile Singleton3 singleton3Instance = new Singleton3();
        
            private Singleton3() {
            }
        
            public static Singleton3 getInstance() {
                if(singleton3Instance == null){
                    synchronized (Singleton3.class) {
                     if(singleton3Instance == null)
                        singleton3Instance = new Singleton3();
                    }
                }
        
                return singleton3Instance;
            }
        }

[이펙티브 자바 Item. 83에서 제시된 방법](https://github.com/jinia91/blogBackUp/blob/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EC%96%B8%EC%96%B4/JAVA/%5B%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C%20%EC%9E%90%EB%B0%94%5D%20ch.10%20%EB%8F%99%EC%8B%9C%EC%84%B1.md#item-83-%EC%A7%80%EC%97%B0%EC%B4%88%EA%B8%B0%ED%99%94%EB%8A%94-%EC%8B%A0%EC%A4%91%ED%9E%88-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B2%83)으로 지연 초기화시, null 체킹을 2번하되 2번째에만 동기화처리를 함으로써 최초 초기화 이후부터는 동기화 없는 null체킹을 통해 성능저하를 피하는 방식이다.

**문제점**

2중 null 체킹과 volatile 키워드 등 구문이 너무 복잡해지는 느낌이다.

### sol.4 static inner class를 사용한 싱글턴패턴

        public class Singleton4 {
        
            static class InstanceHolder{
                private static Singleton4 singleton3Instance = new Singleton4();
            }
        
            public static Singleton4 getInstance() {
                return InstanceHolder.singleton3Instance;
            }
        }


static inner 클래스의 경우 해당 클래스를 호출하는 시점에서 로딩이 일어나고 그때 내부 인스턴스가 static으로 초기화되기때문에, 손쉽게 지연 초기화 싱글턴을 구현할 수 있다.

### 그럼에도 문제점...

싱글턴 패턴은 싱글턴임을 보장하는 패턴임에도, 클라이언트는 크게 두가지 방법으로 싱글턴을 깨뜨릴 수 있다.

### 1. Refletion으로 private 생성자 접근하기

자바 리플렉션 api를 사용하면 private에 자유롭게 접근 가능하기 때문에 이를 통해 캡슐화된 객체에 접근하여 생성자를 강제로 호출시킬 수 있다.


### 2. 직렬화는 캡슐화를 깨뜨린다

[이펙티브 자바 Item. 89에서는](https://github.com/jinia91/blogBackUp/blob/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EC%96%B8%EC%96%B4/JAVA/%5B%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C%20%EC%9E%90%EB%B0%94%5D%20ch.10%20%EB%8F%99%EC%8B%9C%EC%84%B1.md#item-83-%EC%A7%80%EC%97%B0%EC%B4%88%EA%B8%B0%ED%99%94%EB%8A%94-%EC%8B%A0%EC%A4%91%ED%9E%88-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B2%83) 직렬화를 통해 싱글턴이 깨질수 있음을 보여준다.

물론 본 책에서는 readResolve() 메서드를 사용해 인스턴스 숫자 통제가 가능함을 알려준다.


### sol.5 Enum Type으로 싱글턴 구현

        public enum Singleton5 {
            INSTANCE5;
        }

[이펙티브 자바 Item. 89와 Item. 3 에서 제시된 방법으로 Enum을 통한 싱글턴 구현 코드다.](https://github.com/jinia91/blogBackUp/blob/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%20%EC%96%B8%EC%96%B4/JAVA/%5B%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C%20%EC%9E%90%EB%B0%94%5D%20ch.10%20%EB%8F%99%EC%8B%9C%EC%84%B1.md#item-83-%EC%A7%80%EC%97%B0%EC%B4%88%EA%B8%B0%ED%99%94%EB%8A%94-%EC%8B%A0%EC%A4%91%ED%9E%88-%EC%82%AC%EC%9A%A9%ED%95%A0%EA%B2%83)

Enum은 자바 언어 차원에서 해당 객체가 단 하나임을 보장하기 때문에, Enum을 통해 싱글턴 객체를 구현하면 Reflection을 통한 생성자 접근이나, 직렬화시 객체 재생성을 원천적으로 차단할 수 있다.

**문제점**

Enum 타입의 용도를 볼때, 과연 이 타입을 가지고 싱글턴의 클래스를 정의하는 것이 옳은 방법일지 고민해 볼 필요가 있다.

혹 구현할 필요가 있다면 팀의 컨벤션과 협의에 따라 판단하도록 하자.


### 코틀린의 경우!

코틀린에서는 object 키워드를 통해 싱글턴을 구현할 수 있다.

        object Singleton6 {
            fun getInstance() = this
        }

- sol2와 같은 즉시초기화방식이므로 메모리 사용의 단점존재
- 상속이 제한되는 점

# 싱글턴(kotlin object 포함)과 스프링 빈

특정 인스턴스를 싱글턴으로 생성하고 관리할 필요성이있을때 스프링 어플리케이션인경우 스프링 빈으로 등록하여 관리하기와 object로(싱글턴 직접구현) 만들어 관리하기 두가지 방법이 존재할것이다.

둘다 각각 장단이 존재하는데 스프링 빈으로 등록하는 경우 스프링 컨테이너가 관리하기 때문에 스프링의 기능을 사용할 수 있지만, 스프링 컨테이너에 의존적이게 된다.

또한 빈으로 관리할경우 테스트코드 작성이 용이하나, object로 직접 구현할경우 테스트코드 작성이 어려워진다.(목킹등을 하기 번거롭다)

접근과 사용의 편의성때문에 object를 실무적으로 사용하는편이긴하나, 스프링 프레임워크차원에서 더 유연하고 좋은 테스트코드 작성, 그리고 공유전역변수를 최소화하는 관점에서 bean으로 만드는게 더 바람직하지 않을까?

# 다른패턴과의 관계

- 파사드 패턴(Facade)은 일반적으로 싱글톤으로 구현되는 편이다.
- 경량 패턴(Flyweight)은 객체의 공유 상태를 관리하기 위해 싱글톤으로 구현되곤 한다. 다만 반드시 싱글턴일필요는 없으며 필요에따라 멀티턴(multiton pattern)으로도 가능하다.
- 추상 팩토리, 빌더, 프로토타입패턴등의 구현체가 싱글턴으로 구현되기도 한다.

# 실무에서 실제로 어디서 사용되는지?

- 대부분의 애플리케이션 내의 인스턴스들은 싱글턴으로 구현되는 경우가 많다. (캐시, 로거, 스레드풀, 디바이스 설정, 레지스트리 설정, DB 커넥션 풀 등)
- 전역변수를 가지고있거나 util성 클래스들은 싱글턴으로 구현되는경우가 많다.


