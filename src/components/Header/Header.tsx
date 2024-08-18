import styles from "./header.module.css";
import { Link, NavLink, useLocation } from "react-router-dom";
import { useAppDispatch, useAppSelector } from "../../redux/hooks";
import { logoutUser } from "../../features/auth/authSlice";
import { clearBooks } from "../../features/books/booksSlice";

export default function Header() {
  const dispatch = useAppDispatch();
  const location = useLocation();
  console.log(location.pathname);
  const handleLogout = () => {
    localStorage.removeItem("userToken");
    dispatch(logoutUser());
    dispatch(clearBooks());
  };
  const { user } = useAppSelector((state) => state.user);
  interface ILink {
    path: string;
    label: string;
  }

  const navItems: ILink[] = [
    // {path: '/singUp', label: 'Sing up'},
    { path: "/add-book", label: "Add / Update" },
    { path: "/", label: "My library" },
    { path: "/find-book", label: "Find / Delete" },
    // { path: "/delete-book", label: "Delete book" },
  ];
  return (
    <header className={styles.header}>
      {user.username && <span>{user.username}</span>}
      {user.username ? (
        <>
          {navItems.map((item, index) => (
            <Link
              key={index}
              className={location.pathname === item.path ? styles.active : ""}
              to={item.path}
            >
              {item.label}
            </Link>
          ))}
          <Link to="/login" onClick={handleLogout}>
            Logout
          </Link>
        </>
      ) : (
        <div className={styles.withoutLogging}>
          <Link className={styles.noLogging} to="/login">
            Login
          </Link>
          {/* <Link className={styles.noLogging} to='/singUp'>Sing up</Link> */}
        </div>
      )}
    </header>
  );
}
