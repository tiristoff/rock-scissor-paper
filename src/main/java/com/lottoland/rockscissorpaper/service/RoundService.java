package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.model.Round;

import java.util.List;

public interface RoundService{

    List<Round> getAllRoundsPlayed();

    Round save(Round round);

    Round generateNewRound();
}
