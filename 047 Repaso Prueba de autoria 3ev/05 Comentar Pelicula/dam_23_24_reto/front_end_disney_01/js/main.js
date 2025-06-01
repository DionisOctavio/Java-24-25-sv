import { PeliculaService } from "./api/peliculaService.js";
import { ComentarioService } from "./api/comentarioService.js";

document.addEventListener("DOMContentLoaded", async () => {
  const select = document.getElementById("pelicula-select");
  const peliculas = await PeliculaService.findAll();
  console.log("Películas cargadas:", peliculas);

  peliculas.forEach(pelicula => {
    const option = document.createElement("option");
    option.value = pelicula.id_pelicula;
    option.textContent = pelicula.nombre;
    select.appendChild(option);
  });
});


document.getElementById("btn-comentar").addEventListener("click", async () => {
  const usuario = JSON.parse(localStorage.getItem("usuario"));
  console.log("Usuario en localStorage:", usuario);

  if (!usuario || !usuario.id_usuario) {
    alert("No estás logueado o falta el ID de usuario.");
    return;
  }

  const id_usuario = usuario.id_usuario;
  const id_pelicula = parseInt(document.getElementById("pelicula-select").value);
  const texto = document.getElementById("comentario-text").value.trim();

  if (!texto) {
    alert("¡Escribe algo, cinéfilo!");
    return;
  }

  const comentario = { id_usuario, id_pelicula, texto };
  const resultado = await ComentarioService.add(comentario);

  if (resultado.status === "ok") {
    alert("¡Comentario enviado!");
    document.getElementById("comentario-text").value = "";
  } else {
    alert("Error al enviar comentario.");
  }
});
