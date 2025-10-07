<b>1. 프로젝트 개요</b>
<hr />
본 프로젝트는 지금까지 학습해온 백엔드 개발 지식을 체계적으로 정리하고, 실무 환경에 가까운 구조를 직접 설계해보기 위해 제작한 포트폴리오입니다.
이커머스 어드민 API 서버를 주제로, 설계 단계부터 배포까지 모든 과정을 혼자서 수행했습니다.
단순한 기능 구현이 아니라 객체지향적 설계, RESTful API 규칙, CI/CD 자동화 등 실무 수준의 개발 프로세스를 스스로 구축하며 학습을 체화하는 것을 목표로 했습니다.
<br>
✨ 주요 기능

🏷 카테고리 매핑 기능 (N:N)

📦 상품 옵션 매핑 기능 (N:N)

🔐 AOP 기반 권한 관리 기능

📑 AOP 기반 로깅 기능

<br>
<br>

<b>2.기술 스택 (Tech Stack)</b>
<hr />
언어 & 프레임워크: Java 17, Spring Boot 3.4

데이터베이스: MySQL

빌드 툴: Gradle

배포 환경: AWS EC2

<br>
<br>
<hr />
<b>3.프로젝트 구조 (Project Structure)</b>
<hr />

<div class="highlight highlight-text-md notranslate position-relative overflow-auto" dir="auto"><pre>
  └─📦 src/main/java/org.eppay.api
    ├─📂 aop
    ├─📂 common
    │  ├─📂 annotations
    │  ├─📂 enums
    │  ├─📂 error
    │  ├─📂 interceptor
    │  ├─📂 json
    │  ├─📂 loginAccount
    │  ├─📂 model
    │  └─📂 response
    ├─📂 config
    ├─📂 controller
    ├─📂 domain
    │  └─📂 {entityName}
    │    ├─📂 model
    │    ├─📂 repository
    │    └─📂 service
    ├─📂 filter
    ├─📂 handlers
    ├─📂 util
    ├─📂 wrapper
    └─📜 EpPayApiApplication.java</pre><div class="zeroclipboard-container"
      <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon">
    <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
</svg>
      <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none">
    <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
</svg>
    </clipboard-copy>
  </div></div>
<br>
<br>

<br>
<br>
<hr />
<b>5. api 문서</b>
<hr />
<br>
http://3.34.177.46/swagger-ui/index.html
<br>
<img width="1903" height="1701" alt="image" src="https://github.com/user-attachments/assets/2ca160ce-910d-4d06-a59f-e7c37c59bee7" />

<br>
🔐 로그인 (Auth)

사용자 로그인 및 인증 API 제공

🏬 가맹점 (Store)

가맹점 등록, 수정, 삭제, 조회 API

가맹점 이벤트 관리 API

📦 가맹점 상품 관리 (Store Products)

상품 등록, 수정, 삭제, 조회 API

상품 옵션 매핑 및 옵션 아이템 관리 API

🏷 상품 카테고리 (Categories)

상품 카테고리 등록, 수정, 삭제, 조회 API

카테고리와 상품 간 매핑 관리 API

👤 유저 정보 (User)

회원가입, 유저 조회, 계정 정지 API

회원정보 관리 API

🖼 배너 (Banner)

배너 등록, 수정, 삭제, 조회 API

웹사이트 내 광고/배너 관리 API

🔒 암호화 (Encryption)

Properties 파일 암호화 API

설정 파일 암호화 API

<br>
<br>
<hr />
<b>6.🗄 데이터베이스 구조 (Database Schema)</b>
<hr />

본 프로젝트는 store(가맹점) 테이블을 중심으로 데이터가 관리됩니다.
상품, 카테고리, 옵션, 이벤트 등은 모두 store_id를 기준으로 연계되며,
가맹점 단위의 데이터 일관성을 보장합니다.

📌 주요 테이블

store : 가맹점 기본 정보

store_product : 가맹점 상품 정보

store_product_option / store_product_option_item / store_product_option_rel : 상품 옵션 및 옵션 아이템 및 상품 옵션 매핑 관계 

store_product_category / store_product_category_rel : 카테고리 및 매핑 관계

store_event : 가맹점 이벤트(프로모션)

partner : 가맹점 운영자 정보

user : 서비스 이용자(소비자)

admin : 관리자 계정 정보

banner / banner_history : 배너 관리 및 이력

admin_log : 관리자 활동 로그


<hr />
<b>7.프로젝트 설정<b>
<hr />
<br>
<br>
<img width="634" height="559" alt="image" src="https://github.com/user-attachments/assets/746e77df-c5bc-4e96-9a97-796e5a60a1e3" />
<br>
<br>
-Dspring.profiles.active :  prod 운영계 설정 , dev 개발계 설정
<br>
<br>
-Djasypt.encryptor.password : 암호화 키 properties 복호화를 위한 대칭키 구조
<br>
<br>

<hr />
<b>8. 배포 ( CI/CD )</b>
<hr />
<br>
<br>
<img width="1907" height="403" alt="image" src="https://github.com/user-attachments/assets/8f6b8d74-2b1d-4f8b-8a2b-25558e617116" />

<br>
<br>
<img width="1104" height="691" alt="image" src="https://github.com/user-attachments/assets/64fcc493-f35d-493b-8e67-d523aadb1c4d" />


