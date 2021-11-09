package com.lottoland.rockscissorpaper.mapper;

import com.lottoland.rockscissorpaper.model.Round;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoundMapper {

    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);

    Round dtoToModel(com.lottoland.rockscissorpaper.domain.Round dto);

    com.lottoland.rockscissorpaper.domain.Round modelToDto(Round model);
}
