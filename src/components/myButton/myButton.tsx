    // import './myButton.css'
import styles from './myButton.module.css'


interface IMyButtonProps{
    id?: number | string
    name?: string,
    type?: 'submit' | 'reset' | 'button' 
    onClick?: () => void
}

export default function MyButton({type ='button', onClick, name = 'default'}:IMyButtonProps){
    console.log(styles);
    return <button type={type} onClick={onClick} className={styles.myButton}>{name}</button>
}