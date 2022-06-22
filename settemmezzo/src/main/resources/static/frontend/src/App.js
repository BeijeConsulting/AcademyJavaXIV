import { useEffect, useState } from "react";
import { View } from "react-native";
import { ButtonNf, HomeNf, JoinLobbyNf, LeaderBoard, Login, Signup, SwitchNf, LobbyContainer } from "./components";
import CreateLobby from "./components/hooksComponents/pageComponents/CreateLobby";

import { closeConnection, openConnection, sendDataToWs, wsMessage } from "./services/genericWebSocket";
function App() {
  const [first, setfirst] = useState(false)

  // useEffect(()=> {
  //   openConnection()
  //   closeConnection()
  //   wsMessage();
  //   sendDataToWs('ciao');
  // }, [])
  const onValueChange = () => {
    setfirst(!first)
  }



  return (
    <>
      <View style={{ height: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
        {/* <ButtonNf title='prova' onPress={()=> console.log('premuto')}/> */}
        {/* <SwitchNf isOn={first} onValueChange={()=> setfirst(!first)} /> */}

        <LobbyContainer></LobbyContainer>
        {/* <LeaderBoard /> */}
        {/* <CreateLobby user={{ Id: 1, nickname: 'me' }} onTapStartGame={()=> console.log('tap')} /> */}
      </View>
    </>
  );
}

export default App;
