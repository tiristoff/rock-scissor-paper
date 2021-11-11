package com.lottoland.rockscissorpaper.service;


import com.lottoland.rockscissorpaper.domain.Board;
import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.domain.Standings;

import java.util.List;

public interface GameService {


    /**
     *
     * @param board
     * @return
     */
    Board playGame(String boardId);


    /** @return */
    Standings getAllRounds();

    /**
     *
     * @return
     */
    Board cleanBoard(String id);

    /**
     *
     * @param id
     * @return
     */
    Board getBoard(String id);
}
