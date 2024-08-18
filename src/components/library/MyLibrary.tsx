import React, { useEffect } from 'react'
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import { getBooks } from '../../features/books/booksAction';
import Loader from '../loader/Loader';
import styles from './myLibrary.module.css'
import BookElement from '../BookElement/BookElement';
import MyButton from '../myButton/myButton';


export interface IBook{
    id: number,
    title: string,
    author: string,
    year: number,
    isbn13: string,
}
export default function MyLibrary() {

    const dispatch = useAppDispatch()
    const {books, isLoading} = useAppSelector(state => state.books);

    useEffect(()=>{
        dispatch(getBooks())
    },[dispatch])

    const handleUpdate = ()=>{
        getBooks()
    }

  return (
    <div>
        {isLoading && <Loader /> }
        <h1 className={styles.mainH1}>My library 📚</h1>
        <MyButton id={styles.update} type="submit" name='Update'/>

        <div className={styles.grid}>

            {books.map(book =>(
                <BookElement 
                key={book.id}
                id = {book.id}
                title = {book.title}
                author = {book.author}
                year = {book.year}
                isbn13 = {book.isbn13}
                />       
            ))}
        </div>

    </div>
  )
}
