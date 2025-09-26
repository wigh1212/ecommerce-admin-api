1. 프로젝트 개요

이커머스 프로젝트 / 온라인 웹 쇼핑몰 어드민 프로젝트

온라인 쇼핑몰의 상품 등록 및 홍보 어드민 백엔드 프로젝트 입니다.

주요기능 

 -카테고리 매핑 기능 N:N 

 -상품 옵션 매핑 기능 N:N

 -AOP 권한 관리 기능 

 -AOP 로깅 기능
<br>
<br>


2.기술 스택 (Tech Stack)

언어/프레임워크: Java 17, Spring Boot 3.4

데이터베이스: MySQL

빌드 툴: Gradle

배포: AWS EC2

<br>
<br>

3. 프로젝트 구조 (Project Structure)
<img width="500" height="913" alt="image" src="https://github.com/user-attachments/assets/08e889c4-b9bf-4d64-8578-a897e1aefa30" />
<br>
<br>

5. api 문서
<img width="277" height="853" alt="image" src="https://github.com/user-attachments/assets/0344360d-f99f-4e05-bcac-094053210b3b" />
<br>
1.로그인 (Auth)

사용자 로그인 및 인증 관련 API

2.가맹점 (Store)

가맹점 등록, 수정, 삭제 및 조회 API

가맹점 이벤트 관리 API

3.가맹점 상품 관리 (Store Products)

상품 등록, 수정, 삭제, 조회 API

상품 옵션 매핑 및 옵션 아이템 관리 API

4.상품 카테고리 (Categories)

상품 카테고리 등록, 수정, 삭제, 조회 API

카테고리와 상품 간 매핑 관리 API

5.유저정보

회원가입 유저 조회,정지 API

회원정보 관리 API

6.배너

배너 등록,수정,삭제,조회 API

웹 사이트내에 배너(광고) 관리 API

7.암호화

properties 암호화 API

설정 파일 암호화 API

<br>

swagger  http://localhost:8080/swagger-ui/index.html

<br>
<br>
6. 데이터베이스 구조 (DB Schema)

<img width="1113" height="1759" alt="image" src="https://github.com/user-attachments/assets/0b5ffb1c-a014-4944-bd1c-3fc861d6588b" />

<img width="535" height="293" alt="image" src="https://github.com/user-attachments/assets/e9376786-00fd-43a0-9dc1-352cb77272aa" />

store에 중점을 두고 있습니다.

연관관계가 있는 경우는 가맹점 관리라는 이름 아래에 관리가 되도록 테이블명 , FK 규칙을 정하고 작업중입니다.
