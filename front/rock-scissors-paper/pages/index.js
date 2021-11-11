import Head from "next/head";
import { useState } from "react";
import GameClient from "../apis/api.js";
import RoundTable from "./roundTable.js";
import Link from "next/link";

export default function Home() {
  const [roundsPlayed, setPlayed] = useState(0);
  const [boardId, setBoardId] = useState("default");
  const [player1Choice, setChoice1] = useState();
  const [player2Choice, setChoice2] = useState();
  const [result, setResult] = useState();

  function modifyState(rounds) {
    if (rounds) {
      const lastRound = rounds[rounds.length - 1];
      setChoice1(!lastRound ? null : lastRound.player1Choice);
      setChoice2(!lastRound ? null : lastRound.player2Choice);
      setResult(!lastRound ? null : recalculateResult(lastRound));
      setPlayed(rounds.length);
    }
  }

  function recalculateResult(round) {
    switch (round.player1Result) {
      case "WIN":
        return "Player 1 WINS";
      case "LOST":
        return "Player 2 WINS";
      default:
        return "DRAW";
    }
  }

  const gc = new GameClient();
  return (
    <div className="container">
      <Head>
        <title>Lottoland - Rock Paper Scissors by Ivan</title>
        <link rel="icon" href="/favicon.png" />
      </Head>

      <h1>RoundsPlayed = {roundsPlayed}</h1>
      <div className="tableContainer">
        <RoundTable
          player1Choice={player1Choice}
          player2Choice={player2Choice}
          result={result}
        />
        <div>
          <button
            onClick={() => {
              gc.playGame(boardId).then((data) => {
                modifyState(data.rounds);
                setBoardId(data.id);
              });
            }}
          >
            Play Game
          </button>
          <button disabled={roundsPlayed === 0}
            onClick={() => {
              gc.resetGame(boardId).then((data) => {
                modifyState(data.rounds);
                setBoardId(data.id);
              });
            }}
          >
            ResetGame
          </button>
          <Link href="/standings">
            <button>Standings</button>
          </Link>
        </div>
      </div>
      <style jsx>{`
        .container {
          margin: 0 0 0 100px;
        }
        .tableContainer {
        }
        button {
          vertical-align: center;
        }
      `}</style>
    </div>
  );
}
