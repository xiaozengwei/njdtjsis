package com.gx.soft.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Controller
@RequestMapping("tz")
public class GxSysTzController {
    @RequestMapping("user-tz-page")
    public String userManagerPage1(Model model) {
        return "sys/tz/user-tz-manager";
    }
}
