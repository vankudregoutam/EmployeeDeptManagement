import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import styles from '../../css/Form.module.css'

const UpdateByIdDept = () => {

    let [credentials, setCredentials] = useState({ depno: "", name: "", loc: "" })
    let navigate = useNavigate();
    let { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8081/dept/findById/${id}`)
        .then(res => setCredentials(res.data.data))
    }, [])

    let handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value })
    }

    let handleSubmit = async (e) => {
        e.preventDefault();

        try {
            let res = await axios.put(`http://localhost:8081/dept/updateById/${credentials.depno}`,credentials);

            if (res.data && res.data.statusCode === 200) {
            alert("Department Updated Successfully");
            } else {
            alert(res.data.message || "Update failed");
            }

            navigate("/dept/fetchAll");
        } catch (err) {
            console.error(err);
            if (err.response && err.response.status === 404) {
            alert("Department not found!");
            } else {
            alert("Failed to update department. Please try again.");
            }
        }
    };

  return (
    <>
        <form className={styles.form} method="post" onSubmit={handleSubmit} >
            <input type="text" name='depno' value={credentials.depno} onChange={handleChange} placeholder='Dept Id' disabled />
            <input type="text" name='name' value={credentials.name} onChange={handleChange} placeholder='Dept Name' autoComplete='off' />
            <input type="text" name='loc' value={credentials.loc} onChange={handleChange} placeholder='Dept Loc' autoComplete='off' />
            <button type='submit' className={styles.update}>Update</button>
            <button type='button' className={styles.cancel} onClick={()=>navigate('/dept/fetchAll')}>Cancel</button>
        </form>
    </>
  )
}

export default UpdateByIdDept
