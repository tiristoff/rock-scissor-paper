import Head from "next/head";
import { useState } from "react";
import GameClient from "../apis/api.js";
import RoundTable from "./roundTable.js";
import Link from "next/link";
import { useRouter } from "next/dist/client/router";

export default function Board() {
  const gc = new GameClient();
  const [roundsPlayed, setPlayed] = useState(0);
  const [boardId, setBoardId] = useState(
    useRouter().query.board ? useRouter().query.board : "default"
  );
  const [player1Choice, setChoice1] = useState();
  const [player2Choice, setChoice2] = useState();
  const [result, setResult] = useState();
  fetchDataOnFirstEnter(boardId);
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

  function fetchDataOnFirstEnter(id) {
    gc.getBoardData(boardId).then((data) => {
      if (data.rounds) {
        modifyState(data.rounds);
        setBoardId(data.id);
      }
    });
  }

  return (
    <div className="main">
      <div>
        <Head>
          <title>Lottoland - Rock Paper Scissors by Ivan</title>
          <link rel="icon" href="/favicon.png" />
        </Head>
        <h1>ROCK PAPER SCISSORS</h1>
        <div className="tableContainer">
          <RoundTable
            player1Choice={player1Choice}
            player2Choice={player2Choice}
            result={result}
          />
          <div className="buttons">
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
            <button
              disabled={roundsPlayed === 0}
              onClick={() => {
                gc.resetGame(boardId).then((data) => {
                  modifyState(data.rounds);
                  setBoardId(data.id);
                });
              }}
            >
              ResetGame
            </button>
            <Link href={{ pathname: "/standings", query: { board: boardId } }}>
              <button>Standings</button>
            </Link>
          </div>
        </div>
        <h2>RoundsPlayed: {roundsPlayed}</h2>
      </div>
      <style jsx>{`
        div {
          margin-top: 10px;
        }

        .main {
          display: flex;
          justify-content: center;
          margin: 10px;
        }


        button {
          color: #fff !important;
          text-transform: uppercase;
          text-decoration: none;
          background: #ed3330;
          padding: 20px;
          border-radius: 5px;
          display: inline-block;
          border: none;
          margin-right: 5px;
          transition: all 0.4s ease 0s;
        }
        button:hover {
          background: #434343;
          letter-spacing: 1px;
          -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
          -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
          box-shadow: 5px 40px -10px rgba(0,0,0,0.57);
          transition: all 0.4s ease 0s;
        }

      `}</style>

      <style jsx global>{`
        @font-face {
          font-family: arvo;
          src: url("arvo.ttf");
        }
        * {
          font-family: arvo;
        }
      `}</style>
    </div>
  );
}
