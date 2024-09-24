import axios from 'axios'

const baseUrl = 'https://pokeapi.co/api/v2/pokemon'

class PokemonService {

  async getData(page) {
    const offset = (page - 1) * 20;

    try {
      const response = await axios.get(`${baseUrl}?offset=${offset}&limit=20`);
      return response.data;
    } catch (error) {
      console.error('Error fetching the pokemon data:', error);
      throw error;
    }
  }
}

export default new PokemonService();