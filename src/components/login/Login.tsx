import React from 'react'
import styles from './login.module.css'
import { useFormik } from 'formik';
import { useAppDispatch } from '../../redux/hooks';
import { loginUser } from '../../features/auth/authAction';
import { useNavigate } from 'react-router-dom';

export interface ILoginValues{
    username: string,
    password: string,
    }

export default function Login() {
    const dispatch = useAppDispatch()
    const navigate = useNavigate()
    const formik = useFormik({
        initialValues: {
            username: 'emilys',
            password: 'emilyspass',
        } as ILoginValues,
        onSubmit: (values: ILoginValues, {resetForm})=> {
            dispatch(loginUser(values)).then(()=>{
            navigate('/')
            //resetForm();
            })

        }
        })
    return (
    <div>
        <form onSubmit={formik.handleSubmit} className={styles.loginForm}>
        <h1 className={styles.h1}>Login form 🔒</h1>

        <input className={styles.username} name='username' value={formik.values.username} 
        onChange={formik.handleChange} type="text" placeholder='Username: ' />

        <input className={styles.password} name='password' value={formik.values.password} 
        onChange={formik.handleChange} type="text" placeholder='password: '/>

        <button type="submit">send</button>
        </form>
    </div>
    )
}
