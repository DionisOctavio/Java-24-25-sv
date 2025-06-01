import { fetchUtil } from "../util/fetchUtil.js";

export class PeliculasRepository {

    static PELICULA_FIND_ALL = 'ACTION=PELICULA.FIND_ALL';
    static PELICULA_FIND_BY_CATEGORY = 'ACTION=PELICULA.FIND_BY_CATEGORY';
    static PELICULA_FIND_BY_TITLE = 'ACTION=PELICULA.FIND_BY_TITLE';
    static PELICULA_ADD = 'ACTION=PELICULA.ADD';

    static async findAll() {
        try {
            const url = `${fetchUtil.URL}${this.PELICULA_FIND_ALL}`;
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

    static async findByCategory(category) {
        try {
            const url = `${fetchUtil.URL}${this.PELICULA_FIND_BY_CATEGORY}&CATEGORY=${category}`;
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

    static async findByTitle(title) {
        try {
            const url = `${fetchUtil.URL}${this.PELICULA_FIND_BY_TITLE}&TITULO=${title}`;
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

    static async add(pelicula) {
    try {
        const params = new URLSearchParams({
            TITULO: pelicula.titulo,
            ANIO: pelicula.anio,
            ID_CATEGORIA: pelicula.id_categoria
        });

        const url = `${fetchUtil.URL}${this.PELICULA_ADD}&${params.toString()}`;
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error('Error al añadir la película');
        }

        return await response.json();
    } catch (error) {
        console.error("Error al añadir película:", error);
        return { success: false, message: error.message };
    }
}

}