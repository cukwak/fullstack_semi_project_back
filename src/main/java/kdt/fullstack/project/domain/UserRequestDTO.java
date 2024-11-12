package kdt.fullstack.project.domain;

import lombok.Data;

@Data
public class UserRequestDTO {
    
    private String id;
    
    private String password;

    private String username;

    private String code;
}
