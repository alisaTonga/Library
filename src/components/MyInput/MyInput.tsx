import styles from './myIput.module.css'
interface IMyInput {
    type?: string
    placeholder?: string
    label?: string
    name?: string
}

export default function MyInput({type='text',placeholder='default',label ='default',name='input'}:IMyInput){
    return(
        <>
        <label className={styles.label}>{label} <br /></label>
        <input className={styles.my_Input} type={type}  placeholder = {placeholder} name={name}/>
        </>
    )
}