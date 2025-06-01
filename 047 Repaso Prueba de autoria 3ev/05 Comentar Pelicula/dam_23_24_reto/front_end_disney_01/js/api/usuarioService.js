import { UserRepository } from "../repository/usuarioRepository.js";

export class UserService {

    static async login(usuario, contrasenia) {
        return await UserRepository.login(usuario, contrasenia);
    }

}