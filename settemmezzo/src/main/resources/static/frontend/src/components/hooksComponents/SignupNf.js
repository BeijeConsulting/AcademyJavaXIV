import React, { useState } from 'react';

// native components
import { Text, View, Button, TextInput } from 'react-native';

// validation
import { checkMail, checkPassword } from '../../utils/validation';

// styles
import { styles } from '../../assets/styles/styleSignupLogin';

const initState = {
    isDisable: true
}

const formData = {
    name: '',
    nickname: '',
    email: '',
    password: '',
    confirmPassword: ''
}

const SignupNf = () => {

    const [state, setState] = useState(initState);

    const handleChange = (property) => (e) => {
        const newState = Object.assign({}, state);

        if (formData.password === formData.confirmPassword && checkMail(formData.email)) {

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
                Sign up
            </Text>

            <View style={styles.inputContainer}>
                <TextInput
                    style={styles.textInput}
                    onChange={handleChange('name')}
                    placeholder={'Insert name'}
                />
                <TextInput
                    style={styles.textInput}
                    onChange={handleChange('nickname')}
                    placeholder={'Insert nickname'}
                />
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
                <TextInput
                    style={styles.textInput}
                    secureTextEntry
                    onChange={handleChange('confirmPassword')}
                    placeholder={'Insert confirm password'}
                />
            </View>

            <Button
                title={'Sign up'}
                style={styles.btn}
                disabled={state.isDisable}
                onPress={handleSubmit}
            />
        </View>
    )
}

export default SignupNf;