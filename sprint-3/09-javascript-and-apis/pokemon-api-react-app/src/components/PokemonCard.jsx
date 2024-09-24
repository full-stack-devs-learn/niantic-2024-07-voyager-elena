import PropTypes from 'prop-types'

const PokemonCard = ({ pokemon }) => {
  return (
    <div className="card">
      <h3 className="card-title">{pokemon.name}</h3>
      {pokemon.image && (
        <img className="card_img" src={pokemon.image} alt={`${pokemon.name} image`} />
      )}
      <div className="card-details">
        {/* <div>Species:&nbsp;<span>{pokemon.species}</span></div> */}
        <div><span className="details-title">Type</span>:&nbsp;<span>{pokemon.type}</span></div>
        <div><span className="details-title">Abilities:</span>&nbsp;<span>{pokemon.abilities}</span></div>
      </div>
    </div>
  )
}

PokemonCard.propTypes = {
  pokemon: PropTypes.object.isRequired
}

export default PokemonCard