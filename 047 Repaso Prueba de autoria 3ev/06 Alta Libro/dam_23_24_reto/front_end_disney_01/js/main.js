import { MusicaService } from "./api/musicService.js";

const contenedorMusica = document.getElementById("musica");
const inputNombreMusica = document.getElementById("nombre-musica-input");
const botonAddMusica = document.getElementById("btn-add-musica");

window.addEventListener("load", async () => {
  const lista = await MusicaService.find();
  renderMusica(lista);
});

botonAddMusica.addEventListener("click", async () => {
  const nombre = inputNombreMusica.value.trim();

  if (!nombre) {
    alert("Introduce un nombre de canción válido.");
    return;
  }

  const respuesta = await MusicaService.add(nombre);

  if (respuesta.success) {
    const nuevaLista = await MusicaService.find();
    renderMusica(nuevaLista);
    inputNombreMusica.value = "";
  } else {
    alert("Error al añadir la canción: " + respuesta.message);
  }
});

function renderMusica(listaMusica) {
  contenedorMusica.innerHTML = "";
  listaMusica.forEach((m) => {
    const div = document.createElement("div");
    div.classList.add("cancion");
    div.innerHTML = `<h3>${m.nombre}</h3>`;
    contenedorMusica.appendChild(div);
  });
}
