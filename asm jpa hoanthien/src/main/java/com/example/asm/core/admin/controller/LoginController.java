package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.request.LoginForm;
import com.example.asm.core.admin.model.request.LoginResponse;
import com.example.asm.core.admin.repository.UserRepository;
import com.example.asm.entity.User1;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;


//    @GetMapping("/secure")
//    public String securedEndpoint(Authentication authentication) {
//        // Lấy thông tin xác thực của người dùng
//        System.out.println(authentication);
//
//
//        String username = authentication.getName();
//
//        System.out.println(username);
//        // Lấy danh sách các quyền (roles) của người dùng
//        List<String> roles = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        // Xử lý logic tùy theo role của người dùng và dữ liệu JSON từ yêu cầu
//        if (roles.contains("ADMIN")) {
//            // Thực hiện các hành động cho role "ADMIN" và dữ liệu từ yourRequestObject
//            return "Hello Admin " + username ;
//        } else {
//            // Thực hiện các hành động cho role khác và dữ liệu từ yourRequestObject
//            return "Hello User1 " + username ;
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm loginForm,HttpServletRequest request){
//        User1 user = userRepository.findByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
//        System.out.println(user);
//        if (user == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//
//        System.out.println(user);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
//        System.out.println(userDetails);
//        // Lấy danh sách các quyền (roles) của người dùng từ UserDetails
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//        System.out.println(roles);
//        // Tạo đối tượng LoginResponse để trả về
//        LoginResponse loginResponse = new LoginResponse();
//        loginResponse.setUsername(user.getUsername());
//        loginResponse.setRoles(roles);
//
//        // Lưu thông tin xác thực vào phiên làm việc (HttpSession)
//        httpSession.setAttribute("userDetails", userDetails);
//        System.out.println(httpSession.getAttribute("userDetails"));
//        return ResponseEntity.ok(loginResponse);
//    }

    @GetMapping("/logout1")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Hủy bỏ phiên làm việc
        }

        // Xóa cookie (nếu có)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // Đặt thời gian sống của cookie về 0 để xóa nó
                response.addCookie(cookie); // Thêm cookie vào phản hồi để xóa cookie
            }
        }

        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/secure")
    public String securedEndpoint(HttpServletRequest request) {
        // Lấy thông tin người dùng từ session
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null) {
            UserDetails userDetails = (UserDetails) httpSession.getAttribute("userDetails");

            if (userDetails != null) {
                String username = userDetails.getUsername();
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                // Xử lý logic tùy theo role của người dùng và dữ liệu JSON từ yêu cầu
                if (roles.contains("ADMIN")) {
                    // Thực hiện các hành động cho role "ADMIN" và dữ liệu từ yourRequestObject
                    return "Hello Admin " + username ;
                } else {
                    // Thực hiện các hành động cho role khác và dữ liệu từ yourRequestObject
                    return "Hello User1 " + username ;
                }
            }
        }

        // Xử lý khi không tìm thấy thông tin người dùng trong session
        return "User1 not logged in!";
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm loginForm,HttpServletRequest request){
        System.out.println(request);
        User1 user = userRepository.findByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
        System.out.println(user);
        if (user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        System.out.println(user);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        System.out.println(userDetails);
        // Lấy danh sách các quyền (roles) của người dùng từ UserDetails
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        System.out.println(roles);
        // Tạo đối tượng LoginResponse để trả về
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        loginResponse.setRoles(roles);

        // Lưu thông tin xác thực vào phiên làm việc (HttpSession)
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("userDetails", userDetails);

        System.out.println(httpSession.getAttribute("userDetails"));
        return ResponseEntity.ok(loginResponse);
    }


}
