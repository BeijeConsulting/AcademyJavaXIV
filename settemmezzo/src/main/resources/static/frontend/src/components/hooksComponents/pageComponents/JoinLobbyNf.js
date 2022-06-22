import React, { useState } from 'react';

// native components
import { View } from 'react-native';
import ButtonNf from '../ButtonNf';
import CountDownNf from '../CountDownNf';

const initState = {
  players: [
    {
      id: 0,
      nickname: 'Federico'
    },
    {
      id: 1,
      nickname: 'Nicola'
    },
    {
      id: 2,
      nickname: 'Luca'
    },
    {
      id: 3,
      nickname: 'Andrea'
    },
    {
      id: 4,
      nickname: 'Andrea'
    },
    {
      id: 5,
      nickname: 'Andrea'
    },
    {
      id: 6,
      nickname: 'Andrea'
    },
  ],
}

const hoursMinSecs = {hours:0, minutes: 0, seconds: 10}


const JoinLobbyNf = ({onEndTimer}) => {

  const [state, setState] = useState(initState);

  const player = (player, key) => {
    return (
      <ButtonNf key={`${key}-${player?.id}`} title={`Player ${player?.nickname}`} />
    )
  }

  return (
    <View>
      {
        state.players.length > 0 && state.players.map(player)
      }
      <CountDownNf onEndTimer={onEndTimer} hoursMinSecs={hoursMinSecs} />
    </View>
  )
}

export default JoinLobbyNf;