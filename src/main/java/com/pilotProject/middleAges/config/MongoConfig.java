package com.pilotProject.middleAges.config;

import com.pilotProject.middleAges.in.jpa.mongo.convertor.RoomReadConverter;
import com.pilotProject.middleAges.in.jpa.mongo.repository.RoomJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions.MongoConverterConfigurationAdapter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@EnableMongoRepositories(basePackageClasses = RoomJpaRepository.class)
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
