package com.pilotProject.middleAges.adapter.out.mongo.convertor;

import com.pilotProject.middleAges.adapter.out.mongo.entity.ExitDescriptionEntity;
import com.pilotProject.middleAges.adapter.out.mongo.entity.ExitDirectionEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class RoomReadConverter implements Converter<List<Document>, Map<ExitDirectionEntity, ExitDescriptionEntity>> {

  @Override
  public Map<ExitDirectionEntity, ExitDescriptionEntity> convert(List<Document> list) {
    Map<ExitDirectionEntity, ExitDescriptionEntity> exits = new HashMap<>();
    for (Document exitDescription: list) {
      exits.put(
          ExitDirectionEntity.valueOf(exitDescription.getString(ExitDirectionEntity.PROP_NAME)),
          new ExitDescriptionEntity(exitDescription.getString(ExitDescriptionEntity.PROP_NAME)));
    }
    return exits;
  }
}
