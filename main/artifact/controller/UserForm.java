package artifact.controller;

import javax.validation.constraints.NotEmpty;

public class UserForm {

    private String uid;
    private String pwd;
    private String name;

    @NotEmpty(message = "회원 id는 필수입니다.")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @NotEmpty(message = "회원 비밀번호는 필수입니다.")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @NotEmpty(message = "회원 이름은 필수입니다.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
