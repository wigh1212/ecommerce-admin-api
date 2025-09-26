1. 프로젝트 개요

이커머스 프로젝트 / 온라인 웹 쇼핑몰 어드민 프로젝트

온라인 쇼핑몰의 상품 등록 및 홍보 어드민 백엔드 프로젝트 입니다.

1) 카테고리 매핑 기능 N:N 

2) 상품 옵션 매핑 기능 N:N

3) AOP 권한 관리 기능 ( store )


2. 기술 스택 (Tech Stack)

언어/프레임워크: Java 17, Spring Boot 3.4

데이터베이스: MySQL

빌드 툴: Gradle

배포: AWS EC2


3. 프로젝트 구조 (Project Structure)
<img width="500" height="913" alt="image" src="https://github.com/user-attachments/assets/08e889c4-b9bf-4d64-8578-a897e1aefa30" />


5. api 문서
<img width="277" height="853" alt="image" src="https://github.com/user-attachments/assets/0344360d-f99f-4e05-bcac-094053210b3b" />
협업의 직관성을 위해 post맨으로 정리해두고 있습니다.
swagger  http://localhost:8080/swagger-ui/index.html


6. 데이터베이스 구조 (DB Schema)
<img width="1113" height="1759" alt="image" src="https://github.com/user-attachments/assets/0b5ffb1c-a014-4944-bd1c-3fc861d6588b" />

<img width="535" height="293" alt="image" src="https://github.com/user-attachments/assets/e9376786-00fd-43a0-9dc1-352cb77272aa" />

store에 중점을 두고 있습니다.
연관관계가 있는 경우는 가맹점 관리라는 이름 아래에 관리가 되도록 테이블명 , FK 규칙을 정하고 작업중입니다.
