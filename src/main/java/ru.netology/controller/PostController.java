package ru.netology.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.netology.model.Post;
import ru.netology.service.PostService;

@Controller
@RequestMapping("/api/posts")
public class PostController {

	public static final String APPLICATION_JSON = "application/json";
	private final PostService service;

	public PostController(PostService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Post>> all() {
		return ResponseEntity.ok().body(service.all());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getById(@PathVariable long id) {
		return ResponseEntity.ok().body(service.getById(id));
	}

	@PostMapping
	public ResponseEntity<Post> save(Post post) {
		return ResponseEntity.ok().body(service.save(post));
	}

	@DeleteMapping("/{id}")
	public void removeById(@PathVariable long id) {
		service.removeById(id);
	}
}
