import { UserRepository } from "../repository/userRepository.js";

export class UserService {

    static async login(user, password) {
        return await UserRepository.login(user, password);
    }

}