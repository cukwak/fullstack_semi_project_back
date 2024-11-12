package kdt.fullstack.project.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MoiveRequestDTO {

    @NotBlank(message="title")
    private String title;
    
}
