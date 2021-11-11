import { useState } from "react";
import GameClient from "../apis/api.js";
import Link from "next/link";

export default function Standings() {
  function getStandings() {
    let gc = new GameClient();
    gc.getStandings().then((data) => {
      console.log(data.roundsPlayed[0].player1Result);
      setTotalRounds(data.roundsPlayed.length);
      if (totalRounds > 0) {
        setWin1(
          data.roundsPlayed.filter((r) => r.player1Result === "WIN").length
        );
        setWin2(
          data.roundsPlayed.filter((r) => r.player2Result === "WIN").length
        );
        setDraws(
          data.roundsPlayed.filter((r) => r.player1Result === "DRAW").length
        );
      }
    });
  }

  const [totalRounds, setTotalRounds] = useState(0);
  const [winsOfFirstPlayer, setWin1] = useState(0);
  const [winsOfSecondPlayer, setWin2] = useState(0);
  const [draws, setDraws] = useState(0);
  getStandings();
  return (
    <div>
      <h1>Total rounds results</h1>
      <p>Rounds played: {totalRounds}</p>
      <p>Wins of first player: {winsOfFirstPlayer}</p>
      <p>Wins of second player: {winsOfSecondPlayer}</p>
      <p>Draws: {draws}</p>
      <div>
        <Link href="/">
          <button>Return to the game</button>
        </Link>
      </div>
    </div>
  );
}
