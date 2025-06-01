import { UserService } from "./api/usuarioService.js";

document.getElementById("btn-login").addEventListener("click", async () => {
    const usuario = document.getElementById("usuario").value;
    const contrasenia = document.getElementById("contrasenia").value;

    const result = await UserService.login(usuario, contrasenia);

    if (result) {
        alert("Login correcto");
        window.location.href = "index.html";
    } else {
        alert("Usuario o contraseña incorrectos");
    }
});
