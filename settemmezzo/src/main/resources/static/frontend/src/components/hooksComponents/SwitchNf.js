import React from 'react';
import PropTypes from 'prop-types';

// native components
import { Switch, Text, View } from 'react-native';
import { styles } from '../../assets/styles/genericStyles';

/**
 * switch custom
 * @param  {boolean} isOn
 * @param  {function} onValueChange
 */
const SwitchNf = ({ isOn, onValueChange }) => {

  return (
    <View style={styles.genericContainer}>
      <Switch
        onValueChange={onValueChange}
        activeThumbColor='#939393'
        activeTrackColor='#ffbf43'
        thumbColor='#ffbf43'
        trackColor='#939393'
        value={isOn}
        style={styles.genericMt}
      />
      {isOn ? <Text>Public</Text> : <Text>Private</Text>}
    </View>
  )
}

SwitchNf.defaultProps = {
  isOn: false,
}

SwitchNf.propTypes = {
  isOn: PropTypes.bool,
  onValueChange: PropTypes.func
}

export default SwitchNf;