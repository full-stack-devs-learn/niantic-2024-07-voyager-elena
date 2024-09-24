import Button from 'react-bootstrap/Button'

const NavigationButtons = ({ page, handlePrevious, handleNext }) => {
  return (
    <div className="btns-container">
      <Button variant="primary" onClick={handlePrevious} disabled={page === 1}>Previous</Button>
      <span> Current Page {page} </span>
      <Button variant="primary" onClick={handleNext}>Next</Button>
    </div>
  )
}

export default NavigationButtons