import { MusicRepository } from '../repository/musicaRepository.js';

export class MusicaService {
    static async findByTitle(search) {
        return await MusicRepository.findByTitle(search);
    }

    static async find() {
        return await MusicRepository.find();
    }
}

