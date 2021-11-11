
import {requests} from './request';
export default class GameClient{

  constructor() {};

  async playGame(id){
    const request = await fetch(requests.playGame,{
      method: 'POST',
      mode: 'cors',
      body: id
    });
    const response = await request.json();
    return response;
  }


  async resetGame(id){
    const url = requests.restartOneBoard+id
    const request = await fetch(url,{
      method: 'PUT',
      mode: 'cors',
    });
    const response = await request.json();
    return response;
  }

   async getStandings(){
    const request = await fetch(requests.standings);
    const response = await request.json();
    return response;
  }
}
