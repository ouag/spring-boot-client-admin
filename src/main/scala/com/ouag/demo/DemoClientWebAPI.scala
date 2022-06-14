package com.ouag.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class DemoClientWebAPI {

}


object DemoClientWebAPI{
  def main(args: Array[String]) : Unit = SpringApplication.run(classOf[DemoClientWebAPI], args :_ *)
}