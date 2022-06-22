import React, { useEffect, useState } from 'react';

// native components
import { View, Text, Image, ImageBackground, Pressable } from 'react-native';

// styles
import { styles } from '../../../assets/styles/styleLeaderBoard';

import beer from '../../../assets/img/icon/birra.png';
import ship from '../../../assets/img/icon/futuramaship.png';
import bg from '../../../assets/img/background/leaderboardbg.jpg';

const initState = {
  players: [
    {
      id: 0,
      nickname: 'Federico',
      score: 200
    },
    {
      id: 1,
      nickname: 'Nicola',
      score: 400
    },
    {
      id: 2,
      nickname: 'Luca',
      score: 100
    },
    {
      id: 3,
      nickname: 'Andrdsaea',
      score: 4300
    },
    {
      id: 4,
      nickname: 'dff',
      score: 242300
    },
    {
      id: 5,
      nickname: 'fdfsfs',
      score: 243400
    },
    {
      id: 6,
      nickname: 'fsdfsdatdt',
      score: 22200
    },
  ],
}

const id = 1

const LeaderBoard = ({ onClickNavigate }) => {

  const [state, setState] = useState(initState);

  function callbackUseEffect() {
    //api call for get players nickname and score
  }

  function playerList(player, key) {
    return (
      <View
        style={styles.leaderBoardContainer}
        key={`${key}-${player.score}`}
      >
        <View

          style={styles.leaderRow}
        >
          <Text
            style={{
              color: player.id === id ? '#B72B29' : '#ffbf43',
              fontSize: 20,
              textShadowColor: 'rgba(0, 0, 0, 0.75)',
              textShadowOffset: { width: 1, height: 1 },
              textAlign: 'center'
            }}
          >
            {
              player.id === id && <Image source={beer} style={{ width: 20, height: 20 }} />
            }
            {player.nickname}

          </Text>

          {/* <View style={gstyles.flexR}> */}
          {/* </View> */}

        </View>
        <View style={styles.leaderRow}>
          <Text style={{
            color: player.id === id ? '#B72B29' : '#fff',
            fontSize: 20,
            textShadowColor: 'rgba(0, 0, 0, 0.75)',
            textShadowOffset: { width: 1, height: 1 },
          }}>
            {player.score}
          </Text>
        </View>
      </View>
    )
  }

  function sortPlayer(a, b) {
    if (a.score > b.score) return -1;
    if (a.score == b.score) return 0;
    if (a.score < b.score) return 1;
  }

  useEffect(callbackUseEffect, [])

  return (
    <ImageBackground source={bg} style={{ width: '100%', height: '100%' }}>

      <Pressable
        onPress={onClickNavigate}
      >
        <Image source={ship} style={styles.imgShip} />
      </Pressable>
      <View style={{ backgroundColor: 'rgba(255, 246, 143, .6)', paddingVertical: 20, marginTop: 40 }}>

        <View style={styles.titleWrapper}>
          <Text style={styles.leader}>
            Leader
          </Text>
          <Text style={{ ...styles.leader, ...styles.board }}>
            Board
          </Text>
        </View>

        <View style={styles.tableHead}>
          <Text style={styles.nickname}>Nickname</Text>
          <Text style={{ ...styles.nickname, ...styles.score }}>score</Text>
        </View>
        {
          state.players.length > 0 && state.players.sort(sortPlayer).map(playerList)
        }
      </View>
    </ImageBackground>
  )
}

export default LeaderBoard