package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.exception.InvalidConditionsException;
import com.lottoland.rockscissorpaper.model.Board;
import com.lottoland.rockscissorpaper.model.Round;
import com.lottoland.rockscissorpaper.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("BoardService")
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

  private BoardRepository boardRepository;

  @Override
  public Board intNewBoard() {
    return save(
        Board.builder().id(UUID.randomUUID().toString()).rounds(new ArrayList<Round>()).build());
  }

  @Override
  public Board save(Board board) {
    return boardRepository.save(board);
  }

  @Override
  public Board findOne(String id) {
    return boardRepository.findById(id)
        .orElseThrow(
            () -> new InvalidConditionsException("Board don´t exists, new game will be created"));
  }


}
