Luồng Auth
## Luồng authen
* AuthController nhận username và password 
* CustomUserDetailService nhận user và tìm kiếm user trong db, dùng bscript so với mật khẩu của user trong db
* Khi kiểm tra thành công sẽ đến JWT để có thể trả ra token
## Luồng author
* JWTFilter dùng để kiểm tra token và chích xuất username từ token đã được gửi, sau đó load user từ db
* Sau đó sẽ kiểm tra role của người dùng, admin thì có thể xem và thêm được user
* Còn user thì bị chặn vào các url api/user/**
