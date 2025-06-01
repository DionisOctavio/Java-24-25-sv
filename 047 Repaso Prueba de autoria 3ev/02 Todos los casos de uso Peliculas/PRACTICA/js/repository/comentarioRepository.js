import { fetchUtil } from "../util/fetchUtil.js";

export class ComentarioRepository {

    static COMENTARIO_ADD = "ACTION=COMENTARIO.ADD";

  static async addComentario(comentario) {
    try {
      const params = new URLSearchParams({
        texto: comentario.texto,
        id_usuario: comentario.id_usuario,
        id_pelicula: comentario.id_pelicula,
      });

      const url = `${fetchUtil.URL}${this.COMENTARIO_ADD}&${params.toString()}`;

      const response = await fetch(url, {
        method: "POST",
      });

      if (!response.ok) throw new Error("No se pudo enviar el comentario");

      return await response.json();
    } catch (error) {
      console.error("Error en ComentarioRepository:", error);
      return { status: "error", msg: "Error de red o servidor" };
    }
  }

}