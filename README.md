1.🚀 프로젝트 개요

이커머스 프로젝트

온라인 웹 쇼핑몰 어드민(관리자) 백엔드 서버 프로젝트입니다.
상품 등록부터 카테고리 매핑, 이벤트 관리까지 멀티 스토어 이커머스 운영을 위한 핵심 기능을 제공합니다.

✨ 주요 기능

🏷 카테고리 매핑 기능 (N:N)

📦 상품 옵션 매핑 기능 (N:N)

🔐 AOP 기반 권한 관리 기능

📑 AOP 기반 로깅 기능

<br>
<br>

2.🛠 기술 스택 (Tech Stack)

언어 & 프레임워크: Java 17, Spring Boot 3.4

데이터베이스: MySQL

빌드 툴: Gradle

배포 환경: AWS EC2

<br>
<br>

3.프로젝트 구조 (Project Structure)
<br>
<br>

<img width="500" height="913" alt="image" src="https://github.com/user-attachments/assets/08e889c4-b9bf-4d64-8578-a897e1aefa30" />
<br>
<br>

5. api 문서
<img width="277" height="853" alt="image" src="https://github.com/user-attachments/assets/0344360d-f99f-4e05-bcac-094053210b3b" />
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
swagger  http://localhost:8080/swagger-ui/index.html

<br>
<br>
6.🗄 데이터베이스 구조 (Database Schema)

본 프로젝트는 store(가맹점) 테이블을 중심으로 데이터가 관리됩니다.
상품, 카테고리, 옵션, 이벤트 등은 모두 store_id를 기준으로 연계되며,
가맹점 단위의 데이터 일관성을 보장합니다.

📌 주요 테이블

store : 가맹점 기본 정보

store_product : 가맹점 상품 정보

store_product_option / store_product_option_item : 상품 옵션 및 옵션 아이템

store_product_category / store_product_category_rel : 카테고리 및 매핑 관계

store_event : 가맹점 이벤트(프로모션)

partner : 가맹점 운영자 정보

user : 서비스 이용자(소비자)

admin : 관리자 계정 정보

banner / banner_history : 배너 관리 및 이력

admin_log : 관리자 활동 로그

📊 ERD 예시
<br>
<br>
<img width="1113" height="1759" alt="image" src="https://github.com/user-attachments/assets/0b5ffb1c-a014-4944-bd1c-3fc861d6588b" />



7.프로젝트 설정
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
