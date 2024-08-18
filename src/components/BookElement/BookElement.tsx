import React from 'react'
import styles from './bookElement.module.css'
import { IBook } from '../library/MyLibrary'
import { Link } from 'react-router-dom'
import MyButton from '../myButton/myButton'


export default function BookElement({id,
        title,
        author,
        year,
        isbn13} :IBook) {
    

  return (
    <div key={id} className={styles.card}>
        <h5 className={styles.title}>{title}</h5>
        <p className={styles.author}>Author: <br />
        {author}</p>
        <p className={styles.year}>Year of publishing: {year}</p>
        <p className={styles.isbn}>ISBN13: {isbn13}</p>
    </div>
  )
}
