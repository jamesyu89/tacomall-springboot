package cn.tacomall.tacomallspringbootproviderstorage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/storage/view/")
public class View {

    @RequestMapping("upload")
    public ModelAndView index(Model model) {
        model.addAttribute("title", "Storage上传测试页面");
        return new ModelAndView("views/index", "view", model);
    }
}
