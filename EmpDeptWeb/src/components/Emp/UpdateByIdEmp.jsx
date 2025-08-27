import React, { useEffect, useState } from 'react'
import styles from '../../css/form.module.css'
import axios from 'axios'
import { useNavigate, useParams } from 'react-router-dom'

const UpdateByIdEmp = () => {

  let [credentials, setCredentials] = useState({id: "",name: "", sal: "", com: "", dept: ''})
  let navigate = useNavigate();
  let { id } = useParams();
  let [departments, setDepartments] = useState([])

  let handleChange = (e) => {
    setCredentials({...credentials, [e.target.name]: e.target.value})
  }

  useEffect(() => {
        axios.get(`http://localhost:8081/emp/findById/${id}`)
        .then(res => setCredentials(res.data.data))
  }, [])

  useEffect(() => {
    axios.get("http://localhost:8081/dept/fetchAll").then((res) => {
      setDepartments(res.data.data);
    })
    .catch((err) => { console.log(err) })
  },[])

  let handleSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8081/emp/updateById/${credentials.id}`, credentials);
    navigate('/emp/fetchAll');
    alert("Employee Updated Successfully");
  }

  return (
    <div>
      <form className={styles.form} method="post" onSubmit={handleSubmit} >
        <input type="text" name='id' value={credentials.id} onChange={handleChange} placeholder='Emp Id' disabled />
        <input type="text" name='name' value={credentials.name} onChange={handleChange} placeholder='Emp Name' />
        <input type="text" name='sal' value={credentials.sal} onChange={handleChange} placeholder='Emp Sal' />
        <input type="text" name='com' value={credentials.com} onChange={handleChange} placeholder='Comission' />
        <select name="deptno" value={credentials.deptno} onChange={handleChange} autoComplete='off' >
          <option value="">Select Department</option>
          {departments.map((dept) => (
            <option key={dept.depno} value={dept.depno}>
              {dept.depno} - {dept.name}
            </option>
          ))}
        </select>
        <button type='submit' className={styles.update}>Update</button>
        <button type='button' className={styles.cancel} onClick={()=>navigate('/emp/fetchAll')}>Cancel</button>
      </form>
    </div>
  )
}

export default UpdateByIdEmp
