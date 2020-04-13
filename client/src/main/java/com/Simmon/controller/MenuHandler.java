package com.Simmon.controller;

import com.Simmon.entity.Menu;
import com.Simmon.entity.MenuVO;
import com.Simmon.fegin.MenuFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller/*告诉前端返回试图*/
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFegin menuFegin;

    @GetMapping("/findAll")
    @ResponseBody/*不返回试图只返回数据源*/
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index=(page-1)*limit;
        return menuFegin.findAll(index,limit);
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        menuFegin.deleteById(id);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFegin.findTypes());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Menu menu){
        menuFegin.save(menu);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFegin.findById(id));
        modelAndView.addObject("list",menuFegin.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFegin.update(menu);
        return "redirect:/menu/redirect/index";
    }
}
