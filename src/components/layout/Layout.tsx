import { Link, Outlet, useLocation } from 'react-router-dom';
import styles from './layout.module.css'
import Header from '../Header/Header';
import Footer from '../Footer/Footer';
import { useEffect } from 'react';
import { useAppDispatch } from '../../redux/hooks';
import { getUserWithToken } from '../../features/auth/authAction';
function Layout() {
    const location = useLocation()
    console.log(location.pathname);
    const dispatch = useAppDispatch()

    useEffect(()=>{
        const token = localStorage.getItem("userToken")
        if (token !== null){
            dispatch(getUserWithToken(token))
        }
    },[])
    return(
        <div className={styles.page}>
        <Header />
        <main className={styles.main}>
            <Outlet />
        </main>
        <Footer />
        </div>
    )
}
export default Layout;