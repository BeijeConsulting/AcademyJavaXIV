import React, { useEffect, useState } from 'react'
import { Image, View, Text, Button } from 'react-native';
import { assignIdToIconCard } from '../../utils/iconArrayAssign';
import BeerContainer from './BeerContainer/BeerContainer';
const UserContainer = () => {
    const [state, setState] = useState({
        playerIcon: {}
    })
    const IDTMP = 0
    useEffect(() => {
        setState({
            playerIcon: assignIdToIconCard(IDTMP)
        })
    }, [])
    return (
        <View style={{ position: "absolute", left: '6%', top: '42%', flexDirection: 'column', alignItems: 'center', width: 130 }}>
            <View>{/* cardIcon */}

                <Image style={{ height: 140, width: 100 }}
                    source={state.playerIcon.regular} />
            </View>
            <View style={{ height: 80 }}>{/* Score in beers/shot */}
                <BeerContainer
                    score={7.5} />
            </View>
            <View style={{ marginTop: -20 }}>
                <Text style={{ fontSize: 30 }}>{7.5}</Text>
            </View>
            <View style={{ marginTop: 5 }}>
                <Text>Nickname</Text>
            </View>

        </View>
    )
}

export default UserContainer