package com.devisv.practice.online;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.util.Arrays;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = PracticeOnlineApplication.class,
    webEnvironment = RANDOM_PORT
)
@ContextConfiguration(initializers = AbstractDynamoDBTest.Initializer.class)
public abstract class AbstractDynamoDBTest {

  private static final int DYNAMO_PORT = 8000;

  @Autowired
  private AmazonDynamoDB db;

  @ClassRule
  public static GenericContainer dynamoDb =
      new GenericContainer("amazon/dynamodb-local:latest")
          .withExposedPorts(DYNAMO_PORT);

  /**
   * Before run all tests lets create a single tables for storage all data
   * Partition key: pk
   * Sorted key: sk
   * Primary key: pk + sk
   */
  @Before
  public void init() {
    CreateTableRequest request = new CreateTableRequest()
        .withKeySchema(
            Arrays.asList(
                new KeySchemaElement("pk", KeyType.HASH), // Partition key
                new KeySchemaElement("sk", KeyType.RANGE) // Sort key
            )
        )
        .withAttributeDefinitions(
            Arrays.asList(
                new AttributeDefinition("pk", ScalarAttributeType.S),
                new AttributeDefinition("sk", ScalarAttributeType.S)
            )
        )
        .withProvisionedThroughput(new ProvisionedThroughput(10L, 10L))
        .withTableName("practice");

    try {
      db.createTable(request);
    } catch (AmazonServiceException e) {
      throw new RuntimeException(e);
    }
  }

  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      String endpoint = String.format("amazon.end-point.url=http://%s:%s",
          dynamoDb.getContainerIpAddress(),
          dynamoDb.getMappedPort(DYNAMO_PORT));

      TestPropertyValues.of(endpoint).applyTo(configurableApplicationContext);
    }
  }
}
