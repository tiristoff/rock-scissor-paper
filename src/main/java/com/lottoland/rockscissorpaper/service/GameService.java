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
    Board playGame(String boardId);


    /** @return */
    List<Round> getAllRounds();
}
