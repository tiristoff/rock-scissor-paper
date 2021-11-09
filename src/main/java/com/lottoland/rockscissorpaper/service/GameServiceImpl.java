package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.domain.exception.InvalidConditionsException;
import com.lottoland.rockscissorpaper.mapper.BoardConverter;
import com.lottoland.rockscissorpaper.mapper.BoardMapper;
import com.lottoland.rockscissorpaper.mapper.RoundMapper;
import com.lottoland.rockscissorpaper.model.Board;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("gameService")
@AllArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService {

  private RoundService roundService;
  private BoardService boardService;
  private BoardConverter boardConverter;

  @Override
  public com.lottoland.rockscissorpaper.domain.Board playGame(
      com.lottoland.rockscissorpaper.domain.Board board) {

    Board entityBoard;
    try {
      entityBoard = boardService.findOne(board.getId());
    } catch (InvalidConditionsException e) {
      entityBoard = boardService.intNewBoard();
    }

    entityBoard.getRounds().add(roundService.generateNewRound());
    boardService.save(entityBoard);
    return boardConverter.convertBoard(entityBoard);
  }

  @Override
  public List<Round> getAllRounds() {
    return roundService.getAllRoundsPlayed().stream()
        .map(r -> RoundMapper.INSTANCE.modelToDto(r))
        .collect(Collectors.toList());
  }
}
