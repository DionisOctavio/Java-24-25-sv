import { MusicaService } from "./api/musicService.js";

const contenedorMusica = document.getElementById("musica");
const inputBuscar = document.getElementById("buscar-titulo-input");
const botonBuscar = document.getElementById("btn-buscar-titulo");

window.addEventListener("load", async () => {
  const lista = await MusicaService.find();
  renderMusica(lista);
});


botonBuscar.addEventListener("click", async () => {
  const texto = inputBuscar.value.trim();
  const resultados = await MusicaService.findByTitle(texto);
  renderMusica(resultados);
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