import { ComentarioRepository } from "../repository/comentarioRepository.js";

export class ComentarioService {
  static async add(comentario) {
    return await ComentarioRepository.addComentario(comentario);
  }
}
