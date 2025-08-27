import React, { useState } from 'react'
import axios from 'axios'
import styles from '../../css/Form.module.css'

const CreateDept = () => {
  let [credentials, setCredentials] = useState({ name: "", loc: "" })

  let handleChange = (e) => {
    setCredentials({...credentials, [e.target.name]: e.target.value})
  }

  let handleSubmit = async (e) => {
    e.preventDefault();

    try {
      let res = await axios.post("http://localhost:8081/dept/save", credentials);

      if (res.data && res.data.statusCode === 200) {
        alert("Department Created Successfully");
      } else {
        alert(res.data.message || "Something went wrong");
      }
    } catch (err) {
      if (err.response && err.response.statusCode === 502) {
        alert("Department already exists!");
      } else {
        console.log(err);
        alert("Failed to create department. Please try again.");
      }
    }
  };

  return (
    <>
      <form className={styles.form} method="post" onSubmit={handleSubmit} >
        <input type="text" name='name' value={credentials.name} onChange={handleChange} placeholder='Dept Name' required autoComplete='off' />
        <input type="text" name='loc' value={credentials.loc} onChange={handleChange} placeholder='Dept Loc' required autoComplete='off' />
        <input type="submit" value="Create Department" />
      </form>
    </>
  )

}

export default CreateDept
