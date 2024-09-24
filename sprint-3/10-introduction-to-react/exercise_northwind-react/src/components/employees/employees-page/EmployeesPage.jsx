import EmployeeCardsContainer from '../employee-cards-container/EmployeeCardsContainer'
import './EmployeesPage.css'

const EmployeesPage = () => {
  return (
    <>
      <header className="container mt-4">
        <h1>Employees</h1>
      </header>
      <EmployeeCardsContainer />
    </>
  )
}

export default EmployeesPage

