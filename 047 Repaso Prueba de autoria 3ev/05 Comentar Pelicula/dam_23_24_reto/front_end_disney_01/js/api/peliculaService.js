import { PeliculasRepository } from "../repository/peliculaRepository.js";

export class PeliculaService {
    static async findAll(pelicula) {
        return await PeliculasRepository.findAll(pelicula);
    }
}