export class CategoriaRepository {

    static async getAllCategorias() {
      try {
        const response = await fetch(`http://localhost:8080/API_JAVA_MYSQL/Controller?ACTION=CATEGORIA.FIND_ALL`);
        if (!response.ok) {
          throw new Error("Error al obtener las categorias");
        }
        return await response.json();
      } catch (error) {
        console.error(error);
        return [];
      }
    }

}    