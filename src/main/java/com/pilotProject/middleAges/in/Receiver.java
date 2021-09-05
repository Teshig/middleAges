package com.pilotProject.middleAges.in;

import java.util.concurrent.CountDownLatch;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  @RabbitListener(queues = "globalchat")
  public void receiveMessage(Command message) {
    System.out.println("Received <" + message + ">");
    System.out.println("Received <" + message.getPersonId() + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

}
