package ru.netology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
  public List<Post> all() {
    return service.all();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Post getById(@PathVariable long id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Post save(@RequestBody Post post) {
    return service.save(post);
  }

  @DeleteMapping("/{id}")
  public void removeById(long id) {
    service.removeById(id);
  }
}
