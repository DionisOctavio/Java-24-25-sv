import { PeliculasRepository } from "../repository/peliculaRepository.js";

export class PeliculaService {
    static async findAll() {
        return await PeliculasRepository.findAll();
    }

    static async findByCategory(category) {
        return await PeliculasRepository.findByCategory(category);
    }

    static async findByTitle(title) {
        return await PeliculasRepository.findByTitle(title);
    }

    static async add(pelicula) {
        return await PeliculasRepository.add(pelicula);
    }
}