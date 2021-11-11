import { useState } from "react";

export default function RoundTable(prop) {
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Player 1 choice</th>
            <th>Player 2 choice</th>
            <th>Result</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{prop.player1Choice}</td>
            <td>{prop.player2Choice}</td>
            <td>{prop.result}</td>
          </tr>
        </tbody>
      </table>

      <style jsx>{`
       table{
        padding:10px;
        border-collapse: collapse;
        font-size: 0.9em;
        font-family: sans-serif;
        min-width: 400px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
       }
       table thead tr{
        background-color: #009879;
        color: #ffffff;
        text-align: center;
       }

       table tbody tr {
        border-bottom: 1px solid #dddddd;
        text-align: center
    }
    
      `}</style>
    </div>
  );
}
