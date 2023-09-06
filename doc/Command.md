# Command Pattern?
> 커맨드패턴은 정보 전문가(`information expert`) 객체에게 요청을 맡기는 패턴으로 디자인 패턴중 행위 패턴에 해당한다.

![첨부 이미지](https://www.d.umn.edu/~gshute/cs5741/patterns/command.gif)

- Command 패턴에서 중요한 책임을 가진 객체들은 총 4개로 `Invoker`, `Receiver`, `Client`, 그리고 `Command`가 있다.
- `Client` 는 `Context`와 결합되어, 객체들을 생성하거나 오케스트레이션하여 진행하는 역할을 한다.
- `Command`는 요청을 캡슐화하고 요청을 실행할 `Reciever`를 알고 있으며, 요청을 하는 역할을 한다.
- `Invoker`는 추상화된 `Command`를 주입받을수 있고, 이를 실행하는 일을 하며, `Template Method` 패턴으로서 다른 부수적인 책임을 수행하기도 한다
- `Reciver` 는 실질적으로 요청을 실행하는 일을 한다.


## 왜 필요한가? Pros
- 단순히 `Client`와 `Server`의 역할에서 벗어나 보다 구체적인 책임을 할당함에 따라, `SRP`를 준수하게된다.
- 책임에 따라 작게 분할된 객체들은 `OCP`를 준수하기 더 쉬워진다
- `Invoker`의 패턴에 따라 부수적인 다양한 기능을 구현하기 수월하다.
    - `Undo, Logging` 등
- 기존의 요청들을 조합하는 복잡한 요청이 새로 생겨도, 여러 `Command`를 조합하여 구현 가능하다.


## 문제점은? Cons

- 단순히 `Server`와 `Client`가 존재하는것에 비해 여러 계층이 추가되므로 코드가 복잡해진다.

# 구현 코드

## Ver 1. Before

### Controller(client)

    public class Controller {
        private final Service1 service1;
    
        public Controller(Service1 service1) {
            this.service1 = service1;
        }
    
        public void doService(){
            service1.doIt();
        }
    }

### Services(Server)
    public class Service1 {
        public void doIt() {
            System.out.println("do it! Service1");
        }
    }
    
    public class Service2 {
        public void doIt() {
            System.out.println("do it! Service2");
        }
    }

### 설명

간단한 `Client(Controller)` - `Server(service)` 구조의 수도코드를 통해 `Command` 패턴을 구현해보자.


## Ver 2. Command 패턴으로

### Controller(`client`)

    public class Controller {
    final CommandExecutor commandExecutor = new CommandExecutor();
    final Service1 service1 = new Service1();
    final Service2 service2 = new Service2();

    public void startService1(){
        commandExecutor.execute(new Service1StartCommand(service1));
    }

    public void endService1(){
        commandExecutor.execute(new Service1EndCommand(service1));
    }

    public void startService2(){
        commandExecutor.execute(new Service2StartCommand(service2));
    }

    public void endService2(){
        commandExecutor.execute(new Service2EndCommand(service2));
    }

    public void cancelLastService(){
        commandExecutor.revert();
    }
    }


### ServiceCommand와 구현체

#### ServiceCommand 인터페이스

    public interface ServiceCommand {
        void doService();
        void unDoService();
    }

#### Service 구현체(`Reciever`)


    public class Service1 {
        public void start() {
            System.out.println("Service1 start!");
        }
        public void end() {
            System.out.println("Service1 end!");
        }
    }

#### Command


    public class Service1EndCommand implements ServiceCommand {
        private final Service1 service1;
    
        public Service1EndCommand(Service1 service1) {
            this.service1 = service1;
        }
    
        @Override
        public void doService() {
            service1.end();
        }
    
        @Override
        public void unDoService() {
            new Service1StartCommand(this.service1).doService();
        }
    }

    
    public class Service1StartCommand implements ServiceCommand {
            private final Service1 service1;
    
        public Service1StartCommand(Service1 service1) {
            this.service1 = service1;
        }
    
    
        @Override
        public void doService() {
            service1.start();
        }
    
        @Override
        public void unDoService() {
            new Service1EndCommand(this.service1).doService();
        }
    }

### CommandExecutor (invoker)

    public class CommandExecutor {
    private final Stack<ServiceCommand> commandsHistory = new Stack<>();

    public void execute(ServiceCommand command){
        commandsHistory.push(command);
        command.doService();
    }

    public void revert(){
        ServiceCommand revertCommand = commandsHistory.pop();
        revertCommand.unDoService();
    }
    }

### 설명

기존 단순한 Client(Controller) - Server(Service) 구조에서 `Command` 패턴을 적용해보았다.

위는 간단한 예시지만 엔터프라이즈 애플리케이션에서도 일반적으로 사용되는 FACADE 패턴이 아니라 command 패턴으로 서비스 레이어를 구현하고 작업을 객체화시켜볼수도 있다.

작업을 되돌리거나 예약하거나 직렬화를 통해 로깅 및 관리하기 유용하기 때문에, 이벤트 드리븐 아키텍처에서 사가패턴을 적용할때 유즈케이스를 커맨드화 시켜 관리하는 방식도 고려해볼만 하다.


# 다른 패턴과의 관계
- 책임연쇄패턴, 커맨드패턴, 중재자패턴, 옵저버 패턴은 모두 요청에 대한 수신자와 송신자간 다양한 결합에 대한 패턴들이다.
    - 책임연쇄패턴은 동적으로 연결된 체인에 요청을 순차적으로 전달하는 패턴이다.
    - 커맨드 패턴은 수신자와 송신자를 오직 단방향으로만 연결하는 패턴이다.
    - 중재자 패턴은 송신자와 수신자간 방향성을 제거하고 중재자 객체가 그 사이에서 소통을 관장한다.
    - 옵저버 패턴은 수신자가 동적으로 구독/구독해제를 통해 메시지 수신을 결정할 수 있게한다.

- 커맨드 패턴과 메멘토 패턴을 사용하여 `Undo` 기능을 구현할 수 있다.

- 커맨드 패턴과 전략 패턴은 구조적으로 매우 유사하지만, 의도가 다르다.
    - 전략패턴은 하나의 `Context`안에 다른 알고리즘이 필요할때 사용하는 패턴이지만, 커맨드 패턴은 기본적으로 요청을 객체화시켜 다루며, 여러 요청들을 큐나 스택 구조에 기록하거나 다루는데 특화되있다.

# References
- [https://refactoring.guru/design-patterns/command](https://refactoring.guru/design-patterns/command)
- [백기선, 코드로 학습하는 GoF의 디자인 패턴](https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard)
- [Service Layer Design
  “Facade Vs. Command”](https://cs.uwaterloo.ca/~a78khan/cs446/lectures/2011_06-jun_10_ServiceLayer.pdf)