package com.example.de.claudioaltamura.spring.cache.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.de.claudioaltamura.spring.cache.entity.Message;

@Service
@CacheConfig(cacheNames = {"messages"})
public class MessageService {

  private Map<Long, Message> messages = new HashMap<>();
  private AtomicLong idx = new AtomicLong(0);

  @PostConstruct
  private void fillMessages() {
    Message message1 = new Message();
    message1.setId(1L);
    message1.setMessage("Hallo");
    messages.put(idx.incrementAndGet(),message1);

    Message message2 = new Message();
    message2.setId(2L);
    message2.setMessage("Hello");
    messages.put(idx.incrementAndGet() ,message2);
  }

  @Cacheable
  public List<Message> findAll() {
    this.slowService();

    return this.messages.values().stream().collect(Collectors.toList());
  }

  @CachePut
  public Message save(Message message) {
    message.setId(idx.incrementAndGet());
    this.messages.put(message.getId(), message);

    return message;
  }

  private void slowService() {
    try {
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @CacheEvict(key = "#message.id")
  public void deleteById(Long id) {
    this.messages.remove(id);
  }
}
