import { FetchUtil } from "../util/fetchUtil.js";

export class LibroRepository {
  static LIBRO_FIND_ALL = "ACTION=LIBRO.FIND_ALL";
  static LIBRO_FIND_BY_GENERO = "ACTION=LIBRO.FIND_BY_GENERO";


  static async find() {
    try {
      const response = await fetch(`${FetchUtil.BASE_URL}${this.LIBRO_FIND_ALL}`);
      if (!response.ok) {
        throw new Error("Error al obtener las películas");
      }
      return await response.json();
    } catch (error) {
      console.error(error);
      return [];
    }
  }


  static async findByGenero(genero) {
    try {
      const response = await fetch(`${FetchUtil.BASE_URL}${this.LIBRO_FIND_BY_GENERO}&GENERO=${genero}`);
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
