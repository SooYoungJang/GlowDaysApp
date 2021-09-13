# GlowDaysApp

***

## Naver에 있는 영화리스트 애플리케이션
***

## 구성 :
### Language : Kotlin
### DI : Hilt
### AAC(Clean, MVVM, DataBinding, LiveData, ViewModel, Navigation)
### Opensource: Retrofit,okHttp3 Glide
### asynchronous processing : coroutines

***
## 소개 :
과제에서 주어진 요구사항을 통해 API통신을 비동기로 처리하여야 함을 알았습니다.
확인한 사항을 처리하기 위해 coroutine의 async를 사용하였으며,
추후에 로컬DB를 사용할 수 있을 것이라 생각하여 RepositoryPattern을 이용하여 서버에서 데이터를 가져오고 있지만 추후에 Repository의 변경 및 추가만으로 로컬DB를 관리 할 수 있습니다.


***
## DI(Hilt):
의존성 주입 Framework를 이용하여 의존성을 주입할 객체의 생명주기 관리가 쉬워집니다.
주입한 의존성의 변경이 주입된 객체에게 영향을 주지 않는 설계가 가능해집니다.

***
## AAC Clean,MVVM:
Jetpack AAC와 함께 사용하기에 적합한 Architecture

layer를 나눠서 각 계층이 가진 역할을 명확하게 합니다.
layer의 계층별 역할을 명확하게 하는 것은 통일성 있는 코드를 만들 수 있습니다.
Activity, Fragment내부의 메소드명을 화면에서 이루어지는 행위 위주의 메소드명으로 짠다면 layer를 더 명확하게 나눌 수 있습니다.
jetpack의 AAC에 포함된 library들이 MVVM Architecture에서 효과적으로 활용됩니다.


***
## 추가 고려사항

확장성을 위한 고려사항
: Domain layer model과 Data layer model을 각각 만들어 사용하였습니다.
각 모델을 도메인 모델만으로 사용할 수 있지만, 객체의 역할과 책임이 다르기 때문에 새롭게 만들어 사용하였습니다.
이를 통해 외부에서 내려주는 데이터의 모양이 변경되어도 mapper만으로 다른 객체들의 변화를 막을 수 있습니다.
또 Entity를 직접 화면에 출력하기 위한 모델로 사용하지 않아 표현하려는 객체의 모양이 변화하여도 서버 데이터의 변경점이 없습니다.

