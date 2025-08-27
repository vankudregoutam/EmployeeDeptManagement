import React from 'react'
import NavBar from './components/NavBar'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import CreateEmp from './components/Emp/CreateEmp'
import FetchAllDept from './components/Dept/FetchAllDept.jsx'
import CreateDept from './components/Dept/CreateDept.jsx'
import FetchAllEmp from './components/Emp/FetchAllEmp.jsx'
import UpdateByIdDept from './components/Dept/UpdateByIdDept.jsx'
import UpdateByIdEmp from './components/Emp/UpdateByIdEmp.jsx'
import FindByIdDept from './components/Dept/FindByIdDept.jsx'
import FindByIdEmp from './components/Emp/FindByIdEmp.jsx'

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<NavBar />}>
            {/* Emp Routes */}
            <Route path='emp/save' element={<CreateEmp />} />
            <Route path='emp/findById' element={<FindByIdEmp />} />
            <Route path='emp/fetchAll' element={<FetchAllEmp />} />
            <Route path='emp/updateById/:id' element={<UpdateByIdEmp />} />
            {/* Dept Routes */}
            <Route path='dept/save' element={<CreateDept />} />
            <Route path='dept/findById' element={<FindByIdDept />} />
            <Route path='dept/fetchAll' element={<FetchAllDept />} />
            <Route path='dept/updateById/:id' element={<UpdateByIdDept />} />
          </Route>
        </Routes>      
      </BrowserRouter>
    </>
  )
}

export default App
