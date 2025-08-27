import React, { useState } from 'react'
import styles from '../../css/Form.module.css'
import table from '../../css/Fetch.module.css'
import axios from 'axios'

const FindByIdDept = () => {

  let [credentials, setCredentials] = useState({ depno: "", name: "", loc: "" })
  let [id, setId] = useState("");
  let [searched, setSearched] = useState(false);

  let handleChange = (e) => {
    setId(e.target.value);
  }

  let handleSubmit = async (e) => {
    e.preventDefault();
    setSearched(true);
    axios.get(`http://localhost:8081/dept/findById/${id}`)
      .then((res) => {
        setCredentials(res.data.data || {});
      })
      .catch((err) => { 
        console.log(err);
        setCredentials({});
      });
  }

  return (
    <>
      <form className={styles.form} method='post' onSubmit={handleSubmit}>
        <input type="text" name='id' placeholder='Dept Id' onChange={handleChange} required autoComplete='off' />
        <input type="submit" value="Find Dept" />
      </form>

      <br /><br /><br />

      {searched && (
        credentials.depno ? (
          <table className={table.table} border={1} cellPadding={10} cellSpacing={0}>
            <thead>
              <tr>
                <th>Dept No</th>
                <th>Dept Name</th>
                <th>Dept Location</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{credentials.depno}</td>
                <td>{credentials.name}</td>
                <td>{credentials.loc}</td>
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

export default FindByIdDept
