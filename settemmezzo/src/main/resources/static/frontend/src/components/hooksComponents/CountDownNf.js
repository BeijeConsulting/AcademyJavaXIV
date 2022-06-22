import React, { useEffect, useState } from 'react';

// native components
import { Text, View } from 'react-native';

// styles
import { styles } from '../../assets/styles/styleCountDownNf';

const CountDownTimer = ({ hoursMinSecs, onEndTimer }) => {

  const { hours = 0, minutes = 0, seconds = 60 } = hoursMinSecs;
  const [[hrs, mins, secs], setTime] = useState([hours, minutes, seconds]);

  const callbackUseEffect = () => {
      const timerId = setInterval(() => tick(), 1000);
      if(secs === 0 && onEndTimer){
        onEndTimer();
      }

      return () => clearInterval(timerId);
  }

  useEffect(callbackUseEffect);

  const tick = () => {

    if (hrs === 0 && mins === 0 && secs === 0)
      reset()
    else if (mins === 0 && secs === 0) {
      setTime([hrs - 1, 59, 59]);
    } else if (secs === 0) {
      setTime([hrs, mins - 1, 59]);
    } else {
      setTime([hrs, mins, secs - 1]);
    }
  };

  const reset = () => setTime([parseInt(hours), parseInt(minutes), parseInt(seconds)]);



  return (
    <View style={styles.countDownContainer}>
      <Text style={styles.countDown}>
        {`${hrs.toString().padStart(2, '0')}:${mins
          .toString()
          .padStart(2, '0')}:${secs.toString().padStart(2, '0')}`}
      </Text>
    </View>
  );
}

export default CountDownTimer;