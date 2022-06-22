import React from 'react';

// native components
import { View } from 'react-native';
import ButtonNf from '../../hooksComponents/ButtonNf';

/**
 * home page components for seven and half game
 * @param  {function} onQuickMatch
 * @param  {function} onCreateLobby
 * @param  {function} onLeaderBoard
 */
const HomeNf = ({ onQuickMatch, onCreateLobby, onLeaderBoard }) => {

  return (
    <View>
      <ButtonNf
        title={'Quick match'}
        onPress={onQuickMatch}
      />

      <ButtonNf
        title={'create lobby'}
        onPress={onCreateLobby}
      />

      <ButtonNf
        title={'Leader board'}
        onPress={onLeaderBoard}
      />
    </View>
  )
}

export default HomeNf;