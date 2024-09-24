
import { useEffect, useState } from 'react'
import PokemonService from './services/pokemon-service'
import './App.css'
import Button from 'react-bootstrap/Button'
import CardsContainer from './components/CardsContainer'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootswatch/dist/materia/bootstrap.min.css'

function App() {
  const [pokemons, setPokemons] = useState([])
  const [isLoading, setIsLoading] = useState(true)
  const [page, setPage] = useState(1)

  const fetchPokemons = async (page) => {
    setIsLoading(true);
    try {
      const data = await PokemonService.getData(page);
      const detailedPokemons = [];

      for (const pokemon of data.results) {
        const details = await PokemonService.getPokemonDetails(pokemon.url);
        detailedPokemons.push({ ...pokemon, ...details });
      }

      setPokemons(detailedPokemons);
    } catch (error) {
      console.error('Error fetching the pokemon data:', error);
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchPokemons(page);
  }, [page]);

  const handlePrevious = () => {
    if (page > 1) {
      setPage(page - 1);
    }
  };

  const handleNext = () => {
    setPage(page + 1);
  };

  return (
    <>
      <h1 className="text-primary">Pokemon API</h1>
      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <>
         <CardsContainer pokemons={pokemons} />
          <Button variant="primary" onClick={handlePrevious} disabled={page === 1}>Previous</Button>
          <span> Current Page {page} </span>
          <Button variant="primary" onClick={handleNext}>Next</Button>
        </>
      )}
    </>
  )
}

export default App
