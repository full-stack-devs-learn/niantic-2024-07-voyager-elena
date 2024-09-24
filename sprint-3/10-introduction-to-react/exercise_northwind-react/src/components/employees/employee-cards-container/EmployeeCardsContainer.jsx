import { useState } from 'react'
import EmployeeCard from '../employee-card/EmployeeCard'
import './EmployeeCardsContainer.css'
import employees from '../../../data'

const EmployeeCardsContainer = () => {
  const [selectedEmployeeId, setSelectedEmployeeId] = useState(0);

  const handleEmployeeSelected = (id) => {
    setSelectedEmployeeId(id)
  }

  return (
    <>
      <h5 className="container">Selected Employee Id: {selectedEmployeeId}</h5>
      <main className="container mt-4 employees-container" id="employees-container">
        {
          employees.map((employee) => (
            <EmployeeCard key={employee.employeeId}
              id={employee.employeeId}
              employeeFullName={employee.firstName + ' ' + employee.lastName}
              employeeTitle={employee.title}
              handleEmployeeSelected={handleEmployeeSelected}
            ></EmployeeCard>
          ))
        }
      </main>
    </>
  )
}

export default EmployeeCardsContainer

