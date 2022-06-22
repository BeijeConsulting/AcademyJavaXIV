import React from 'react'
import { Image, View } from 'react-native';
const beerIcon = require('../../../assets/img/icon/birra.png')
const shotIcon = require('../../../assets/img/icon/shot.png')

export default function BeerContainer(props) {

    let scoreIsDecimal = {
        cleanScore: props.score % 1 === 0 ? props.score : props.score - 0.5,
        isDecimal: props.score % 1 === 0 ? false : true
    }

    const generateFirstSeriesOfBeer = () => {
        console.log('prima serie')
        let arrayContainer = []
        for (let index = 0; index < (scoreIsDecimal.cleanScore > 4 ? 4 : scoreIsDecimal.cleanScore); index++) {
            arrayContainer.push(
                <Image
                    style={{ height: 60, width: 35 }}
                    key={index}
                    source={beerIcon} />
            )
        }
        return arrayContainer;
    }

    const generateSecondtSeriesOfBeer = () => {
        console.log('seconda')
        let arrayContainer = []
        for (let index = 5; index <= scoreIsDecimal.cleanScore; index++) {
            arrayContainer.push(
                <Image
                    style={{ height: 60, width: 35, marginVertical: -50, marginLeft: 10 }}
                    key={index}
                    source={beerIcon} />
            )
        }
        return arrayContainer;
    }
    return (
        <View style={{ height: 30, width: 40, flexDirection: 'row', marginLeft: -70 }}>
            <View>{/* beer container */}
                <View style={{ flexDirection: 'row' }}>{/* 1st beer container */}
                    {generateFirstSeriesOfBeer()}
                </View>
                {scoreIsDecimal.cleanScore > 4 &&
                    <View style={{ flexDirection: 'row' }}>{/* 2st beer container */}
                        {generateSecondtSeriesOfBeer()}
                    </View>
                }
            </View>
            {scoreIsDecimal.isDecimal &&
                <View>
                    <Image
                        style={{ height: 65, width: 30 }}
                        source={shotIcon} />
                </View>
            }
        </View>
    )
}
