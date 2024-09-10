package com.scaler.productservicejune2024.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This class will be hosting http API's
@RestController
@RequestMapping("/say") //this is address or pointing the class
public class SampleController {
          //localhost:8080/say/hello
    @GetMapping("/hello/{name}/{name1}/{times}")  // this point the method or like flat's number point flat
    public String sayHello(@PathVariable ("name") String name , @PathVariable
            ("name1") String asd ,@PathVariable ("times") int num) {

        String Output = "";
        for (int i = 0; i < num; i++) {
            Output = Output + "Hello" + name + " " + asd  ;
        }
        return  Output;
    }

    @GetMapping("/bye")
    public String saybye(){
        return "Bye";
    }
}


/*
 http://localhost/say/hello/bye
 */