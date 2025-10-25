# java-racingcar-precourse
## 요구사항 정리

### 기능 요구 사항

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


### 프로그래밍 요구사항

- [ ] 프로그래밍 시작점은 `Application`의 `main`이다.
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 라이브러리

- [ ] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- [ ] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---
## 구현할 기능 목록 📋
### 🧪 테스트 코드
- [X] `CarTest` : 자동차 이름 검증, 이동 조건 검증 (랜덤 주입 시 전진 여부 테스트)
- [X] `CarsTest` : 우승자 계산 로직 테스트
- [X] `RacingGameTest` : 한 턴 이동 및 누적 이동, 우승자 판별 로직 테스트
- [ ] `RacingServiceTest` : 전체 게임 로직 시뮬레이션 테스트
- [X] `InputValidatorTest` : 문자열/숫자 입력 검증 테스트
- [ ] `InputViewTest` : 입력 문자열 파싱, 검증 로직 예외 확인
- [ ] `OutputviewTest` : 출력 포맷(라운드, 우승자, 에러 메시지) 검증 테스트
- [ ] `RacingValidatorTest` : 중복 이름 및 시도 횟수 검증 테스트

---

### 🚗 Car (`domain.Car`)
- [X] 자동차는 이름(`name`)과 현재 위치(`position`)를 가진다.
- [X] 자동차 이름은 1자 이상, 5자 이하만 가능하다.
    - 이름이 공백이거나 5자를 초과할 경우 `IllegalArgumentException` 발생
- [X] 무작위 값이 4 이상일 때 1칸 전진한다.
- [X] 이동 결과(거리)는 누적된다.
- [X] 자신의 이름과 이동 거리를 출력 형식(`name : ---`)에 맞게 반환할 수 있다.

---

### 🚘 Cars (`domain.Cars`)
- [X] 여러 자동차(`Car`) 객체를 관리한다.
- [X] 자동차 이름 목록을 받아 내부에서 `Car` 객체들을 생성한다.
- [X] 모든 자동차의 현재 상태를 반환한다.
- [X] 가장 멀리 이동한 거리를 계산한다.
- [X] 가장 멀리 이동한 자동차(들)을 우승자로 반환한다.

---

### 🎮 RacingGame (`domain.RacingGame`)
- [X] `Cars` 컬렉션을 보유한다.
- [X] 한 번의 경주(`playOnce`)를 수행한다.
    - 각 자동차마다 난수(0~9)를 생성하고 이동 조건(4 이상)을 적용한다.
- [X] 전체 경주 결과(시도 횟수만큼 반복)를 관리한다.
- [X] 게임 종료 후 우승자를 계산해 반환한다.

---

### ⚙️ RacingService (`service.RacingService`)
- [ ] 입력받은 자동차 이름으로 경주를 초기화한다.
- [ ] 주어진 시도 횟수만큼 경주를 반복 수행한다.
- [ ] 매 턴마다 자동차 이동을 수행하고, 이동 결과를 출력할 수 있도록 데이터를 전달한다.
- [ ] 경주 종료 후 우승자를 계산해 반환한다.

---

### 🧩 RacingValidator (`service.RacingValidator`)
- [ ] 시도 횟수가 1 이상인지 검증한다.
- [ ] 자동차 이름 목록이 비어 있지 않은지 검증한다.
- [ ] 자동차 이름 중복 여부를 검증한다.
- [ ] 중복된 이름이 있을 경우 `IllegalArgumentException` 발생시킨다.

---

### 💬 InputView (`view.InputView`)
- [ ] 사용자에게 **자동차 이름 목록**을 입력받는다.
    - 쉼표(,) 기준으로 구분된 문자열
    - [검증] 비어 있으면 예외 발생 (`InputValidator.validateNotEmpty`)
- [ ] 사용자에게 **시도 횟수**를 입력받는다.
    - [검증] 숫자가 아니면 예외 발생 (`InputValidator.validateNumeric`)
- [ ] 모든 입력은 `camp.nextstep.edu.missionutils.Console.readLine()` 사용

---

### 📢 OutputView (`view.OutputView`)
- [ ] 각 시도별 실행 결과를 출력한다.  
- [ ] 모든 경주가 끝난 후, 우승자(들)를 쉼표(,)로 구분하여 출력한다.
- [ ] 출력 형식은 요구사항과 정확히 일치해야 한다.

### 🧰 InputValidator (`utils.InputValidator`)
- [ ] 입력이 비어 있는지(`null`, `blank`) 검증한다.
- [ ] 입력이 숫자로만 이루어졌는지 검증한다.
- [ ] 유효하지 않은 입력일 경우 `IllegalArgumentException` 발생시킨다.

---

### 🚀 RacingController (`controller.RacingController`)
- [ ] 프로그램의 전체 실행 흐름을 제어한다.
- 자동차 이름 입력 → 시도 횟수 입력 → 게임 실행 → 결과 출력
- [ ] View에서 입력받은 데이터를 Service에 전달한다.
- [ ] Service로부터 받은 결과를 View로 전달하여 출력한다.
- [ ] 예외 발생 시 프로그램이 종료되며 메시지를 출력한다.
- `System.exit()` 호출 금지
- [ ] Controller는 비즈니스 로직을 직접 수행하지 않는다.

---

### 🏁 Application (`Application.java`)
- [ ] 프로그램 실행의 진입점 (`main` 메서드)
- [ ] `InputView`, `OutputView`, `RacingController`를 생성하여 실행한다.

---
## 디렉터리 구조 🗂️
```
racingcar/
├── Application.java                 # 프로그램 시작점 (main)
│
├── controller/
│     └── RacingController.java      # 전체 흐름 제어 (입력 → 서비스 → 출력)
│
├── service/
│     ├── RacingService.java         # 경주 비즈니스 로직 수행
│     └── RacingValidator.java       # 복합 검증 (이름 중복, 시도 횟수 등)
│
├── domain/
│     ├── Car.java                   # 자동차 객체 (이름, 위치, 이동 로직)
│     ├── Cars.java                  # 자동차 컬렉션 관리, 우승자 계산
│     └── RacingGame.java            # 전체 경주 관리 (턴별 이동 실행)
│
├── view/
│     ├── InputView.java             # 사용자 입력 처리
│     └── OutputView.java            # 실행 결과 출력
│
└── utils/
└── InputValidator.java        # 단순 입력값 검증 (빈 입력, 숫자 판별 등)
```

📁 디렉터리 설명
- **controller** : 사용자 입력부터 출력까지의 전체 흐름 제어
- **service** : 비즈니스 로직 처리, 도메인 간 협력 및 검증
- **domain** : 핵심 도메인 로직 (Car, Cars, RacingGame)
- **view** : 사용자와의 입출력 담당 (Console 기반)
- **utils** : 공통 유틸리티, 단순 형식 검증 등
- **Application.java** : 프로그램의 시작점
