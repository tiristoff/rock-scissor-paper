package com.lottoland.rockscissorpaper.mapper;

import com.lottoland.rockscissorpaper.domain.Board;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BoardConverter {

  public Board convertBoard(com.lottoland.rockscissorpaper.model.Board boardModel) {

    Board board = BoardMapper.INSTANCE.modelToDto(boardModel);
    board.setRounds(
        boardModel.getRounds().stream()
            .map(r -> RoundMapper.INSTANCE.modelToDto(r))
            .collect(Collectors.toList()));
    return board;
  }
}
