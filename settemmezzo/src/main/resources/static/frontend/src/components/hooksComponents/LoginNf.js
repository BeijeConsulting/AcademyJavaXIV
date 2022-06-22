import React, { useState } from 'react';

// native components
import { View, Text, Button, TextInput } from 'react-native';

// styles
import { styles } from '../../assets/styles/styleSignupLogin';

const formData = {
    email: '',
    password: ''
}

const initState = {
    isDisable: true
}

const LoginNf = () => {

    const [state, setState] = useState(initState);

    const handleChange = (property) => (e) => {
        const newState = Object.assign({}, state);

        if ((formData.email && formData.password) !== '') {

            newState.isDisable = false;
        } else {

            newState.isDisable = true;
        }

        setState({ ...state, isDisable: newState.isDisable });

        formData[property] = e.target.value;
    }

    const handleSubmit = () => {
        // api post
        console.log(formData);
    }

    return (
        <View style={styles.container}>

            <Text style={styles.title}>
                Login
            </Text>

            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.textInput}
                    onChange={handleChange('email')}
                    placeholder={'Insert email'}
                />

                <TextInput
                    style={styles.textInput}
                    secureTextEntry
                    onChange={handleChange('password')}
                    placeholder={'Insert password'}
                />
            </View>

            <Button
                title={'Login'}
                style={styles.btn}
                disabled={state.isDisable}
                onPress={handleSubmit}
            />
        </View>
    )
}

export default LoginNf;