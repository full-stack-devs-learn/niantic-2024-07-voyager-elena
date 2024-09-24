import PropTypes from 'prop-types'
import PokemonCard from './PokemonCard'

const CardsContainer = ({ pokemons }) => {
  return (
    <div className="cards-container">
      {pokemons.map((pokemon) => (
        <PokemonCard key={pokemon.name} pokemon={pokemon} />
      ))}
    </div>
  )
}

CardsContainer.propTypes = {
  pokemons: PropTypes.arrayOf(PropTypes.object).isRequired
}

export default CardsContainer