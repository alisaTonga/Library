import MyButton from "../myButton/myButton";
import MyInput from "../MyInput/MyInput";
import styles from './loginForm.module.css'

export default function LoginForm(){
    const handleCancel = () => {console.log("Ok that was canceled. See you next time");}
    const handleSubmit= () => {console.log("Ok that was submitted");}
    return(
        <form className={styles.loginForm}>
            <div id="inputs">
                <label htmlFor="login">
                    <br />
                    <MyInput type={'Login'} placeholder={'username'} label={'Login: '} name={'login'}/>
                </label>

                <label htmlFor="email">
                    <br />
                    <MyInput type={'Email'} placeholder={'username@gmail.com'} label={'Email: '} name={'email'}/>
                </label>

                <label htmlFor="password">
                    <br />
                    <MyInput type={'Password'} placeholder={'***************'} label={'Password: '} name={'password '}/>
                </label>

            </div>
            <div id="buttons">
            <MyButton id="reset" type={'reset'} name={'Cancel'} onClick={handleCancel}/>
            <MyButton id="submit" type={'submit'} name={'Submit'} onClick={handleSubmit}/> 
            </div>
        </form>
    )
}