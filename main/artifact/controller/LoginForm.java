package artifact.controller;

import javax.validation.constraints.NotEmpty;

public class LoginForm {

    private String uid;
    private String pwd;

    @NotEmpty(message = "ID 미입력")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @NotEmpty(message = "PW 미입력")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
