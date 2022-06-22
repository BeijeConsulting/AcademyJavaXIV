import React, { useState } from 'react';

// native components
import { Modal, View } from 'react-native';
import { styles } from '../../../assets/styles/styleButtonNf';

// library Components
import ButtonNf from '../ButtonNf';
import SwitchNf from '../SwitchNf';

const initState = {
  isOn: false,
  isModalVisible: false,
  players: [
    {
      id: 0,
      nickname: 'fad'
    },
    {
      id: 1,
      nickname: 'dasd'
    },
    {
      id: 2,
      nickname: 'faasdffdd'
    },
    {
      id: 3,
      nickname: 'sdfs'
    },
  ]
}
/**
 * PageComponents for createLobby
 * @param  {object} user
 * @param  {Array[object]} listOfPlayers
 * @param  {function} onTapStartGame Function to handle the start of the game. There must be at least 2 players(yourself and one more + cpu)
 */
const CreateLobby = ({ user, listOfPlayers, onTapStartGame }) => {

  const [state, setState] = useState(initState)

  /**
   * Function for add player to state.players if they weren't add yet
   * @param  {object} player
   */
  const onTapAddPlayers = (player) => () => {
    const newState = Object.assign({}, state);

    const FIND = newState.players?.some(({ nickname }) => player?.nickname === nickname)

    if (FIND) return;

    newState.players?.push(player);

    setState({
      ...newState
    })
  }
  
  /**
   * functin for controll if conditions are true for start the game
   */
  const onTapGameStart = () => {
    if (state?.players?.length >= 2) {

      onTapStartGame()
    }
  }

  /**
   * set a boolean value to his opposite
   * @param  {string} property
   */
  const onHandleChange = (property) => () => {
    setState({
      ...state,
      [property]: !state[property]
    })
  }
  /**
   * make a map of the player coming form server and onPress add them to state.players
   * @param  {object} player
   * @param  {number} key
   */
  const playerList = (player, key) => {
    return (
      <View key={`${key}-${player?.id}`}>
        <ButtonNf title={player?.nickname} onPress={onTapAddPlayers(player)} />
      </View>
    )
  }

  return (
    <View style={styles.CreateLobbyContainer}>
      <ButtonNf title={user?.nickname} />
      <ButtonNf title='Add players' onPress={onHandleChange('isModalVisible')} />
      <SwitchNf isOn={state?.isOn} onValueChange={onHandleChange('isOn')} />
      <ButtonNf title='Start game' onPress={onTapGameStart} />
      <Modal
        transparent={false}
        visible={state?.isModalVisible}
      >

        {
          listOfPlayers?.length > 0 && listOfPlayers.map(playerList)
        }

      </Modal>
    </View>

  )
}

export default CreateLobby