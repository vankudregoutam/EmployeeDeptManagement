import axios from 'axios';
import React, { useEffect, useState } from 'react'
import styles from '../../css/Fetch.module.css'
import { useNavigate } from 'react-router-dom';

const FetchAllDept = () => {

    let [departments, setDepartments] = useState([]);

    let navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8081/dept/fetchAll")
        .then(res => setDepartments(res.data.data))
    }, [])

    let handleUpdate = (id) => () => {
      navigate(`/dept/updateById/${id}`);
    }

    let handleDelete = (id) => async () => {
      if (window.confirm("Are you sure you want to delete this department?")) {
        try {
          await axios.delete(`http://localhost:8081/dept/deleteById/${id}`);
          setDepartments(departments.filter(dept => dept.depno !== id));
          alert("Department deleted successfully");
        } catch (err) {
          console.error("Error deleting department:", err);
          alert("Failed to delete department");
        }
      }
    }

  return (
    <>
      <h2 className={styles.heading}>Department List</h2>
      <table className={styles.table} border={1} cellPadding={8} cellSpacing={0}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {departments.map(dept => (
            <tr key={dept.depno}>
              <td>{dept.depno}</td>
              <td>{dept.name}</td>
              <td>{dept.loc}</td>
              <td><button className={styles.updateBtn} onClick={handleUpdate(dept.depno)} >Update</button></td>
              <td><button className={styles.deleteBtn} onClick={handleDelete(dept.depno)} >Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default FetchAllDept
