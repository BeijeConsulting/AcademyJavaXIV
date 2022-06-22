// config
import { WEBSOCKET } from "./config";

const socket = new WebSocket(WEBSOCKET);

export const openConnection = () => {
    // socket.send('Connected to server')
}

export const closeConnection = () => {
    socket.close('disconnected to server')
}

export const wsMessage = () => {
    socket.onmessage = event => {
        // listen to data sent from the websocket server
        const message = JSON.parse(event.data);
        console.log(message)
    }
}

export const sendDataToWs = (data) => {
    // socket.send(data)
}