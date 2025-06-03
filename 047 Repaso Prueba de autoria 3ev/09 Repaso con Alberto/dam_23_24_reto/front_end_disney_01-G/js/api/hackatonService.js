import { HackatonRepository } from '../repository/hackatonRepository.js';

export class HackatonService {
    static async listarHackatones(category, search) {
        return await HackatonRepository.getHackatones(category, search);
    }
}