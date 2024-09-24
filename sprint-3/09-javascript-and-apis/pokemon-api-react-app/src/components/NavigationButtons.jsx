import PropTypes from 'prop-types'
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

NavigationButtons.propTypes = {
  page: PropTypes.number.isRequired,
  handlePrevious: PropTypes.func.isRequired,
  handleNext: PropTypes.func.isRequired,
  handleFirst: PropTypes.func.isRequired,
  handleLast: PropTypes.func.isRequired,
  totalPages: PropTypes.number.isRequired,
}

export default NavigationButtons