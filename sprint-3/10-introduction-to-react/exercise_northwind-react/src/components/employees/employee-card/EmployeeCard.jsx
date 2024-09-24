import PropTypes from 'prop-types';
import './EmployeeCard.css'

const EmployeeCard = ({ id, employeeFullName, employeeTitle, handleEmployeeSelected }) => {
  const imageUrl = `images/employees/${id}.webp`

  return (
    <div className="employee-card" onClick={() => handleEmployeeSelected(id)}>
      <img className="employee-image" src={imageUrl} alt={`${employeeFullName} photo`} />
      <div className="employee-name">
        <h1>{employeeFullName}</h1>
        <h6>{employeeTitle}</h6>
      </div>
    </div>
  )
}

EmployeeCard.propTypes = {
  id: PropTypes.number.isRequired,
  employeeFullName: PropTypes.string.isRequired,
  employeeTitle: PropTypes.string.isRequired,
  handleEmployeeSelected: PropTypes.func.isRequired,
}

export default EmployeeCard

