import Modal from 'react-bootstrap/Modal'
import PropTypes from 'prop-types'
import './EmployeeDetails.css'

const EmployeeDetails = ({ employee, manager, show, close }) => {
  const imageUrl = `images/employees/${employee.employeeId}.webp`
  const fullName = employee.firstName + ' ' + employee.lastName;

  return (
    <Modal
      show={show}
      onHide={close}
      size="lg"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title>{`${fullName} (Employee ID = ${employee.employeeId})`}</Modal.Title>
      </Modal.Header>
      <Modal.Body className="employee-details-body">
        <img className="employee-details-image" src={imageUrl} alt={`${fullName} photo`} />
        <div className="employee-details-container">
          <p><strong>First Name:</strong> {employee.firstName}</p>
          <p><strong>Last Name:</strong> {employee.lastName}</p>
          <p><strong>Title:</strong> {employee.title}</p>
          <p><strong>Title of Courtesy:</strong> {employee.titleOfCourtesy}</p>
          <p><strong>Birth Date:</strong> {new Date(employee.birthDate).toLocaleDateString()}</p>
          <p><strong>Hire Date:</strong> {new Date(employee.hireDate).toLocaleDateString()}</p>
          <p><strong>Address:</strong> {employee.address}</p>
          <p><strong>City:</strong> {employee.city}</p>
          <p><strong>State:</strong> {employee.state || 'N/A'}</p>
          <p><strong>Zip Code:</strong> {employee.zipCode}</p>
          <p><strong>Country:</strong> {employee.country}</p>
          <p><strong>Phone:</strong> {employee.phone}</p>
          <p><strong>Extension:</strong> {employee.extension}</p>
          <p><strong>Notes:</strong> {employee.notes || 'Not available'}</p>
          <p><strong>Salary:</strong> ${employee.salary.toFixed(2)}</p>
          {manager &&
            <>
              <p><strong>Manager:</strong> {manager}</p>
              <p><strong>Manager ID:</strong> {employee.managerId}</p>
            </>
          }
        </div>
      </Modal.Body>
    </Modal>
  )
}

EmployeeDetails.propTypes = {
  employee: PropTypes.shape({
    employeeId: PropTypes.number.isRequired,
    lastName: PropTypes.string.isRequired,
    firstName: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    titleOfCourtesy: PropTypes.string.isRequired,
    birthDate: PropTypes.string.isRequired,
    hireDate: PropTypes.string.isRequired,
    address: PropTypes.string.isRequired,
    city: PropTypes.string.isRequired,
    state: PropTypes.string,
    zipCode: PropTypes.string.isRequired,
    country: PropTypes.string.isRequired,
    phone: PropTypes.string.isRequired,
    extension: PropTypes.string.isRequired,
    notes: PropTypes.string.isRequired,
    salary: PropTypes.number.isRequired,
    managerId: PropTypes.number.isRequired,
  }).isRequired,
  manager: PropTypes.string,
  show: PropTypes.bool.isRequired,
  close: PropTypes.func.isRequired
}


export default EmployeeDetails