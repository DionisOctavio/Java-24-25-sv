import { fetchUtil } from "../util/fetchUtil.js";

export class CategoriaRepository {

    static CATEGORIA_FIND_ALL = "ACTION=CATEGORIA.FIND_ALL";

  static async findAll() {
        try {
            const url = `${fetchUtil.URL}${this.CATEGORIA_FIND_ALL}`;
            const response = await fetch(url);

            if (!response.ok) {
                throw new Error('NOT FOUND');
            }

            return await response.json();
        } catch (error) {
            console.error("HA habido un error", error);
            return [];
        }
    }

}