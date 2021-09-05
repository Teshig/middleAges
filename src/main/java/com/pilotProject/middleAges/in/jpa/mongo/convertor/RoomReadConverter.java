package com.pilotProject.middleAges.in.jpa.mongo.convertor;

import com.pilotProject.middleAges.in.jpa.mongo.entity.ExitDescriptionDto;
import com.pilotProject.middleAges.in.jpa.mongo.entity.ExitDirectionDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class RoomReadConverter implements Converter<List<Document>, Map<ExitDirectionDto, ExitDescriptionDto>> {

  @Override
  public Map<ExitDirectionDto, ExitDescriptionDto> convert(List<Document> list) {
    Map<ExitDirectionDto, ExitDescriptionDto> exits = new HashMap<>();
    for (Document exitDescription: list) {
      exits.put(
          ExitDirectionDto.valueOf(exitDescription.getString(ExitDirectionDto.PROP_NAME)),
          new ExitDescriptionDto(exitDescription.getString(ExitDescriptionDto.PROP_NAME)));
    }
    return exits;
  }
}
