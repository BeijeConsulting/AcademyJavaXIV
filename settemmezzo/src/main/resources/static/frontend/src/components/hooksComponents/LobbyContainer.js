import React, { useEffect } from 'react'
import { View, ImageBackground, Button, Dimensions } from 'react-native';
import UserContainer from './UserContainer';
import bgImage from '../../assets/bgImage.png'
import axios from 'axios'

const LobbyContainer = () => {

    useEffect(()=>{
        axios.post('/lobby',{
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwb2xsbyIsInJvbGVzIjpbIlVTRVIiXSwiaWF0IjoxNjU1OTA0MjIzLCJleHAiOjE2NTU5MDc4MjN9.TmIG_AbFQbDm_gLrr283CJPyxFtSFnUJltzuWDwKJdk",
            }).then(res=>console.log(res,res?.data))

    },[])


    const generateTestUser = () => {

        let arrayTmp = []
        for (let index = 0; index < 7; index++) {
            arrayTmp.push(
                <View>
                    {/* <UserContainer
                    key={index}></UserContainer> */}
                </View>)
        }
        return arrayTmp;


    }
    return (
        <ImageBackground source={bgImage} style={{ flexDirection: 'row', justifyContent: 'center', alignItems: 'center', height: '100vh', width: '100vw', position: 'relative' }}
            resizeMode='cover'>
            <View style={{ position: 'absolute', backgroundColor: 'white', height: '33%', width: '75%', top: '43%', left: '10%' }}></View>
            {/* generateTestUser() */}
            {/*  <View style={{
                flexDirection: 'row', bottom: 50, justifyContent: 'center'
            }}>
                <Button
                    title={'pesca una carta'}></Button>
                <Button
                    title={'Stop'}></Button>
            </View> */}
        </ImageBackground >

    )
}

export default LobbyContainer