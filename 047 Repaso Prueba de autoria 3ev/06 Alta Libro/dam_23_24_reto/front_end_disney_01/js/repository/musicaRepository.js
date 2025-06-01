import { FetchUtil } from "../util/fetchUtil.js";

export class MusicRepository {
  static MUSIC_FIND = "ACTION=MUSICA.FIND";
  static MUSIC_ADD = "ACTION=MUSICA.ADD";

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

  static async add(nombre) {
    try {
      const params = new URLSearchParams({
        NOMBRE: nombre
      });

      const url = `${FetchUtil.BASE_URL}${this.MUSIC_ADD}&${params.toString()}`;
      const response = await fetch(url);

      if (!response.ok) {
        throw new Error("Error al añadir la canción");
      }

      return await response.json();
    } catch (error) {
      console.error("Error al añadir canción:", error);
      return { success: false, message: error.message };
    }
  }
}
