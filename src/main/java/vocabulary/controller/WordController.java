package vocabulary.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vocabulary.services.WordService;

@RestController
@Controller
@RequestMapping("/word")
public class WordController {
	@Autowired
	WordService wordServiceImp;
	
	@GetMapping("/{word}")
	public ResponseEntity<?> getWordDetails(@PathVariable String word) throws IOException {
		return ResponseEntity.ok(wordServiceImp.getWordDetails(word));
	}

	
}
