import { useState } from 'react'
import EmployeeCard from '../employee-card/EmployeeCard'
import Modal from 'react-bootstrap/Modal';
import './EmployeeCardsContainer.css'
import employees from '../../../data'

const EmployeeCardsContainer = () => {
  const [selectedEmployeeId, setSelectedEmployeeId] = useState(0)
  const [selectedEmployee, setSelectedEmployee] = useState({})
  const [showEmployeeDetails, setShowEmployeeDetails] = useState(false)


  const handleEmployeeSelected = (id) => {
    setSelectedEmployeeId(id)
    setSelectedEmployee(employees.find(emp => emp.employeeId === id))
    setShowEmployeeDetails(true)
  }

  const handleCloseDetails = () => setShowEmployeeDetails(false);

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

      <Modal show={showEmployeeDetails} onHide={handleCloseDetails}>
        <Modal.Header closeButton>
          <Modal.Title>{selectedEmployee.firstName + ' ' + selectedEmployee.lastName}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          More details about this person
        </Modal.Body>
      </Modal>
    </>
  )
}

export default EmployeeCardsContainer

