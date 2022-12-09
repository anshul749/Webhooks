package com.webhooks.controller;

import com.webhooks.service.DepartmentServiceImpl;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.webhooks.dto.*;
import java.io.IOException;

@RestController
public class webHookController {

//    @Autowired
//    private DepartmentService departmentService;

    @GetMapping("/hello")
    public String hi() {
        return DepartmentServiceImpl.hello();
    }

    @GetMapping("/reqres")
    public String api() throws IOException {

        HttpGet get= new HttpGet("");
        get.setHeader("Content-Type","application/json");
       // get.setHeader("Authorization", "Bearer " + finalToken)

        JSONObject json = DepartmentServiceImpl.readJsonFromUrl("https://api.cimediacloud.com/assets/554c3cdc348e4ff7a0a03ac6c1f7bbec");
//        HttpPost post = new HttpPost("http://res-api");
//        post.setHeader("Content-Type","application/json");
//        post.setHeader("Authorization", "Bearer " + finalToken)


       // System.out.println(json);
         return json.toString();
        //System.out.println(json.get("id"));
    }

    @PostMapping("/assetprocessedfinished")
    public void getapi(@RequestBody sonyCiAssetsProcessingFinished sonyCiAssetsProcessingFinished)
    {
        System.out.println(sonyCiAssetsProcessingFinished.toString());

    }



}
