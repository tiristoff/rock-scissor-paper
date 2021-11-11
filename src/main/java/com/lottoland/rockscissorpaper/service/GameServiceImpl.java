package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.domain.Standings;
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
  public com.lottoland.rockscissorpaper.domain.Board playGame(String boardId) {

    Board entityBoard;
    try {
      entityBoard = boardService.findOne(boardId);
    } catch (InvalidConditionsException e) {
      entityBoard = boardService.intNewBoard();
    }

    entityBoard.getRounds().add(roundService.generateNewRound());
    return boardConverter.convertBoard(boardService.save(entityBoard));
  }

  @Override
  public Standings getAllRounds() {

    return Standings.builder()
        .roundsPlayed(
            roundService.getAllRoundsPlayed().stream()
                .map(r -> RoundMapper.INSTANCE.modelToDto(r))
                .collect(Collectors.toList()))
        .build();
  }

  @Override
  public com.lottoland.rockscissorpaper.domain.Board cleanBoard(final String id) {
    Board board = boardService.findOne(id);
    return BoardMapper.INSTANCE.modelToDto(boardService.clearBoard(board));
  }

  @Override
  public com.lottoland.rockscissorpaper.domain.Board getBoard(String id) {
    return BoardMapper.INSTANCE.modelToDto(boardService.findOne(id));
  }
}
