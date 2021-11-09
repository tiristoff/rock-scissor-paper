package com.lottoland.rockscissorpaper.service;


import com.lottoland.rockscissorpaper.domain.Board;
import com.lottoland.rockscissorpaper.domain.Round;

import java.util.List;

public interface GameService {


    /**
     *
     * @param board
     * @return
     */
    Board playGame(Board board);


    /** @return */
    List<Round> getAllRounds();
}
