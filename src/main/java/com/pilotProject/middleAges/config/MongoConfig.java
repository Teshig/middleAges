package com.pilotProject.middleAges.onfig;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "middleAges";
  }


}
