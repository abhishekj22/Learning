package com.ap.BasicProject.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    //URI Versioning - used by Twitter

    @GetMapping("v1/getPerson")
    public PersonV1 getPersonV1(){
        return new PersonV1("Abhishek Jagtap");
    }

    @GetMapping("v2/getPerson")
    public PersonV2 getPersonV2(){
        return new PersonV2("Abhishek", "Jagtap");
    }

    //(Request) Parameter versioning - used by Amazon

    @GetMapping(value = "/getPerson", params = "version=1")
    public PersonV1 getPersonParam1(){
        return new PersonV1("Abhishek Jagtap");
    }

    @GetMapping(value = "/getPerson", params = "version=2")
    public PersonV2 getPersonParam2(){
        return new PersonV2("Abhishek", "Jagtap");
    }

    //In below approaches Caching become difficult because of request is same and header changes are there
    //Header versioning - used by Microsoft

    @GetMapping(value = "/getPerson", headers = "X-APP_MAPPING=1")
    public PersonV1 getPersonHeader1(){
        return new PersonV1("Abhishek Jagtap");
    }

    @GetMapping(value = "/getPerson", headers = "X-APP_MAPPING=2")
    public PersonV2 getPersonHeader2(){
        return new PersonV2("Abhishek", "Jagtap");
    }

    //Media Type versioning (content negotiation or Accept Header or Mime type) - used by Github

    @GetMapping(value = "/getPerson", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonProduces1(){
        return new PersonV1("Abhishek Jagtap");
    }

    @GetMapping(value = "/getPerson", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonProduces2(){
        return new PersonV2("Abhishek", "Jagtap");
    }
}
