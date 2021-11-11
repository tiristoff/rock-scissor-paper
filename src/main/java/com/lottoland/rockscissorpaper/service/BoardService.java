package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.model.Board;

import java.util.List;

public interface BoardService {

  /** @return */
  public Board intNewBoard();

  /**
   * @param board
   * @return
   */
  public Board save(Board board);

  /**
   * @param id
   * @return
   */
  Board findOne(String id);

  /**
   *
   * @param board
   * @return
   */
  Board clearBoard(Board board);


}
