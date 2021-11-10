package com.lottoland.rockscissorpaper.controllers;

import com.lottoland.rockscissorpaper.domain.Board;
import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.service.GameService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameController {

  private GameService gameService;

  @ApiOperation(value = "play the rock-scissor-rock")
  @PutMapping("/play")
  public ResponseEntity<Board> play(
      @RequestBody String currentBoardId, @RequestHeader HttpHeaders headers) {
    return new ResponseEntity<>(gameService.playGame(currentBoardId),HttpStatus.OK);
  }
  @ApiOperation(value = "Obtain standings")
  @GetMapping("/standings")
  public ResponseEntity<List<Round>> getStandings(){
    return new ResponseEntity<>(gameService.getAllRounds(),HttpStatus.OK);
  }
}
