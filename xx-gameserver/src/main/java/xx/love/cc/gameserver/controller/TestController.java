package xx.love.cc.gameserver.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author xhy
 * @Date 2024/3/2
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {

        return "success";
    }
}
