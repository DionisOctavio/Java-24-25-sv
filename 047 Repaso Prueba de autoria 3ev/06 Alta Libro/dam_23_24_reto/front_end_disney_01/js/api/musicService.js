import { MusicRepository } from '../repository/musicaRepository.js';

export class MusicaService {
    static async find() {
        return await MusicRepository.find();
    }

    static async add(nombre) {
        return await MusicRepository.add(nombre);
    }
}
