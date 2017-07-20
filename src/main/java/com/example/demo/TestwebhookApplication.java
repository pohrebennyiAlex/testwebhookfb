package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class TestwebhookApplication {

	private List<Object> mapList = new ArrayList<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	String home() {
		return "Hello World and kek!";
	}

	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	@ResponseBody
	List<Object> homerequests() {
		return mapList;
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.GET)
	@ResponseBody
	String webHookEndPoint(Object request){
		mapList.add(request);
		/*String s = request.get("hub.challenge");
		return s;*/
		return "hi";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestwebhookApplication.class, args);
	}
}
