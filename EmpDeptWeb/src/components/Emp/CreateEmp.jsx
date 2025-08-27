import axios from 'axios'
import React, { useEffect, useState } from 'react'
import styles from '../../css/Form.module.css'

const CreateEmp = () => {

  let [credentials, setCredentials] = useState({ name: "", sal: "", com: "", dept: '' })

  let [departments, setDepartments] = useState([])

  let handleChange = (e) => {
    setCredentials({...credentials, [e.target.name]: e.target.value})
  }

  let handleSubmit = async (e) => {
    e.preventDefault();
    let res = await axios.post("http://localhost:8081/emp/save", credentials)
    .then(alert("Employee Created Successfully"))
    .catch((err) => { console.log(err) });
    console.log(res.data);
  }

  useEffect(() => {
    axios.get("http://localhost:8081/dept/fetchAll").then((res) => {
      setDepartments(res.data.data);
    })
    .catch((err) => { console.log(err) })
  },[])

  return (
    <>
      <form className={styles.form} method="post" onSubmit={handleSubmit} >
        <input type="text" name='name' value={credentials.name} onChange={handleChange} placeholder='Emp Name' required autoComplete='off' />
        <input type="text" name='sal' value={credentials.sal} onChange={handleChange} placeholder='Emp Sal' required autoComplete='off' />
        <input type="text" name='com' value={credentials.com} onChange={handleChange} placeholder='Comission' autoComplete='off' />
        <select name="deptno" value={credentials.deptno} onChange={handleChange} autoComplete='off' >
          <option value="">Select Department</option>
          {departments.map((dept) => (
            <option key={dept.depno} value={dept.depno}>
              {dept.depno} - {dept.name}
            </option>
          ))}
        </select>
        <input type="submit" value="Create Employee" />
      </form>
    </>
  )
}

export default CreateEmp
