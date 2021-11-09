package com.lottoland.rockscissorpaper.mapper;

import com.lottoland.rockscissorpaper.domain.Board;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    com.lottoland.rockscissorpaper.model.Board dtoToModel(Board dto);

    Board modelToDto(com.lottoland.rockscissorpaper.model.Board model);

}
