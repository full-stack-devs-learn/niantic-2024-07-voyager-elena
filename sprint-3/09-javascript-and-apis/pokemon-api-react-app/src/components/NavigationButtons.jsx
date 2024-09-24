import Button from 'react-bootstrap/Button'

const NavigationButtons = ({ page, handlePrevious, handleNext, handleFirst, handleLast, totalPages }) => {
  return (
    <div className="btns-container">
      <Button variant="primary" onClick={handleFirst} disabled={page === 1}>First</Button>
      <Button variant="primary" onClick={handlePrevious} disabled={page === 1}>Previous</Button>
      <div> Current Page <span>{page}</span> </div>
      <Button variant="primary" onClick={handleNext} disabled={page === totalPages}>Next</Button>
      <Button variant="primary" onClick={handleLast} disabled={page === totalPages}>Last</Button>
    </div>
  )
}

export default NavigationButtons