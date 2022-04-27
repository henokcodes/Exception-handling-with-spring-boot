package com.practice.Exception.Handling.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.practice.Exception.Handling.model.Customer;
import com.practice.Exception.Handling.service.CustomerService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.zh.CurrencyNames_zh_Hans_SG;
import java.time.ZonedDateTime;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping(path = "customers/")
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return this.customerService.getCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return this.customerService.getCustomer(id);
    }
    @PostMapping(value = "/add", produces = "application/json")
    public Customer addCustomer(@RequestBody Customer customer){
        return  this.customerService.addCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return this.customerService.updateCustomer(id);
    }
    @DeleteMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return this.customerService.deleteCustomer(id);
    }





//        @GetMapping(produces = "application/json", value = "healthcheck")
//        @ResponseBody
//        public ResponseEntity<Response> healthcheck(@RequestHeader( value = "format") String format) throws JSONException {
//
//            if(format.equals("short")){
//                 Response response = new Response();
//                response.setStatus("OK");
//
//
//               return new ResponseEntity<>(response, HttpStatus.OK);
//
//            }else if(format.equals("full")){
//                Response response = new Response();
//                response.setCurrentTime(Instant.now().toString());
//                response.setStatus("OK");
//  return new ResponseEntity<>(response, HttpStatus.OK);
//
//
//            }
//                return new ResponseEntity<>(
//                        HttpStatus.BAD_REQUEST);
//
//
//        }

    }

//class Response{
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String currentTime;
//    private String status;
//
//
//    public Response(){}
//    public Response(String currentTime, String status){
//        this.currentTime = currentTime;
//        this.status = status;
//    }
//
//    public String getCurrentTime(){
//        return this.currentTime;
//    }
//    public void setCurrentTime(String currentTime){
//        this.currentTime = currentTime;
//    }
//    public String getStatus(){
//        return this.status;
//    }
//    public void setStatus(String status){
//        this.status = status;
//    }


//}



