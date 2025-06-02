export class EquipoRepository {

    static async getAllEquipos() {
      try {
        const response = await fetch(`http://localhost:8080/API_JAVA_MYSQL/Controller?ACTION=EQUIPO.FIND_ALL`);
        if (!response.ok) {
          throw new Error("Error al obtener los equipos");
        }
        return await response.json();
      } catch (error) {
        console.error(error);
        return [];
      }
    }

    static async searchAndCategory(category, search) {
        try {
            const response = await fetch(`http://localhost:8080/API_JAVA_MYSQL/Controller?ACTION=EQUIPO.SEARCH_FIND&CATEGORIA=${category}&SEARCH=${search}`);
            if (!response.ok) {
                throw new Error("Error al obtener los datos");
            }
            return await response.json();
        } catch (error) {
            console.error(error);
            return [];
        }
    }

}
  