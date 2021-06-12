package serg.restjs.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serg.restjs.model.Test;
import serg.restjs.service.Act;

import java.util.HashMap;

@RestController
public class ControllerMain {

//    @GetMapping("/test")
//    public String gettest(){
//        System.out.println("Пришел");
//        //String jsonx = new Gson().toJson("Hai");
//
//        return "Hai";
//    }

    @Autowired
    Act act;

    @GetMapping("/test")
    public String gettest(@RequestParam("testD") String s){
        System.out.println("Пришел удаление");
        System.out.println(s);
        //String jsonx = new Gson().toJson("Hai");

        return "hai";
    }

    @GetMapping("/check")
    public String getCheck(@RequestParam("testD")int num,
                           @RequestParam("testM") int denum){
        System.out.println("чет пришло проверка");
        System.out.println(num);
        System.out.println(denum);



        return act.todoCheck(num, denum);
    }

    @GetMapping("/reduction")
    public HashMap<String, Object> getReduction(@RequestParam("testD")int num,
                                                @RequestParam("testM") int denum){
        System.out.println("чет пришло сокращение");
        System.out.println(num);
        System.out.println(denum);

        return act.todoReduction(num, denum);
    }


    @GetMapping("/sum")
    public HashMap<String, Object> getSum(@RequestParam("num1")int num1,
                                                @RequestParam("denum1") int denum1,
                                          @RequestParam("num2")int num2,
                                          @RequestParam("denum2") int denum2){
        System.out.println("чет пришло сумма");


        return act.todoSum(num1, denum1, num2, denum2);
    }
    //
    @GetMapping("/sub")
    public HashMap<String, Object> getSub(@RequestParam("num1")int num1,
                                          @RequestParam("denum1") int denum1,
                                          @RequestParam("num2")int num2,
                                          @RequestParam("denum2") int denum2){
        System.out.println("чет пришло разность");


        return act.todoSub(num1, denum1, num2, denum2);
    }
    //
    @GetMapping("/multiple")
    public HashMap<String, Object> getMultiple(@RequestParam("num1")int num1,
                                          @RequestParam("denum1") int denum1,
                                          @RequestParam("num2")int num2,
                                          @RequestParam("denum2") int denum2){
        System.out.println("чет пришло произведение");
        return act.todoMultiple(num1, denum1, num2, denum2);
    }
    //
    @GetMapping("/div")
    public HashMap<String, Object> getDiv(@RequestParam("num1")int num1,
                                          @RequestParam("denum1") int denum1,
                                          @RequestParam("num2")int num2,
                                          @RequestParam("denum2") int denum2){
        System.out.println("чет пришло деление");


        return act.todoDiv(num1, denum1, num2, denum2);
    }
    @PostMapping("/views/testpost")
    public String post(@RequestParam("name") String name) {
        System.out.println("Пришел post");
        System.out.println(name);

        return "пришел";
    }
}
