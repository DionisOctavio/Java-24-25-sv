import { CategoriaRepository } from '../repository/categoriaRepository.js';

export class CategoriaService {

    static async listarCategorias() {
        return await CategoriaRepository.getAllCategorias();
    }
}