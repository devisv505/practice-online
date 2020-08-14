package com.devisv.practice.online;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.devisv.practice.online.core.model.OnlinePractice;
import com.devisv.practice.online.model.Practice;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDynamoDBTest.class);

  private static final int DYNAMO_PORT = 8000;

  @Autowired
  private AmazonDynamoDB db;

  @Autowired
  private DynamoDBMapper dynamoDBMapper;

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

    CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(OnlinePractice.class);
    tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

    boolean created = TableUtils.createTableIfNotExists(db, tableRequest);

    if (created) {
      LOGGER.info("Created DynamoDB table for " + Practice.class.getSimpleName());
    } else {
      LOGGER.info("Table already exists for " + Practice.class.getSimpleName());
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
