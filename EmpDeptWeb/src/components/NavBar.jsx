import React from 'react'
import styles from '../css/NavBar.module.css'
import { Link, Outlet } from 'react-router-dom'

const NavBar = () => {
  return (
    <>
      <h2 className={styles.heading}>Emp Dept App</h2>
      <section className={styles.parent}>
        <aside className={styles.leftSide}>
            <ol className={styles.menu}>
                <li><Link to='/emp/save'>Create Employee</Link></li>
                <li><Link to='/emp/findById'>Find By ID</Link></li>
                <li><Link to='/emp/fetchAll'>Fetch All Employees</Link></li>
                <hr />
                <li><Link to='/dept/save'>Create Department</Link></li>
                <li><Link to='/dept/findById'>Find Dept By ID</Link></li>
                <li><Link to='/dept/fetchAll'>Fetch All Departments</Link></li>
            </ol>
        </aside>
        <aside className={styles.rightSide}>
            <Outlet />
        </aside>
      </section>
    </>
  )
}

export default NavBar
