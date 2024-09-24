import PokemonCard from './PokemonCard'

const CardsContainer = ({ pokemons }) => {
  return (
    <div className="cards-container">
      {pokemons.map((pokemon) => (
        <PokemonCard key={pokemon.name} pokemon={pokemon} />
      ))}
    </div>
  );
};

export default CardsContainer;