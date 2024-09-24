import { useState } from 'react'
import EmployeeCard from '../employee-card/EmployeeCard'
import EmployeeDetails from '../employee-details/EmployeeDetails'
import './EmployeeCardsContainer.css'
import employees from '../../../data'

const EmployeeCardsContainer = () => {
  const [selectedEmployee, setSelectedEmployee] = useState({})
  const [managerName, setManagerName] = useState('')
  const [showEmployeeDetails, setShowEmployeeDetails] = useState(false)


  const handleEmployeeSelected = (id) => {
    const employee = employees.find(emp => emp.employeeId === id)
    console.log("Selected person = ", employee)
    setSelectedEmployee(employee)
    if (employee.managerId > 0) {
      const manager = employees.find(emp => emp.employeeId === employee.managerId)
      setManagerName(manager.firstName + ' ' + manager.lastName)
    } else {
      setManagerName('')
    }
    setShowEmployeeDetails(true)
  }

  const handleCloseDetails = () => setShowEmployeeDetails(false);

  return (
    <>
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
      {showEmployeeDetails &&
        <EmployeeDetails
          show={showEmployeeDetails}
          close={handleCloseDetails}
          employee={selectedEmployee}
          manager={managerName}
        />
      }
    </>
  )
}

export default EmployeeCardsContainer