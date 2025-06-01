import { CategoriaRepository } from "../repository/categoriaRepository.js";

export class CategoriaService {
    static async findAll() {
        return await CategoriaRepository.findAll();
    }
}