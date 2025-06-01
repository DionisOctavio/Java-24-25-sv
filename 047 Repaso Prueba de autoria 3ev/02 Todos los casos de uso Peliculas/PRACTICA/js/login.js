import { UserService } from "../js/service/userService.js";

document.addEventListener("DOMContentLoaded", () => {
    const btnLogin = document.getElementById("btnLogin");

    btnLogin.addEventListener("click", async () => {

        const user = document.getElementById("user").value;
        const password = document.getElementById("password").value;

        const usuario = await UserService.login(user, password);

        console.log("Usuario recibido:", usuario); // 👈 para depurar

        if (usuario){
            // 🧠 Aquí es donde debes guardar en localStorage
            localStorage.setItem("usuario", JSON.stringify(usuario));

            alert(`Bienvenido ${usuario.NOMBRE} ${usuario.APELLIDOS}`);
            window.location.href = "index.html";
        } else {
            alert("Usuario o contraseña incorrectos");
        }
    });
});
