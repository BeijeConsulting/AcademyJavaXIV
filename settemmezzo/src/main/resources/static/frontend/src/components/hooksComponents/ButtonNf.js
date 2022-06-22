import React from 'react';
import PropTypes from 'prop-types';

// native components
import { Text, TouchableOpacity } from 'react-native';
import { styles } from '../../assets/styles/styleButtonNf';

/**
 * Button Custom with 3 props
 * @param  {string} title
 * @param  {func} onPress
 * @param  {boolean} isDisabled
 */
const ButtonNf = ({ title, onPress, isDisabled }) => {
  return (
    <>
      <TouchableOpacity
        disabled={isDisabled}
        accessibilityRole="button"
        onPress={onPress}
        style={styles.btnPrimary}
      >
        <Text style={styles.btnText}>
          {title}
        </Text>
      </TouchableOpacity>
    </>
  )
}

ButtonNf.defaultProps = {
  title: 'btnName',
  isDisabled: false
}

ButtonNf.propTypes = {
  title: PropTypes.string,
  isDisabled: PropTypes.bool,
  onPress: PropTypes.func
}

export default ButtonNf