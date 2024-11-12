package kdt.fullstack.project.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kdt.fullstack.project.domain.UserRequestDTO;
import kdt.fullstack.project.domain.DetailDTO;
import kdt.fullstack.project.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersCtrl {
 
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO params) {
        System.out.println(params);
        String username = userService.login(params);
        System.out.println("username = " + username );

        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRequestDTO params) {
        System.out.println("ewqewqewqewqewqeqwewqewq +++ = "+ params);
        if(userService.check(params) != null){
            userService.register(params);
        }else{
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    
}
