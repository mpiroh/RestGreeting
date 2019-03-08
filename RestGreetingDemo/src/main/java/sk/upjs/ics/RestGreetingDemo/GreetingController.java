package sk.upjs.ics.RestGreetingDemo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private AtomicLong idGenerator = new AtomicLong();
	
	@GetMapping
	public Greeting getGreeting(@RequestParam(value="name", defaultValue="") String name) {
		return new Greeting(idGenerator.getAndIncrement(), "Hello " + name);
	}
}
