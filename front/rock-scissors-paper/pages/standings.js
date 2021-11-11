import { useContext, useState } from "react";
import GameClient from "../apis/api.js";
import Link from "next/link";
import { useRouter } from "next/dist/client/router";


export default function Standings() {

  function getStandings() {
    let gc = new GameClient();
    gc.getStandings().then((data) => {
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
       <style jsx global>{`
      @font-face { font-family: arvo; src: url('arvo.ttf'); }
        *{
          font-family: arvo
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
      <h1>Total rounds results</h1>
      <p>Rounds played: {totalRounds}</p>
      <p>Wins of first player: {winsOfFirstPlayer}</p>
      <p>Wins of second player: {winsOfSecondPlayer}</p>
      <p>Draws: {draws}</p>
      <div>
        <Link href={{pathname : "/", query:{board : useRouter().query.board} }}>
          <button>Return to the game</button>
        </Link>
      </div>
    </div>
  );
}
