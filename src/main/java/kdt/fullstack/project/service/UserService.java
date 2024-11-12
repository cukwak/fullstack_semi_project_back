package kdt.fullstack.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import kdt.fullstack.project.dao.UsersMapper;
import kdt.fullstack.project.domain.DetailDTO;
import kdt.fullstack.project.domain.UserRequestDTO;
import kdt.fullstack.project.domain.UserResponseDTO;

@Service
public class UserService {
    
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private HttpSession session;

    public String login(UserRequestDTO params) {
        System.out.println("debug >>> service login "+ usersMapper);
        UserRequestDTO result = usersMapper.loginRow(params);
        System.out.println("returned data = "+result);
        if(result == null){
            throw new RuntimeException("Login failed: Invalid credentials");
        }else{
            session.setAttribute("username", result.getUsername());
        }
        return result.getUsername();

    }

    public void register(UserRequestDTO params) {
        System.out.println("debug >>> service login "+ usersMapper);
        System.out.println("debug >>> service login "+ params);
        usersMapper.registerRow(params);
    }

    public String check(UserRequestDTO params) {
        System.out.println("debug >>> service login "+ usersMapper);
        System.out.println("debug >>> service login "+ params);
        String result = usersMapper.checkRow(params);
        return result;
    }

    public void like(DetailDTO params){
        usersMapper.likeRow(params);
    }

}
