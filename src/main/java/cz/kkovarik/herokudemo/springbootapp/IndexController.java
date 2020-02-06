package cz.kkovarik.herokudemo.springbootapp;

import cz.kkovarik.herokudemo.springbootapp.counter.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Karel Kovarik
 */
@Controller
public class IndexController {

    @Value("${java.version}")
    private String javaRuntimeVersion;
    @Value("${index.message}")
    private String message;

    @Autowired
    private Counter counter;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("counter", counter.get());
        model.addAttribute("javaVersion", javaRuntimeVersion);
        return "index";
    }
}
