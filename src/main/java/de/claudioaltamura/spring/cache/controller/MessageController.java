package de.claudioaltamura.spring.cache.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import de.claudioaltamura.spring.cache.entity.Message;
import de.claudioaltamura.spring.cache.service.MessageService;

@RestController
public class MessageController {

  private static Logger log = LoggerFactory.getLogger(MessageController.class);
  
  @Autowired
  private MessageService messageService;

  @GetMapping(value = "/messages")
  public List<Message> findAll() {
    log.info("findAll");
    return messageService.findAll();
  }

  @PostMapping(value = "/messages")
  public Message save(@RequestBody Message message) {
    Message savedMessage= messageService.save(message);
    log.info("save " + savedMessage.getId() );
    return savedMessage;
  }

  @DeleteMapping("/messages/{id}")
  ResponseEntity<Message> delete(@PathVariable Long id) {
    log.info("delete " + id);
    messageService.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
