import axios from 'axios'
import React, { useEffect, useState } from 'react'
import styles from '../../css/Fetch.module.css'
import { useNavigate } from 'react-router-dom';

const FetchAllEmp = () => {

  const [employees, setEmployees] = useState([]);
  let navigate = useNavigate();

  useEffect(() => {
    axios.get("http://localhost:8081/emp/fetchAll")
      .then(res => setEmployees(res.data.data))
      .catch(err => console.error("Error fetching employees:", err));
  }, []);

  let handleDelete = (id) => async () => {
    if (window.confirm("Are you sure you want to delete this employee?")) {
      try {
        await axios.delete(`http://localhost:8081/emp/deleteById/${id}`);
        setEmployees(employees.filter(emp => emp.id !== id));
        alert("Employee deleted successfully");
      } catch (err) {
        console.error("Error deleting employee:", err);
        alert("Failed to delete employee");
      }
    }
  }

  return (
    <>
      <h2 className={styles.heading}>Employee List</h2>
      <table className={styles.table} border="1" cellPadding="8" cellSpacing={0}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Com</th>
            <th>DeptNo</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(emp => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.name}</td>
              <td>{emp.sal}</td>
              <td>{emp.com}</td>
              <td>{emp.deptno??"N/A"}</td>
              <td><button className={styles.updateBtn} onClick={()=>navigate(`/emp/updateById/${emp.id}`)}>Update</button></td>
              <td><button className={styles.deleteBtn} onClick={handleDelete(emp.id)} >Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default FetchAllEmp
