import axios from 'axios'

const baseUrl = 'https://pokeapi.co/api/v2/pokemon'

class PokemonService {

  async getData(page) {
    const offset = (page - 1) * 20;

    try {
      const response = await axios.get(`${baseUrl}?offset=${offset}&limit=20`);
      const results = response.data.results.map(pokemon => ({
        name: pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1),
        url: pokemon.url
      }));
      return { results, count: response.data.count };
    } catch (error) {
      console.error('Error fetching the pokemon data:', error);
      throw error;
    }
  }

  async getPokemonDetails(url) {
    try {
      const response = await axios.get(url);
      const { sprites, species, types, abilities } = response.data;
      return {
        image: sprites.front_default,
        species: species.name,
        type: types.map(typeInfo => typeInfo.type.name).join(', '),
        abilities: abilities.map(abilityInfo => abilityInfo.ability.name).join(', ')
      };
    } catch (error) {
      console.error('Error fetching the pokemon details:', error);
      throw error;
    }
  }
}

export default new PokemonService();