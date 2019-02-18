package com.example.de.claudioaltamura.spring.cache.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.de.claudioaltamura.spring.cache.entity.Message;
import com.example.de.claudioaltamura.spring.cache.service.MessageService;

@RestController
public class MessageController {

  @Autowired
  private MessageService messageService;

  @GetMapping(value = "/messages")
  public List<Message> findAll() {
    return messageService.findAll();
  }

  @PostMapping(value = "/messages")
  public Message save(@RequestBody Message message) {
    return messageService.save(message);
  }

  @DeleteMapping("/messages/{id}")
  ResponseEntity<Message> delete(@PathVariable Long id) {

    messageService.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
