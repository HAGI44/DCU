package artifact.controller;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    @NotEmpty(message = "ID 미입력")
    private String uid;
    @NotEmpty(message = "PW 미입력")
    private String pwd;
}