package com.ouag.demo

import io.swagger.annotations.Api
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{GetMapping, RestController}


@RestController
class DemoController  {


  @Api(
    value = "sayhello"
  )
  @GetMapping(Array("/hello"))
  def sayHello(): ResponseEntity[String] ={
   ResponseEntity.ok.body("hello world")
  }

}
