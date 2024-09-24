import './EmployeeCard.css'

export default function CategoryCard({ id, employeeFullName, employeeTitle, handleEmployeeSelected }) {
  const imageUrl = `images/employees/${id}.webp`

  const employeeClicked = () => {
    handleEmployeeSelected(id)
  }

  return (
    <div className="employee-card" onClick={employeeClicked}>
      <img className="employee-image" src={imageUrl} alt={`${employeeFullName} photo`} />
      <div className="employee-name">
        <h1>{employeeFullName}</h1>
        <h6>{employeeTitle}</h6>
      </div>
    </div>
  )
}