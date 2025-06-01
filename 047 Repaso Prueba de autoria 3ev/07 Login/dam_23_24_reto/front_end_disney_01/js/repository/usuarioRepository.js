import { FetchUtil } from "../util/fetchUtil.js";

export class UserRepository {

    static LOGIN_USER = 'ACTION=USUARIO.LOGIN';

    static async login(usuario, contrasenia) {
        try{
            const url = `${FetchUtil.BASE_URL}${this.LOGIN_USER}&USUARIO=${usuario}&CONTRASENIA=${contrasenia}`;
            const response = await fetch(url);
            if (!response.ok) {
                throw new Error('NOT FOUND');
            }
            const data = await response.json();
            if (data) {
                localStorage.setItem('usuario', JSON.stringify(data));
            }
            return data;
        }catch(error){
            console.error("HA habido un error");
            return null;
        }
    }
}