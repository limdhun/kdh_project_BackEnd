로그인 시 username / password
  "username": "user1",
  "password": "1111"
# 📦 KDH Todo Backend

Spring Boot 기반의 Todo API 서버입니다.  
JWT 인증, Spring Security, JPA 기반으로 구현되었으며, 프론트엔드(React)와 REST API로 연동됩니다.

---

## ✅ 주요 기술 스택

- Java 17
- Spring Boot 3.4.4
- Spring Security
- Spring Data JPA
- Spring MVC
- Lombok
- MariaDB
- JWT (jjwt)

---

## ⚙️ 기능 요약

| 기능 | 설명 |
|------|------|
| ✅ Todo 등록/조회/수정/삭제 API | `/api/todos` |
| ✅ 사용자 로그인 API | `/api/auth/login` (JWT 발급) |
| ✅ Spring Security 필터 설정 | 커스텀 `JWTCheckFilter` 사용 |
| ✅ JWT 유효성 검사 | 토큰 파싱 및 인증 컨텍스트 설정 |
| ❌ 회원가입 | 추후 구현 예정 |
| ❌ 파일 업로드 / 이미지 | 미구현 (Nginx 연동 미사용) |

---

## 🔐 JWT 로그인 정보

```json
POST /api/auth/login
{
  "username": "user1",
  "password": "1111"
}

성공 시:
{
  "token": "Bearer eyJhbGciOi..."
}

⚠️ 개발 참고사항
DB: bootdb (user: bootdbuser, pw: bootdbuser)
application.yml로 설정 관리
CORS: localhost:5173 허용
