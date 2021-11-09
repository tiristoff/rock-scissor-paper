package com.lottoland.rockscissorpaper.service;

import com.lottoland.rockscissorpaper.domain.Choice;
import com.lottoland.rockscissorpaper.domain.Result;
import com.lottoland.rockscissorpaper.model.Round;
import com.lottoland.rockscissorpaper.repository.RoundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("RoundService")
@AllArgsConstructor
public class RoundServiceImpl implements RoundService {

  private RoundRepository roundRepository;

  @Override
  public List<Round> getAllRoundsPlayed() {
    return roundRepository.findAll();
  }

  @Override
  public Round save(Round round) {
    return roundRepository.save(round);
  }

  @Override
  public Round generateNewRound() {
    return initNewRound();
  }

  private Round initNewRound() {

    Choice playerOneChoice = generateRandomChoice();
    Choice playerTwoChoice = Choice.ROCK;
    Result playerOneResult = getPlayerResult(playerOneChoice, playerTwoChoice);

    return save(
        Round.builder()
            .id(UUID.randomUUID().toString())
            .player1Choice(playerOneChoice)
            .player2Choice(playerTwoChoice)
            .player1Result(playerOneResult)
            .player2Result(Result.valueOf(playerOneResult.getOppositeResult()))
            .build());
  }

  private Choice generateRandomChoice() {
    int maxRandom = Choice.values().length - 1;
    return Choice.values()[(int)( Math.random() * (maxRandom + 1)) ];
  }

  private Result getPlayerResult(Choice choice1, Choice choice2) {
    int[][] resultsMatrix = {
      {1, 0, 2},
      {2, 1, 0},
      {0, 2, 1}
    };

    return Result.getByValue(resultsMatrix[choice1.getValue()][choice2.getValue()]);
  }
}
