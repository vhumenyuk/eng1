package eng.controller;

import eng.dto.UserDTO;
import eng.entity.*;
import eng.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CabinetController {
    private final UserService userService;

    public CabinetController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cabinet")
    public ModelAndView getCabinetPage(ModelAndView modelAndView, Principal principal){
        modelAndView.setViewName("cabinet");
        String email = principal.getName();
        UserDTO userDTO = userService.findByEmail(email);
        User user = userService.findUserByEmail(email);
        modelAndView.getModelMap().addAttribute("user", userDTO);
        return modelAndView;
    }
}
