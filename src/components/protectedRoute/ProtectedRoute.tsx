import React from 'react'
import { useAppSelector } from '../../redux/hooks'
import { Navigate } from 'react-router-dom'
import Loader from '../loader/Loader'

interface IProps{
    outlet:JSX.Element
}
export default function ProtectedRoute({outlet}: IProps) {

    const {isloading} = useAppSelector(store => store.user)
    const token  = localStorage.getItem('userToken')
    if (token !== null){
        if(isloading){
            return <Loader/>
        }
        return outlet
    }
    return <Navigate to={'../login'}/>
}
