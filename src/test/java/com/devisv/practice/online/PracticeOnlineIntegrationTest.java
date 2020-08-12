package com.devisv.practice.online;

import com.devisv.practice.online.model.Level;
import com.devisv.practice.online.model.Practice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.Assert.assertEquals;

public class PracticeOnlineIntegrationTest extends AbstractDynamoDBTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void test() {
    Practice practice = new Practice();
    practice.setPrimaryKey("test");
    practice.setSortedKey(Level.C1_C2.toString());

    Practice practiceCreated = restTemplate.postForObject("/practice", practice, Practice.class);

    assertEquals(practiceCreated.getPrimaryKey(), practice.getPrimaryKey());
    assertEquals(practiceCreated.getSortedKey(), practice.getSortedKey());
  }
}
