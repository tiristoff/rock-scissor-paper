package com.lottoland.rockscissorpaper;

import com.lottoland.rockscissorpaper.domain.Choice;
import com.lottoland.rockscissorpaper.domain.Result;
import com.lottoland.rockscissorpaper.domain.exception.InvalidConditionsException;
import com.lottoland.rockscissorpaper.mapper.BoardConverter;
import com.lottoland.rockscissorpaper.model.Board;
import com.lottoland.rockscissorpaper.service.BoardService;
import com.lottoland.rockscissorpaper.service.GameServiceImpl;
import com.lottoland.rockscissorpaper.service.RoundService;
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
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

  @InjectMocks private GameServiceImpl gameService;
  @Mock private RoundService roundService;
  @Mock private BoardService boardService;
  @Mock private BoardConverter boardConverter;

  private static final String BOARD_ID = "92ed9e0d-8557-4459-9528-4550c275da4c";

  private static Stream<Arguments> posibleResults() {
    return Stream.of(null, Arguments.of(BOARD_ID));
  }

  @ParameterizedTest
  @MethodSource("posibleResults")
  public void testPlayGame(String boardId) {
    Board board = new Board();
    board.setRounds(new ArrayList<>());
    if (null == boardId) {
      BDDMockito.given(boardService.findOne(eq(null))).willThrow(InvalidConditionsException.class);
      BDDMockito.given(boardService.intNewBoard()).willReturn(board);
    } else {
      BDDMockito.given(boardService.findOne(eq(BOARD_ID))).willReturn(board);
    }
    BDDMockito.given(boardService.save(eq(board))).willReturn(board);
    gameService.playGame(boardId);
  }

  @Test
  public void testAllRoundsAreObteined() {

    BDDMockito.given(roundService.getAllRoundsPlayed()).willReturn(new ArrayList<>());

    gameService.getAllRounds();
  }
}
