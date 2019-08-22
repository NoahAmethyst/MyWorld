package controller;

import model.Stu;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DemoServiceI;

import java.util.List;

@Controller
public class DemoController  {
    @Autowired
    private DemoServiceI demoService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Stu> getAll(){
        return demoService.getAll();
    }

    @RequestMapping("/getById")
    @ResponseBody
    public List<User> getById(){
        return demoService.getById(2);
    }

}
