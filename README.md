# GlowDaysApp

***

## GlowDays 어플리케이션
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
또한 중첩된 recyclerview를 구현 하기위해 Product아이템의 특정 position으로 구분하였습니다.

***

## 요구사항 :
1.Infinity Scroll
아이템의 20번째마다 페이징 기능을 구현해야 했습니다. 페이징 방법으로 jet-pack의 paging 과 리싸이클러뷰의 OnScrollListener를 사용한 구현을 생각하였으며,
아직 jet-pack paging 라이브러리를 경험하지 못하여 기존 사용하던 방식인 OnScrollListener방식을 사용하였습니다.

2.제품 상세 페이지
확장성을 고려하여 만들기 위하여, product객체를 전달하였으며 추후에 xml에 view가 늘어나도 product의 아이템에서 
데이터를 가져올 수 있기 때문에 xml의 view와 product의 item만 연결해주면 되도록 구현하였습니다.

3.제품리스트 사이에 추천리스트 삽입
11번째, 21번째, 31번째 데이터에 수평의 RecycleView가 필요하다 판단하였습니다.
중첩된 Recyclerview를 구현 하기위해 Product아이템의 특정 position으로 구분하여 
수평과 수직 으로 구성된 제품리스트를 구현하였습니다.

4.2개의 API는 비동기로 구성
2개의 API요청데이터를 모두 받아야 하기 때문에 coroutine의 async를 사용하여 구현하였습니다.
await()를 호출하여 값을 반환하기 전에 두 async 작업이 모두 완료되도록 보장합니다.

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

