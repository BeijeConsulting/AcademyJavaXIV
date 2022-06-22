// Func components
import HomeNf from "./funcComponents/pageComponents/HomeNf";

// Hooks components ui
import BeerContainer from "./hooksComponents/BeerContainer/BeerContainer";
import ButtonNf from "./hooksComponents/ButtonNf";
import LoginNf from "./hooksComponents/LoginNf";
import SignupNf from "./hooksComponents/SignupNf";
import SwitchNf from "./hooksComponents/SwitchNf";
import CountDownNf from "./hooksComponents/CountDownNf";
import LobbyContainer from "./hooksComponents/LobbyContainer";
import UserContainer from "./hooksComponents/UserContainer";

// Hooks components pageComponents
import JoinLobbyNf from "./hooksComponents/pageComponents/JoinLobbyNf";
import LeaderBoard from "./hooksComponents/pageComponents/LeaderBoard";
import CreateLobby from "./hooksComponents/pageComponents/CreateLobby";


// utils
import { iconArrayCard, bossIconCard, assignIdToIconCard } from "../utils/iconArrayAssign";

export {
    LoginNf,
    SignupNf,
    ButtonNf,
    SwitchNf,
    BeerContainer,
    iconArrayCard, bossIconCard, assignIdToIconCard,
    HomeNf,
    JoinLobbyNf,
    CountDownNf,
    UserContainer,
    LobbyContainer,
    LeaderBoard,
    CreateLobby
}