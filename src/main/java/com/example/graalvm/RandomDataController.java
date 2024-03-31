package com.example.graalvm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/random-data")
@RequiredArgsConstructor
@Slf4j
public class RandomDataController {
	
	@GetMapping("/alphabetic")
	public String getRandomAlphabetic() {
		return RandomStringUtils.randomAlphabetic(10);
	}
	
	@GetMapping("/numeric")
	public String getRandomNumeric() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	@GetMapping("/alphanumeric")
	public String getRandomAlphanumeric() {
		return RandomStringUtils.randomAlphanumeric(10);
	}
	
	@GetMapping("/echo/{word}")
	public String echo(@PathVariable String word) {
		return word;
	}
	
	@PostMapping("/echo")
	public String create(@RequestBody String body) {
		return body;
	}
	
	@PutMapping("/echo/{word}")
	public String update(@PathVariable String word, @RequestBody String body) {
		return MessageFormat.format("{0} -> {1}", word, body);
	}
	
	@DeleteMapping("/echo/{word}")
	public String delete(@PathVariable String word) {
		return MessageFormat.format("Deleted: `{0}`", word);
	}
}
