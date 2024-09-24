
import { useEffect, useState } from 'react'
import PokemonService from './services/pokemon-service'
import './App.css'
import CardsContainer from './components/CardsContainer'
import NavigationButtons from './components/NavigationButtons'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootswatch/dist/materia/bootstrap.min.css'

function App() {
  const [pokemons, setPokemons] = useState([])
  const [isLoading, setIsLoading] = useState(true)
  const [page, setPage] = useState(1)
  const [totalPages, setTotalPages] = useState(0)

  const fetchPokemons = async (page) => {
    setIsLoading(true)
    try {
      const data = await PokemonService.getData(page)
      const detailedPokemons = []

      for (const pokemon of data.results) {
        const details = await PokemonService.getPokemonDetails(pokemon.url)
        detailedPokemons.push({ ...pokemon, ...details })
      }

      setPokemons(detailedPokemons)
      setTotalPages(Math.ceil(data.count / 20))
    } catch (error) {
      console.error('Error fetching the pokemon data:', error)
    } finally {
      setIsLoading(false);
    }
  }

  useEffect(() => {
    fetchPokemons(page);
  }, [page]);

  const handlePrevious = () => {
    if (page > 1) {
      setPage(page - 1);
    }
  }

  const handleNext = () => {
    setPage(page + 1);
  }

  const handleFirst = () => {
    setPage(1);
  }

  const handleLast = () => {
    setPage(totalPages);
  }

  return (
    <>
      <h1 className="text-primary">Pokemon API</h1>
      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <>
          <NavigationButtons
            page={page}
            handlePrevious={handlePrevious}
            handleNext={handleNext}
            handleFirst={handleFirst}
            handleLast={handleLast}
            totalPages={totalPages}
          />
          <CardsContainer pokemons={pokemons} />
          <NavigationButtons
            page={page}
            handlePrevious={handlePrevious}
            handleNext={handleNext}
            handleFirst={handleFirst}
            handleLast={handleLast}
            totalPages={totalPages}
          />
        </>
      )}
    </>
  )
}

export default App
