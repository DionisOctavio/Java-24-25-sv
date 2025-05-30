import { LibroRepository } from '../repository/libroRepository.js';

export class LibroService {

    static async find() {
        return await LibroRepository.find();
    }
    static async findByGenero(genero) {
        return await LibroRepository.findByGenero(genero);
    }
}

