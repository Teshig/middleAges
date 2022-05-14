package com.pilotProject.middleAges.boot.config;

import com.pilotProject.middleAges.adapter.out.mongo.convertor.RoomReadConverter;
import com.pilotProject.middleAges.adapter.out.mongo.repository.RoomMongoRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions.MongoConverterConfigurationAdapter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = RoomMongoRepository.class)
@EntityScan("com.pilotProject.middleAges.adapter.out.mongo.entity")
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
