import { FetchUtil } from "../util/fetchUtil.js";

export class MusicRepository {
  static MUSIC = "ACTION=MUSICA.SEARCH";
  static MUSIC_FIND = "ACTION=MUSICA.FIND";

  static async findByTitle(search) {
    try {
      const response = await fetch(`${FetchUtil.BASE_URL}${this.MUSIC}&SEARCH=${search}`);
      if (!response.ok) {
        throw new Error("Error al obtener las películas");
      }
      return await response.json();
    } catch (error) {
      console.error(error);
      return [];
    }
  }

  static async find() {
    try {
      const response = await fetch(`${FetchUtil.BASE_URL}${this.MUSIC_FIND}`);
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
