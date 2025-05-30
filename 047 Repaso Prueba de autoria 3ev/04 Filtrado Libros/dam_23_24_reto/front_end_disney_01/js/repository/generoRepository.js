import { FetchUtil } from "../util/fetchUtil.js";

export class GeneroRepository {
  static GENERO_FIND_ALL = "ACTION=GENERO.FIND_ALL";


  static async find() {
    try {
      const response = await fetch(`${FetchUtil.BASE_URL}${this.GENERO_FIND_ALL}`);
      if (!response.ok) {
        throw new Error("Error al obtener las películas");
      }
      return await response.json();
    } catch (error) {
      console.error(error);
      return [];
    }
  }
}
