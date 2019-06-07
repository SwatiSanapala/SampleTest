package com.example.dbtest.api;
	
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
	
	@RestController
	@RequestMapping("/api/")
	
	public class Test {
		
		@CrossOrigin(origins="*") //function level sets the Cors
		@GetMapping ("test")
		public HashMap <String, String> test() {
			HashMap <String, String> msg= new HashMap <String, String>();
			msg.put("greet", "Hello");
			
			return msg;
		}
		
		
	}
