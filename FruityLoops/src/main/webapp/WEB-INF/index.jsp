package controllers;


@Controller
public class ItemController {
        
    @RequestMapping("/")
    public String index() {
        return "login_register";
    }