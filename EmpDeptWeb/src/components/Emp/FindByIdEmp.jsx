import React, { useState } from 'react'
import styles from '../../css/Form.module.css'
import table from '../../css/Fetch.module.css'
import axios from 'axios'

const FindByIdEmp = () => {
  let [credentials, setCredentials] = useState({ id: "", name: "", sal: "", com: "", deptno: "" })
  let [id, setId] = useState("");
  let [submitted, setSubmitted] = useState(false);

  let handleSubmit = async (e) => {
    e.preventDefault();
    setSubmitted(true);
    try {
      let res = await axios.get(`http://localhost:8081/emp/findById/${id}`);
      setCredentials(res.data.data || {});
    } catch (err) {
      console.log(err);
      setCredentials({});
    }
  }

  return (
    <>
      <form className={styles.form} method='post' onSubmit={handleSubmit}>
        <input type="text" name='id' placeholder='Emp Id' onChange={e=>setId(e.target.value)} value={id}required autoComplete='off' />
        <input type="submit" value="Find Emp" />
      </form>

      <br /><br /><br />

      {submitted && (
        credentials && credentials.id ? (
          <table className={table.table} border={1} cellPadding={10} cellSpacing={0}>
            <thead>
              <tr>
                <th>Emp Id</th>
                <th>Emp Name</th>
                <th>Emp Sal</th>
                <th>Comission</th>
                <th>Dept No</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{credentials.id}</td>
                <td>{credentials.name}</td>
                <td>{credentials.sal}</td>
                <td>{credentials.com}</td>
                <td>{credentials.deptno}</td>
              </tr>
            </tbody>
          </table>
        ) : (
          <h3 className={table.result}>No Data Found</h3>
        )
      )}
    </>
  )
}

export default FindByIdEmp
