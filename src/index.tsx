import ReactDOM from 'react-dom/client';
import './index.css';
import { HashRouter, Route, Routes } from 'react-router-dom';
import Layout from './components/layout/Layout';
import LoginForm from './components/loginForm/LoginForm';
import { Provider } from 'react-redux';
import { store } from './redux/store';
import Login from './components/login/Login';
import ProtectedRoute from './components/protectedRoute/ProtectedRoute';
import MyLibrary from './components/library/MyLibrary';
import BookForm from './components/BookForm/BookForm';
import FindBook from './components/FindBook/FindBook';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <Provider store={store}>
  <HashRouter>
    <Routes>
      <Route path='/' element={<Layout />} >
        <Route path='/' element={<ProtectedRoute outlet={<MyLibrary/>}/>} />
        <Route path='add-book' element={<ProtectedRoute outlet={<BookForm/>}/>} />
        <Route path='find-book' element={<ProtectedRoute outlet={<FindBook/>}/>} />
        <Route path='/login' element={<Login/>}/>
        {/* <Route path='/singUp' element={<LoginForm/>} /> */}
        <Route path='*' element={<h1>Error 404</h1>}/>

      </Route>
    </Routes>
  </HashRouter>
  </Provider>
);

