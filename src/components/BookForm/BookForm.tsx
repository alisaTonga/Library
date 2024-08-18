import React, { useEffect } from 'react'
import styles from './bookForm.module.css'
import MyInput from '../MyInput/MyInput';
import MyButton from '../myButton/myButton';
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import { addBook, getBooks } from '../../features/books/booksAction';
import { useFormik } from 'formik';

export default function BookForm() {
    const handleCancel = () => {}
    const handleSubmit= () => {console.log("Ok that was submitted");}

    const dispatch = useAppDispatch()
    const {books, isLoading} = useAppSelector(state => state.books);

    useEffect(()=>{
        dispatch(getBooks())
    },[dispatch])


  return(
    <form className={styles.BookForm}>
        <div id={styles.inputs}>
            <label htmlFor="title">
                <br />
                <MyInput type={'Title'} placeholder={'book title'} label={'Title: '} name={'title'}/>
            </label>

            <label htmlFor="author">
                <br />
                <MyInput type={'Author'} placeholder={'book author'} label={'Author: '} name={'author'}/>
            </label>

            <label htmlFor="year">
                <br />
                <MyInput type={'Year'} placeholder={'year of publishing'} label={'Year of Publishing: '} name={'password '}/>
            </label>

            <label htmlFor="isbn13">
                <br />
                <MyInput type={'ISBN13'} placeholder={'isbn13: '} label={'ISBN13: '} name={'isbn13 '}/>
            </label>

        </div>
        <div className={styles.buttons}>
        <MyButton id="reset" type={'reset'} name={'Cancel'} onClick={handleCancel}/>
        <MyButton id="submit" type={'submit'} name={'Submit'} onClick={handleSubmit}/> 
        </div>
    </form>
)
}
