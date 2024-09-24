const PokemonCard = ({ pokemon }) => {
  return (
    <div className="card">
      <h3 className="card-title">{pokemon.name}</h3>
      <img className="card_img" src={pokemon.image} alt={`${pokemon.name} image`}/>
    </div>
  );
};

export default PokemonCard;