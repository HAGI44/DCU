package artifact.controller;

import artifact.SessionConst;
import artifact.domain.User;
import artifact.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final LoginService loginService;

    @Autowired
    public HomeController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public String login(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) User loginUser, Model model){

        //세션에 회원 데이터가 없으면 home
        if (loginUser == null) {
            return "login";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("user", loginUser);
        return "home";
    }

    @GetMapping("/home")
    public String main()
    {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginForm", new LoginForm());
        log.info("login!!");
        return "loginForm";
    }

    @PostMapping("/login")
    public String verify(@Valid LoginForm form, BindingResult bindingResult, HttpServletRequest request){

        if (bindingResult.hasErrors()){
            return "loginForm";
        }

        User loginUser = loginService.login(form.getUid(), form.getPwd());

        if (loginUser == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "loginForm";
        }

        //로그인 성공 처리

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();

        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return "redirect:/home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {

        //세션을 삭제한다.
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}