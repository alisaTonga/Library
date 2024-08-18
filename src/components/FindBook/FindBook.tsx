import React, { useEffect, useState } from 'react'
import { IBook } from '../library/MyLibrary'
import { useParams } from 'react-router-dom'


const initialBook: IBook = {
    id: 0,
    title: '',
    author: '',
    year: 0,
    isbn13: ''
}
export default function FindBook() {
    const {id} = useParams();
    const [book, setBook] = useState<IBook>(initialBook);
    const [loading, setLoading] =useState<boolean>(false);



  return (
    <div>FindBook</div>
  )
}
