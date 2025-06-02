import { EquipoRepository } from '../repository/equipoRepository.js';

export class EquipoService {

    static async listarEquipos() {
        return await EquipoRepository.getAllEquipos();
    }

    static async searchAndCategory(category, search){
        return await EquipoRepository.searchAndCategory(category, search)
    }
}

