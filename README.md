# Auth Flow
## Authen flow
1. AuthController nhận username và password
2. AuthController gọi AuthenticationManager để xác thực
3. CustomUserDetailService load user từ db
4. Mật khẩu được so sánh bằng bscrypt
5. Xác thực thành công sinh ra token
## Author flow
1. JWTFilter dùng để kiểm tra token và trích xuất username từ token đã được gửi và load user từ db
2. Spring Security kiểm tra quyền truy cập dựa trên role
   * ADMIN thì được truy cập 
   * USER bị chặn truy cập 
