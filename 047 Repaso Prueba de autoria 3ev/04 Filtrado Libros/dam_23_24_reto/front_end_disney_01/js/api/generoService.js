import { GeneroRepository } from '../repository/generoRepository.js';

export class GeneroService {

    static async find() {
        return await GeneroRepository.find();
    }
}

