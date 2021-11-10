package com.lottoland.rockscissorpaper;

import com.lottoland.rockscissorpaper.domain.Choice;
import com.lottoland.rockscissorpaper.domain.Result;
import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.repository.RoundRepository;
import com.lottoland.rockscissorpaper.service.RoundServiceImpl;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ResultCalculatorTest {

  @InjectMocks RoundServiceImpl roundService;

  @Mock RoundRepository roundRepository;

  private static Stream<Arguments> posibleResults() {
    return Stream.of(
        Arguments.of(new Choice[] {Choice.PAPER, Choice.ROCK}, Result.WIN),
        Arguments.of(new Choice[] {Choice.PAPER, Choice.PAPER}, Result.DRAW),
        Arguments.of(new Choice[] {Choice.PAPER, Choice.SCISSORS}, Result.LOST),
        Arguments.of(new Choice[] {Choice.ROCK, Choice.ROCK}, Result.DRAW),
        Arguments.of(new Choice[] {Choice.ROCK, Choice.PAPER}, Result.LOST),
        Arguments.of(new Choice[] {Choice.ROCK, Choice.SCISSORS}, Result.WIN),
        Arguments.of(new Choice[] {Choice.SCISSORS, Choice.ROCK}, Result.LOST),
        Arguments.of(new Choice[] {Choice.SCISSORS, Choice.PAPER}, Result.WIN),
        Arguments.of(new Choice[] {Choice.SCISSORS, Choice.SCISSORS}, Result.DRAW));
  }

  @ParameterizedTest
  @MethodSource("posibleResults")
  public void testResultCalculation(Choice[] choices, Result result) {
    assertEquals(result, roundService.getPlayerResult(choices[0], choices[1]));
  }

  @Test
  public void testRoundIsCorrectlyInicializated() {
    roundService.generateNewRound();
  }

  @Test
  public void testIfAllActionsAreObteined(){
    BDDMockito.given(roundRepository.findAll()).willReturn(new ArrayList<>());
    List rounds = roundService.getAllRoundsPlayed();
    BDDMockito.then(roundRepository).should(BDDMockito.times(1)).findAll();
;  }
}
