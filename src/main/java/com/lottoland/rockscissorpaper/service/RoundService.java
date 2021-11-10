package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.Choice;
import com.lottoland.rockscissorpaper.domain.Result;
import com.lottoland.rockscissorpaper.model.Round;

import java.util.List;

public interface RoundService{

    List<Round> getAllRoundsPlayed();

    Round save(Round round);

    Round generateNewRound();

    Result getPlayerResult(Choice choice1, Choice choice2);
}
