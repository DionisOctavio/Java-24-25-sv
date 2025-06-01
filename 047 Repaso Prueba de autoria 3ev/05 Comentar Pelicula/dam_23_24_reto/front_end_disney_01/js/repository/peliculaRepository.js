import { FetchUtil } from "../util/fetchUtil.js";

export class PeliculasRepository {

    static PELICULA_FIND_ALL = 'ACTION=PELICULA.FIND_ALL';

    static async findAll() {
        try {
            const url = `${FetchUtil.BASE_URL}${this.PELICULA_FIND_ALL}`;
            const response = await fetch(url);

            console.log("URL:", url);
            console.log("Response:", response);

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