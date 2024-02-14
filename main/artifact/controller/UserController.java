package artifact.controller;

import artifact.domain.User;
import artifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String createForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String create(@Valid UserForm form, BindingResult result){

        if (result.hasErrors()){
            return "users/createUserForm";
        }

        User user = new User();
        user.setUid(form.getUid());
        user.setPwd(form.getPwd());
        user.setName(form.getName());
        userService.join(user);
        return "redirect:/";
    }
}
