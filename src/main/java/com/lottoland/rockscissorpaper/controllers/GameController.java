package com.lottoland.rockscissorpaper.controllers;

import com.lottoland.rockscissorpaper.domain.Board;
import com.lottoland.rockscissorpaper.domain.Round;
import com.lottoland.rockscissorpaper.domain.Standings;
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
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

  private GameService gameService;

  @ApiOperation(value = "play the rock-scissor-rock")
  @PostMapping("/play")
  public ResponseEntity<Board> play(
      @RequestBody String currentBoardId, @RequestHeader HttpHeaders headers) {
    return new ResponseEntity<>(gameService.playGame(currentBoardId),HttpStatus.OK);
  }

  @ApiOperation(value = "restart one board")
  @PutMapping("/clean/board/{boardId}")
  public ResponseEntity<Board> restartBoard(
          @PathVariable String boardId, @RequestHeader HttpHeaders headers) {
    return new ResponseEntity<>(gameService.cleanBoard(boardId),HttpStatus.OK);
  }

  @ApiOperation(value = "Obtain one board data")
  @GetMapping("/board/{boardId}")
  public ResponseEntity<Board> getBoard(@PathVariable String boardId){
    return new ResponseEntity<>(gameService.getBoard(boardId),HttpStatus.OK);
  }

  @ApiOperation(value = "Obtain standings")
  @GetMapping("/standings")
  public ResponseEntity<Standings> getStandings(){
    return new ResponseEntity<>(gameService.getAllRounds(),HttpStatus.OK);
  }
}
