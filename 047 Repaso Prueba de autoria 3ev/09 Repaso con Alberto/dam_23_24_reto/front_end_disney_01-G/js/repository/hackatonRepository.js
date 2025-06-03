export class HackatonRepository {

    static async getHackatones(category, search) {
      try {
        let URL = `http://localhost:8080/API_JAVA_MYSQL/Controller?`;
        let URL_ACTION = `ACTION=HACKATON.FILTER`;
        let URL_CATEGORY = `&CATEGORY=` + category;
        let URL_SEARCH = `&SEARCH=` + search;

        let URL_FIN = URL + URL_ACTION + URL_CATEGORY + URL_SEARCH;
        const response = await fetch(URL_FIN);

        if (!response.ok) {
          throw new Error("Error al obtener los Hackatones");
        }

        return await response.json();
      } catch (error) {
        console.error(error);
        return [];
      }
    }

  }