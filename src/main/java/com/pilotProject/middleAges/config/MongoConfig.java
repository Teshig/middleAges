package com.pilotProject.middleAges.config;

import com.pilotProject.middleAges.mongo.convertor.RoomReadConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions.MongoConverterConfigurationAdapter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.pilotProject.middleAges.mongo.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {


  @Override
  protected void configureConverters(MongoConverterConfigurationAdapter adapter) {
    adapter.registerConverter(new RoomReadConverter());
  }

  @Override
  protected String getDatabaseName() {
    return "middleAges";
  }

}
